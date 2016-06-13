#include "UNSWalkProvider.h"
#include "Profiler.h"
#include "Common.h"
#include "NaoPaths.h"
#include "Kinematics.h"
#include "SensorTypes.h"

#include <cassert>
#include <string>
#include <iostream>

#include <stdlib.h>

#include "generator/Walk2014Generator.hpp"
#include <cmath>
#include "utils/angles.hpp"
#include "utils/body.hpp"
#include "utils/Logger.hpp"
#include "utils/basic_maths.hpp"
#include "utils/speech.hpp"
#include "touch/FilteredTouch.hpp"
// #include 

namespace man 
{
namespace motion 
{

// NICE AND STRAIGHT LEGS
// const float UNSWalkProvider::INITIAL_BODY_POSE_ANGLES[] {
// 	1.57f, 0.17f, -1.57f, -0.05f,
// 	0.f,0.f,0.f,0.f,0.f,0.f,
// 	0.f,0.f,0.f,0.f,0.f,0.f,
// 	1.57f, -0.17f, 1.57f, 0.05f,
// 	0.f,0.f,
// };

const float UNSWalkProvider::INITIAL_BODY_POSE_ANGLES[] {
	1.57f, 0.17f, -1.57f, -0.05f,
	0.0f, 0.0f, -0.44f, 0.98f, -0.55f, 0.0f,
	0.0f, 0.0f, -0.44f, 0.98f, -0.55f, 0.0f,
	1.57f, -0.17f, 1.57f, 0.05f,
	0.f,0.f,
};

// Runswift takes walk commands in MM, we use CM
const float MM_PER_CM  = 10.0;

/*
*NBites joint order. commented out joints are the ones that UNSW has but we dont use
*/
static const Joints::JointCode nb_joint_order[] {
		Joints::HeadYaw,
      	Joints::HeadPitch,
      	Joints::LShoulderPitch,
		Joints::LShoulderRoll,
		Joints::LElbowYaw,
		Joints::LElbowRoll,
		Joints::LHipYawPitch,
		Joints::LHipRoll,
		Joints::LHipPitch,
		Joints::LKneePitch,
		Joints::LAnklePitch,
		Joints::LAnkleRoll,
		// Joints::RHipYawPitch,
		Joints::RHipRoll,
		Joints::RHipPitch,
		Joints::RKneePitch,
		Joints::RAnklePitch,
		Joints::RAnkleRoll,
		Joints::RShoulderPitch,
		Joints::RShoulderRoll,
		Joints::RElbowYaw,
		Joints::RElbowRoll
		// Joints::LWristYaw,
		//LHand,
		//RWristYaw,
		//RHand,
  };

UNSWalkProvider::UNSWalkProvider() : MotionProvider(WALK_PROVIDER), 
 									 requestedToStop(false), tryingToWalk(false) 
{
	std::cout << "Constructing walk provider!\n";
	generator =  new ClippedGenerator((Generator*) new DistributedGenerator());
	odometry = new Odometry();
	joints = new JointValues();
	imuAdjuster = new IMUAdjuster();
	// Touch* nullTouch = (Touch*) new NullTouch();
	touch = (Touch*) new FilteredTouch();
    ((FilteredTouch*)touch)->NBSetOptions();
	
	resetAll();
}

UNSWalkProvider::~UNSWalkProvider()
{
	delete generator;
	delete odometry;
	delete &joints;
	delete startOdometry;
	delete imuAdjuster;
}

void UNSWalkProvider::resetAll() {
	inactive();
	generator->reset();
	resetOdometry();
	//reset odometry through walk2014gen
	//reset other parts of walk2014gen
}

bool UNSWalkProvider::calibrated() const {
	// std::cout << "not calibrated!!" << std::endl;
	// imuAdjuster->findAvgOffset(sensorInertials.gyr_x(), sensorInertials.gyr_y());
	return imuAdjuster->isDone();
	// return false;
}

void UNSWalkProvider::adjustIMU(const ::messages::InertialState&	sensorInertials) {
	imuAdjuster->findAvgOffset(sensorInertials.gyr_x(), sensorInertials.gyr_y(), 
		sensorInertials.acc_x(), sensorInertials.acc_y(), sensorInertials.acc_z());
}

bool UNSWalkProvider::upright() const {
	return true;
}

float UNSWalkProvider::leftHandSpeed() const {
	return NULL;
}

float UNSWalkProvider::rightHandSpeed() const {
	return NULL;
}

void UNSWalkProvider::requestStopFirstInstance() {
	requestedToStop = true;
}

bool hasLargerMagnitude(float x, float y) {
	if (y > 0.0f) {
		return x > y;
	}
	if (y < 0.0f) {
		return x < y;
	}
	return true;
}

bool hasPassed(Odometry& odo1, Odometry& odo2) {
	return (hasLargerMagnitude(odo1.forward, odo2.forward) &&
		hasLargerMagnitude(odo1.left, odo2.left) &&
		hasLargerMagnitude(odo1.turn, odo2.turn));
}

void UNSWalkProvider::calculateNextJointsAndStiffnesses(
	std::vector<float>& 			sensorAngles,
	std::vector<float>& 			sensorCurrents,
	const ::messages::InertialState&  sensorInertials,
	const ::messages::FSR& 			sensorFSRs
	) 
{
	PROF_ENTER(P_WALK);
	// logMsg("\n");

	ActionCommand::All* request = new ActionCommand::All();
	request->body.actionType = ActionCommand::Body::WALK;


	// if (!calibrated()) { logMsg("not calibrated");} 
	// else {logMsg("calibrated!!!"); }


	if (standby) {
		tryingToWalk = false;
	} else {
		if (requestedToStop || !isActive()) {
			tryingToWalk = false;
			logMsg("requested to stop or is not active");
		} else if (currentCommand.get() && currentCommand->getType() == MotionConstants::STEP) {
			logMsg("STEP command! Odometry walk!");

			StepCommand::ptr command = boost::shared_static_cast<StepCommand>(currentCommand);
			Odometry deltaOdometry = odometry - startOdometry;
			Odometry absoluteTarget = Odometry(command->x_mms, command->y_mms, command->theta_rads);
			Odometry relativeTarget = absoluteTarget - (deltaOdometry); 

			if (!hasPassed(deltaOdometry, absoluteTarget)) { // not reached target yet

				request->body.forward = relativeTarget.forward / MM_PER_CM;
				request->body.left = relativeTarget.left / MM_PER_CM;
				request->body.turn = relativeTarget.turn;
			} else {
				tryingToWalk = false;
				request->body.actionType = ActionCommand::Body::STAND;

			}



			// TODO odometry, handle
		} else if (currentCommand.get() && currentCommand->getType() == MotionConstants::WALK) {
			logMsg("Walk command - Walking!");
		 	float WALK_SPEED_SCALE = 1000.0;
			// HANDLE
			tryingToWalk = true;

			WalkCommand::ptr command = boost::shared_static_cast<WalkCommand>(currentCommand);
			std::cout << "Walk Command: " << command->x_percent << "," << command->y_percent << "," << command->theta_percent << ") \n";
			request->body.forward = command->x_percent * WALK_SPEED_SCALE ;
			request->body.left = command->y_percent * WALK_SPEED_SCALE;
			request->body.turn = command->theta_percent ;
			std::cout << "FORWARD: " << request->body.forward << std::endl;
			request->body.speed = 0.0f;

		} else if (currentCommand.get() && currentCommand->getType() == MotionConstants::DESTINATION) {
			logMsg("Destination command - Destination Walking!");
			tryingToWalk = true;

			DestinationCommand::ptr command = boost::shared_static_cast<DestinationCommand>(currentCommand);
			request->body.forward = command->x_mm;
			request->body.left = 0.0; //command->y_mm;
			request->body.turn = command->theta_rads;
			std::cout << "Dest Command: " << command->x_mm << "," << command->y_mm << "," << command->theta_rads << ") \n";
			// TODO incorporate motion kicks


		} else if (currentCommand.get() && currentCommand->getType() == MotionConstants::KICK) {
			logMsg("Kick command sent now!");
			tryingToWalk = false;

		} else if (!currentCommand.get()) {
			logMsg("Can't get current command! Requesting stand");
			tryingToWalk = false;
			// call stand
			request->body.actionType = ActionCommand::Body::STAND;
		}

		// TODO handle kick
	}
	request->body.speed = 0.0f;
	adjustIMU(sensorInertials);

	// request->body.forward = 350;
	// request->body.left = 0.0; 
	// request->body.turn = 0.0; 

	std::cout << "[WALK PROVIDER] Odometry: forward: " << odometry->forward << " left: " << odometry->left << " turn: " << odometry->turn << std::endl;
	// request->body.forward = 600.0; //command->x_percent ;
	// request->body.left = 00.0; //command->y_percent ;
	// request->body.turn = 0.0; //UNSWDEG2RAD(90.0); //command->theta_percent ;
	// request->body.speed = 0.0f;

	// For testing stand action
	// logMsg("Can't get current command! Requesting stand");
	// request->body.actionType = ActionCommand::Body::STAND;


	// Update sensor values
	UNSWSensorValues sensors = new UNSWSensorValues();
	sensors.joints = joints;

	// I think something is amiss with the sensors
	// logMsg("Testing sensor ish");
	// TODO check this!!
	// sensors.sensors[Sensors::InertialSensor_GyrX] = -sensorInertials.gyr_x() * 0.01;
 //    sensors.sensors[Sensors::InertialSensor_GyrY] = -sensorInertials.gyr_y() * 0.01;
	sensors.sensors[Sensors::InertialSensor_GyrX] = sensorInertials.gyr_x();
    sensors.sensors[Sensors::InertialSensor_GyrY] = sensorInertials.gyr_y();
 //    sensors.sensors[Sensors::InertialSensor_GyrZ] = sensorInertials.gyr_z(); // they don't use this

    sensors.sensors[Sensors::InertialSensor_AccX] = sensorInertials.acc_x() * 0.01;
    sensors.sensors[Sensors::InertialSensor_AccY] = sensorInertials.acc_y() * 0.01;
    sensors.sensors[Sensors::InertialSensor_AccZ] = sensorInertials.acc_z() * 0.01;

    // sensors.sensors[Sensors::InertialSensor_AngleX] = -RAD2DEG(sensorInertials.angle_x());
    // sensors.sensors[Sensors::InertialSensor_AngleY] = -RAD2DEG(sensorInertials.angle_y());
    // TODO check this too!! I think filteredTouch needs RAW sensor values, but I'm NOT SURE
    sensors.sensors[Sensors::InertialSensor_AngleX] = sensorInertials.angle_x();
    sensors.sensors[Sensors::InertialSensor_AngleY] = sensorInertials.angle_y();

    // std::cout << "InertialSensor_AngleX: " << -RAD2DEG(sensorInertials.angle_x()) << ", InertialSensor_AngleY: " << -RAD2DEG(sensorInertials.angle_y()) << std::endl;
    // std::cout << "InertialSensor_GyrX: " << sensorInertials.gyr_x() << ", InertialSensor_GyrY: " << sensorInertials.gyr_y() << std::endl;
    // std::cout << "InertialSensor_AccX: " << sensorInertials.acc_x() << ", InertialSensor_AccY: " << sensorInertials.acc_y() << ", InertialSensor_AccZ: " << sensorInertials.acc_z() << std::endl;
    
    imuAdjuster->adjustIMUs(sensorInertials.gyr_x(), sensorInertials.gyr_y(), sensorInertials.acc_x(),
    	sensorInertials.acc_y(), sensorInertials.acc_z());
    float adjGyrX = imuAdjuster->getGyrX();
    float adjGyrY = imuAdjuster->getGyrY();

    float adjAccX = imuAdjuster->getAccX();
    float adjAccY = imuAdjuster->getAccY();
    float adjAccZ = imuAdjuster->getAccZ();

    // std::cout << "ADJUSTED InertialSensor_GyrX: " << adjGyrX << ", InertialSensor_GyrY: " << adjGyrY << std::endl;
    // std::cout << "ADJUSTED InertialSensor_AccX: " << adjAccX << ", InertialSensor_AccY: " << adjAccY << ", InertialSensor_AccZ: " << adjAccZ << std::endl;

    // std::cout << "InertialSensor_AccX: " << sensorInertials.acc_x() << ", InertialSensor_AccY: " << sensorInertials.acc_y() << std::endl;
    
    // std::cout << "InertialSensor_AngleX: " << -RAD2DEG(sensorInertials.angle_x()) << ", InertialSensor_AngleY: " << -RAD2DEG(sensorInertials.angle_y()) << std::endl;
    // sensors.sensors[Sensors::angleZ] = sensorInertials.angle_z(); // this either

    sensors.sensors[Sensors::LFoot_FSR_FrontLeft] = sensorFSRs.lfl();
    sensors.sensors[Sensors::LFoot_FSR_FrontRight] = sensorFSRs.lfr();
    sensors.sensors[Sensors::LFoot_FSR_RearLeft] = sensorFSRs.lrl();
    sensors.sensors[Sensors::LFoot_FSR_RearRight] = sensorFSRs.lrr();

    sensors.sensors[Sensors::RFoot_FSR_FrontLeft] = sensorFSRs.rfl();
    sensors.sensors[Sensors::RFoot_FSR_FrontRight] = sensorFSRs.rfr();
    sensors.sensors[Sensors::RFoot_FSR_RearLeft] = sensorFSRs.rrl();
    sensors.sensors[Sensors::RFoot_FSR_RearRight] = sensorFSRs.rrr();

    // for (int i = 0; i < 21; i++) {
    // 	sensors.joints.angles[nb_joint_order[i]] = sensorAngles[i];
    // }

    // Ughhhh idk

    sensors.joints.angles[Joints::LShoulderPitch] = sensorAngles[sensors::LShoulderPitch];
    sensors.joints.angles[Joints::LShoulderRoll] = sensorAngles[sensors::LShoulderRoll];
    sensors.joints.angles[Joints::LElbowYaw] = sensorAngles[sensors::LElbowYaw];
    sensors.joints.angles[Joints::LElbowRoll] = sensorAngles[sensors::LElbowRoll];
    // sensors.joints.angles[Joints::LWristYaw] = sensorAngles[sensors::LShoulderPitch];
    // sensors.joints.angles[Joints::LHand] = sensorAngles[sensors::LShoulderPitch];
    
    sensors.joints.angles[Joints::LHipYawPitch] = sensorAngles[sensors::LHipYawPitch];
    sensors.joints.angles[Joints::LHipRoll] = sensorAngles[sensors::LHipRoll];
    sensors.joints.angles[Joints::LHipPitch] = sensorAngles[sensors::LHipPitch];
    sensors.joints.angles[Joints::LKneePitch] = sensorAngles[sensors::LKneePitch];
    sensors.joints.angles[Joints::LAnklePitch] = sensorAngles[sensors::LAnklePitch];
    sensors.joints.angles[Joints::LAnkleRoll] = sensorAngles[sensors::LAnkleRoll];
    
    sensors.joints.angles[Joints::RHipRoll] = sensorAngles[sensors::RHipRoll];
    sensors.joints.angles[Joints::RHipPitch] = sensorAngles[sensors::RHipPitch];
    sensors.joints.angles[Joints::RKneePitch] = sensorAngles[sensors::RKneePitch];
    sensors.joints.angles[Joints::RAnklePitch] = sensorAngles[sensors::RAnklePitch];
    sensors.joints.angles[Joints::RAnkleRoll] = sensorAngles[sensors::RAnkleRoll];

    sensors.joints.angles[Joints::RShoulderPitch] = sensorAngles[sensors::RShoulderPitch];
    sensors.joints.angles[Joints::RShoulderRoll] = sensorAngles[sensors::RShoulderRoll];
    sensors.joints.angles[Joints::RElbowYaw] = sensorAngles[sensors::RElbowYaw];
    sensors.joints.angles[Joints::RElbowRoll] = sensorAngles[sensors::RElbowRoll];
    // sensors.joints.angles[Joints::RWristYaw] = sensorAngles[sensors::LShoulderPitch];
    // sensors.joints.angles[Joints::RHand] = sensorAngles[sensors::LShoulderPitch];









    // ughhh

    // ((FilteredTouch*)touch)->NBSetOptions();

    UNSWSensorValues filteredSensors = ((FilteredTouch*)touch)->getSensors(kinematics, sensors);
    // std::cout << "FILTERED InertialSensor_GyrX: " << filteredSensors.sensors[Sensors::InertialSensor_GyrX] << ", InertialSensor_GyrY: " << filteredSensors.sensors[Sensors::InertialSensor_GyrX] << std::endl;

    sensors = filteredSensors;
	// sensors.sensors[Sensors::InertialSensor_GyrX] = filteredSensors.sensors[Sensors::InertialSensor_GyrX] * 0.01;
 //    sensors.sensors[Sensors::InertialSensor_GyrY] = filteredSensors.sensors[Sensors::InertialSensor_GyrY] * 0.01;

	sensors.sensors[Sensors::InertialSensor_GyrX] = adjGyrX * 0.01;
    sensors.sensors[Sensors::InertialSensor_GyrY] = adjGyrY * 0.01;

    // sensors.sensors[Sensors::InertialSensor_AccX] = adjAccX * 0.01;
    // sensors.sensors[Sensors::InertialSensor_AccY] = adjAccY * 0.01;



	// TODO investigate calibrating sensors. . .
	// if(request.body.actionType == Body::MOTION_CALIBRATE){
 //       // raw sensor values are sent to offnao for calibration
 //       // these values are straight forward copy paste into pos files
 //       sensors = nakedTouch->getSensors(kinematics);
 //       sensors.sensors[Sensors::InertialSensor_AngleX] = -RAD2DEG(sensors.sensors[Sensors::InertialSensor_AngleX]);
 //       sensors.sensors[Sensors::InertialSensor_AngleY] = -RAD2DEG(sensors.sensors[Sensors::InertialSensor_AngleY]);
 //       sensors.sensors[Sensors::InertialSensor_GyrX] = -sensors.sensors[Sensors::InertialSensor_GyrX];
 //       sensors.sensors[Sensors::InertialSensor_GyrY] = -sensors.sensors[Sensors::InertialSensor_GyrY];
 //   } else {
    // sensors = touch->getSensors(kinematics);


	// Update kinematics TODO sensors lagging ? ?
	// TODO kinematics parameters? - move these..., also hopefully right units
	kinematics.setSensorValues(sensors);
	kinematics.parameters.cameraYawTop = Kinematics::CAMERA_TOP_OFF_Z;
	kinematics.parameters.cameraPitchTop = Kinematics::CAMERA_TOP_PITCH_ANGLE;
	kinematics.parameters.cameraRollTop = Kinematics::CAMERA_TOP_OFF_X;

	kinematics.parameters.cameraYawBottom = Kinematics::CAMERA_BOTTOM_OFF_Z;
	kinematics.parameters.cameraPitchBottom = Kinematics::CAMERA_BOTTOM_PITCH_ANGLE;
	kinematics.parameters.cameraRollBottom = Kinematics::CAMERA_BOTTOM_OFF_X;
	kinematics.updateDHChain();

	// Get the position of the ball in robot relative cartesian coordinates
	// Is this necessary for our system? 
	float ballX = 5.0;
	float ballY = 5.0;

    // Update the body model
    // logMsg("Updating body model");
    bodyModel.kinematics = &kinematics;
    bodyModel.update(odometry, sensors);


	// TODO figure out how to tell if we are standing this seems important
	// if (standing) {
	// 	generator->reset();
	// 	request.body = ActionCommand::Body::INITIAL;
	// 	odometry.clear();
	// }

    const float* angles = NULL;
    const float* hardness = NULL;

    joints = generator->makeJoints(request, odometry, sensors, bodyModel, ballX, ballY);

    angles = joints.angles;
    hardness = joints.stiffnesses;

    // for (uint8_t i = 0; i < Joints::NUMBER_OF_JOINTS; ++i) {

	   //    std::cout << "WALK PROVIDER: Joint " << Joints::jointNames[i] << " angle: " << angles[i] << " stiffness: " << joints.stiffnesses[i] << std::endl;
    // }

    // THIS IS WHERE WE ACTUALLY SET THE NEXT JOINTS AND STIFFNESSES
    // Ignore the first chain bc it's the head

    const float NOD_GYRO_RATIO = 0.04f;
    // THIS is better off.... do not turn this adjustment thing on... makes it worse
    float adjAngleX = 0.0; //adjGyrX * 0.01 * NOD_GYRO_RATIO;
    float adjAngleY = 0.0; //adjGyrY * 0.01 * NOD_GYRO_RATIO;
    for (unsigned i = 1; i < Kinematics::NUM_CHAINS; i++) {
    	std::vector<float> chain_angles;
    	std::vector<float> chain_hardness;
    	for (unsigned j = Kinematics::chain_first_joint_UNSWALK[i]; j <= Kinematics::chain_last_joint_UNSWALK[i]; j++) {

    		if ((Kinematics::ChainID)i == Kinematics::RLEG_CHAIN && j == 11) {
    			// RHIPYAWPITCH
    			chain_angles.push_back(joints.angles[nb_joint_order[6]]);
    			// logMsg("SPECIAL CASE: used " + Joints::jointNames[nb_joint_order[6]]);
    		} 
    		// else if (nb_joint_order[j] == Joints::LHipPitch) {
    		// 	logMsg("Special case! used nod gyro ratio for: " + Joints::jointNames[nb_joint_order[j]]);
    		// 	std::cout << "adjAngleX: " << adjAngleX << " adjAngleY: " << adjAngleY << std::endl;
    		// 	std::cout << "LHipPitch: " << joints.angles[nb_joint_order[j]] << std::endl;
	    	// 	chain_angles.push_back(joints.angles[nb_joint_order[j]] + adjAngleX); // TODO I think this should be a lot more complicated than it seems right now...

    		// }
    		// else if (nb_joint_order[j] == Joints::RHipPitch) {
    		// 	logMsg("Special case! used nod gyro ratio for: " + Joints::jointNames[nb_joint_order[j]]);
	    	// 	chain_angles.push_back(joints.angles[nb_joint_order[j]] + adjAngleX);
    		// 	std::cout << "RHipPitch: " << joints.angles[nb_joint_order[j]] << std::endl;
    			
    		// } 
    		// else if (nb_joint_order[j] == Joints::LAnklePitch) {
    		// 	logMsg("Special case! used nod gyro ratio for: " + Joints::jointNames[nb_joint_order[j]]);
    		// 	std::cout << "adjAngleX: " << adjAngleX << " adjAngleY: " << adjAngleY << std::endl;
    		// 	std::cout << "LAnklePitch: " << joints.angles[nb_joint_order[j]] << std::endl;
	    	// 	chain_angles.push_back(joints.angles[nb_joint_order[j]] - adjAngleX); // TODO I think this should be a lot more complicated than it seems right now...

    		// }
    		// else if (nb_joint_order[j] == Joints::RAnklePitch) {
    		// 	logMsg("Special case! used nod gyro ratio for: " + Joints::jointNames[nb_joint_order[j]]);
	    	// 	chain_angles.push_back(joints.angles[nb_joint_order[j]] - adjAngleX);
    		// 	std::cout << "RAnklePitch: " << joints.angles[nb_joint_order[j]] << std::endl;
    			
    		// }
    		else {
	    		chain_angles.push_back(joints.angles[nb_joint_order[j]]); // TODO I think this should be a lot more complicated than it seems right now...
    		}

    		
   //  		logMsgNoEL("ANGLE in "  + Joints::jointNames[nb_joint_order[j]] + " = ");
			// std::cout << RAD2DEG(joints.angles[nb_joint_order[j]]);
			// // std::cout << (joints.angles[nb_joint_order[j]]);



    		if (hardness[nb_joint_order[j]] == 0) {
				// JUST PUSH BACK 1 so arms move
				chain_hardness.push_back(1.0);
    			// chain_hardness.push_back(MotionConstants::NO_STIFFNESS);
    		} else {
    			chain_hardness.push_back(joints.stiffnesses[nb_joint_order[j]]);
    		}
    		// std::cout << " STIFFNESS: " << joints.stiffnesses[nb_joint_order[j]] << std::endl;
    	}

    	this->setNextChainJoints((Kinematics::ChainID)i, chain_angles);
    	this->setNextChainStiffnesses((Kinematics::ChainID)i, chain_hardness);

    }

    // We only leave when we do a sweet move, so request a special action
    if (requestedToStop) {
    	logMsg("Requested to stop");
    	inactive();
    	requestedToStop = false;
    	resetOdometry();
    }

	PROF_EXIT(P_WALK);
}

void UNSWalkProvider::hardReset() {
	generator->reset();
}

void UNSWalkProvider::resetOdometry() {
	odometry->clear();
}

void UNSWalkProvider::setCommand(const WalkCommand::ptr command) {
	if (command->theta_percent == 0 && command->x_percent == 0 && command->y_percent == 0) {
		this->stand();
		return;
	}

	currentCommand = command;
	active();

}

void UNSWalkProvider::setCommand(const DestinationCommand::ptr command) {
	currentCommand = command;

	startOdometry = odometry;

	active();
}

void UNSWalkProvider::setCommand(const StepCommand::ptr command) {
	currentCommand = command;
	active();


}

void UNSWalkProvider::setCommand(const KickCommand::ptr command) {
	currentCommand = command;
	active();
}

void UNSWalkProvider::getOdometryUpdate(portals::OutPortal< ::messages::RobotLocation>& out) const {
	portals::Message< ::messages::RobotLocation> odometryData(0);
	odometryData.get()->set_x(odometry->forward * MM_TO_CM);
	odometryData.get()->set_y(odometry->left * MM_TO_CM);
	odometryData.get()->set_h(odometry->turn * MM_TO_CM);
	out.setMessage(odometryData);
}

bool UNSWalkProvider::isStanding() const { //is going to stand rather than at complete standstill
	return generator->isStanding(); //1 corresponds to process of moving from WALK crouch to STAND
}

bool UNSWalkProvider::isWalkActive() const {
	return generator->isActive();
}

void UNSWalkProvider::stand() {

}


// void UNSWalkProvider::restingStand()
// {

// }

}

}