from . import TrackingConstants as constants
from ..util import MyMath as MyMath
from .. import StiffnessModes
from math import fabs, degrees
import HeadMoves
import math

class HeadTrackingHelper(object):
    def __init__(self, tracker):
        self.tracker = tracker

    def executeHeadMove(self, headMove):
        """performs a sweetmove"""
        # Note: Do not call every frame!
        command = self.tracker.brain.interface.headMotionCommand
        command.type = command.CommandType.SCRIPTED_HEAD_COMMAND

        for position in headMove:
            if len(position) == 4:
                move = command.scripted_command.add_command()

                # Set most recent command
                move.time = position[1]
                if position[2] == 1:
                    move.interpolation = move.InterpolationType.LINEAR
                else:
                    move.interpolation = move.InterpolationType.SMOOTH

                # Only set the head angles
                move.angles.head_yaw   = position[0][0]
                move.angles.head_pitch = position[0][1]

                # Set all stiffnesses, since this command specifies them all
                move.stiffness.head_yaw =         position[3][0]
                move.stiffness.head_pitch =       position[3][1]

                move.stiffness.l_shoulder_pitch = position[3][2]
                move.stiffness.l_shoulder_roll =  position[3][3]
                move.stiffness.l_elbow_yaw =      position[3][4]
                move.stiffness.l_elbow_roll =     position[3][5]

                move.stiffness.r_shoulder_pitch = position[3][18]
                move.stiffness.r_shoulder_roll =  position[3][19]
                move.stiffness.r_elbow_yaw =      position[3][20]
                move.stiffness.r_elbow_roll =     position[3][21]

                move.stiffness.l_hip_yaw_pitch =  position[3][6]
                move.stiffness.l_hip_roll =       position[3][7]
                move.stiffness.l_hip_pitch =      position[3][8]
                move.stiffness.l_knee_pitch =     position[3][9]
                move.stiffness.l_ankle_pitch =    position[3][10]
                move.stiffness.l_ankle_roll =     position[3][11]

                move.stiffness.r_hip_yaw_pitch =  position[3][12]
                move.stiffness.r_hip_roll =       position[3][13]
                move.stiffness.r_hip_pitch =      position[3][14]
                move.stiffness.r_knee_pitch =     position[3][15]
                move.stiffness.r_ankle_pitch =    position[3][16]
                move.stiffness.r_ankle_roll =     position[3][17]

            else:
                self.tracker.printf("What kind of sweet ass-Move is this?")

        command.timestamp = int(self.tracker.brain.time * 1000)
        # Returns the last HJC in the HeadMove for keeping track of
        # when a move is done
        return move

    def startingPan(self, headMove):
        """Calculates the first part of a fixed pitch pan to get there quickly."""
        if len(headMove) < 2:
            # Not a normal pan: there's only 1 headMove.
            # Don't do a starting move.
            return

        headMoveYaw = headMove[1][0][0]
        headMovePitch = headMove[1][0][1]

        #TODO do this math in C++
        curYaw = degrees(self.tracker.brain.interface.joints.head_yaw)
        degreesPerSecond = 80 #fast, but hopefully won't destabilize the walk much
        yawDiff = MyMath.fabs(curYaw - headMoveYaw)
        totalTime = yawDiff/degreesPerSecond

        newHeadMove = ( ((headMoveYaw,headMovePitch), totalTime, 1,
                         StiffnessModes.LOW_HEAD_STIFFNESSES), )

        self.executeHeadMove(newHeadMove)

    #maxRight = maximum negative angle
    #maxLeft = maximum positive angle
    #beginDirection: True = right, False = left
    def boundsSnapPan(self, maxRight, maxLeft, beginDirection = True): #Default right
        """Generates snap pan betwewn two maxima"""

        SNAP_PAN_PAN_TIME = 0.3
        SNAP_PAN_WAIT_TIME = 0.2
        SNAP_TIME_DEGREE_INTERVALS = 45

        curYaw = degrees(self.tracker.brain.interface.joints.head_yaw)

        startingYaw = (((curYaw // (SNAP_TIME_DEGREE_INTERVALS / 2)) + 1) // 2) * SNAP_TIME_DEGREE_INTERVALS

        newSnapPanHeadMove = ()

        if (beginDirection): #Right direction - negative angles

            while (startingYaw > maxRight):

                newSnapPanHeadMove += (((startingYaw, 25), SNAP_PAN_PAN_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
                newSnapPanHeadMove += (((startingYaw, 25), SNAP_PAN_WAIT_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )

                startingYaw -= SNAP_TIME_DEGREE_INTERVALS

            newSnapPanHeadMove += (((maxRight, 25), SNAP_PAN_PAN_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
            newSnapPanHeadMove += (((maxRight, 25), SNAP_PAN_WAIT_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )

        else: #Left direction - positive angles

            while (startingYaw < maxLeft):

                newSnapPanHeadMove += (((startingYaw, 25), SNAP_PAN_PAN_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
                newSnapPanHeadMove += (((startingYaw, 25), SNAP_PAN_WAIT_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )

                startingYaw += SNAP_TIME_DEGREE_INTERVALS

            newSnapPanHeadMove += (((maxLeft, 25), SNAP_PAN_PAN_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
            newSnapPanHeadMove += (((maxLeft, 25), SNAP_PAN_WAIT_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )

            startingYaw -= SNAP_TIME_DEGREE_INTERVALS

            while (startingYaw > maxRight):

                newSnapPanHeadMove += (((startingYaw, 25), SNAP_PAN_PAN_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
                newSnapPanHeadMove += (((startingYaw, 25), SNAP_PAN_WAIT_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )

                startingYaw -= SNAP_TIME_DEGREE_INTERVALS

        return newSnapPanHeadMove

    def goalieShortRangePan(self):

        GOALIE_SNAP_PAN_SHORT_PAN_TIME = 0.8
        GOALIE_SNAP_PAN_LONG_PAN_TIME = 1
        GOALIE_SNAP_PAN_WAIT_TIME = 0.5
        # GOALIE_SNAP_PAN_LONG_WAIT_TIME = 0.5

        numberOfIntermediatePans = 5

        newGoalieSnapPanHeadMove = ()

        newGoalieSnapPanHeadMove += (((-45.0, 25), GOALIE_SNAP_PAN_SHORT_PAN_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
        newGoalieSnapPanHeadMove += (((-45.0, 25), GOALIE_SNAP_PAN_WAIT_TIME,   1, StiffnessModes.LOW_HEAD_STIFFNESSES), )

        for i in range(0, numberOfIntermediatePans-1):
            newGoalieSnapPanHeadMove += ((( 45.0, 25), GOALIE_SNAP_PAN_SHORT_PAN_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
            newGoalieSnapPanHeadMove += ((( 45.0, 25), GOALIE_SNAP_PAN_WAIT_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
            newGoalieSnapPanHeadMove += (((-45.0, 25), GOALIE_SNAP_PAN_SHORT_PAN_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
            newGoalieSnapPanHeadMove += (((-45.0, 25), GOALIE_SNAP_PAN_WAIT_TIME,   1, StiffnessModes.LOW_HEAD_STIFFNESSES), )

        newGoalieSnapPanHeadMove += ((( 75.0, 25), GOALIE_SNAP_PAN_LONG_PAN_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
        newGoalieSnapPanHeadMove += ((( 75.0, 25), GOALIE_SNAP_PAN_WAIT_TIME,   1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
        newGoalieSnapPanHeadMove += (((-75.0, 25), GOALIE_SNAP_PAN_LONG_PAN_TIME, 1, StiffnessModes.LOW_HEAD_STIFFNESSES), )
        newGoalieSnapPanHeadMove += (((-75.0, 25), GOALIE_SNAP_PAN_WAIT_TIME,   1, StiffnessModes.LOW_HEAD_STIFFNESSES), )

        return newGoalieSnapPanHeadMove

    # Should be generalized.
    def convertKickPan(self, headMove, invert):
        """
        Converts the first step of the kick pan to have the same speed
        as the second step, regardless of starting yaw.
        ASSERT: 2 step headMove.
        """
        headMoveYaw = headMove[0][0][0]
        headMovePitch = headMove[0][0][1]

        curYaw = degrees(self.tracker.brain.interface.joints.head_yaw)
        degreesPerSecond = (headMoveYaw*2)/headMove[0][1] # double the yaw b/c pans are symmetric
        yawDiff = MyMath.fabs(curYaw-headMoveYaw)
        totalTime = yawDiff/degreesPerSecond

        if invert is True:
            newHeadMove = ( ((-1*headMoveYaw,headMovePitch),
                             totalTime, headMove[0][2], headMove[0][3]),
                            ((-1*headMove[1][0][0],headMove[1][0][1]),
                             headMove[1][1], headMove[1][2], headMove[1][3]) )
        else:
            newHeadMove = ( ((headMoveYaw,headMovePitch),
                             totalTime, 1, headMove[0][3]),
                            headMove[1] )

        return newHeadMove

    def trackObject(self):
        """
        Method to actually perform the tracking.
        Should only be called explicitly from state
        methods in TrackingStates.py
        """
        # Note: safe to call every frame.

        target = self.tracker.target

        # print "-------------Tracking Target------------"

        changeX, changeY = 0.0, 0.0

        # If we cannot see the target, abort.
        if not (target # target is null
                or (target.rel_x == 0.0 and target.rel_y == 0.0) # target is under us (info error)
                or (target.vis.frames_off > 0 and target.vis.frames_off < 3)): # off frame, but under thresh
# TODO: use a constant above
            return

        # If we haven't seen the target, look towards loc model.
        if target.vis.frames_off > 30:
# TODO: use a constant above
            self.lookToPoint(target)
# TODO: safeguard above call from errors due to calling every frame
# TODO: use loc information and helper.lookAtTarget instead??
            return

        # Assert: target is visible.

        self.lookAtBallAngle()
        # return

        # # Find the target's angular distance from yaw center.
        # changeX = target.vis.angle_x_deg
        # # ignore changeY: pitch is fixed

        # curYaw   = degrees(self.tracker.brain.interface.joints.head_yaw)
        # maxChange = 13.0

        # # Warning- no gain is applied currently!
        # safeChangeX = MyMath.clip(changeX, -maxChange, maxChange)
        # # ignore safeChangeY: pitch is fixed

        # newYaw = curYaw + safeChangeX
        # # ignore newPitch: pitch is fixed

        # maxSpeed = 2.0 # TODO: use a constant

        # # Set motion message fields
        # command = self.tracker.brain.interface.headMotionCommand
        # command.type = command.CommandType.POS_HEAD_COMMAND

        # command.pos_command.head_yaw = newYaw
        # command.pos_command.head_pitch = constants.FIXED_PITCH_VALUE
        # command.pos_command.max_speed_yaw = maxSpeed
        # command.pos_command.max_speed_pitch = maxSpeed

        # command.timestamp = int(self.tracker.brain.time * 1000)

    def trackStationaryObject(self):
        # Note: safe to call every frame.
        target = self.tracker.target
        changeX, changeY = 0.0, 0.0

        # If we cannot see the target, abort.
        if (not target # target is null
            or (target.frames_off > 0)):
            return

        # Find the target's angular distance from yaw center.
        changeX = target.angle_x_deg
        curYaw  = degrees(self.tracker.brain.interface.joints.head_yaw)

        #WOW this is ugly
        maxChange = 13.0
        maxSpeed = 2.0

        # Warning- no gain is applied currently!
        safeChangeX = MyMath.clip(changeX, -maxChange, maxChange)
        newYaw = curYaw + safeChangeX

        # Set motion message fields
        command = self.tracker.brain.interface.headMotionCommand
        command.type = command.CommandType.POS_HEAD_COMMAND

        command.pos_command.head_yaw = newYaw
        command.pos_command.head_pitch = constants.FIXED_PITCH_VALUE
        command.pos_command.max_speed_yaw = maxSpeed
        command.pos_command.max_speed_pitch = maxSpeed

        command.timestamp = int(self.tracker.brain.time * 1000)

    # Unsafe to call... TODO: CoordHeadCommands for messages.
    def lookAtTarget(self, target):

        '''
        Hacked warning message.
        Method is unsafe to call!!
        '''
        print ("HeadTrackingHelper.lookAtTarget method was called. METHOD IS UNSAFE! Looking in general direction of target in lieu of using target's exact loc values.")
#        self.lookToPoint(target)

        if hasattr(target, "height"):
             height = target.height
        else:
             height = 0

        if hasattr(target, "loc"):
             target = target.loc

        print str(target.rel_x) + " " + str(target.rel_y)

        headMove = self.tracker.brain.motion.CoordHeadCommand(relX = target.rel_x,
                                            relY = target.rel_y,
                                            relZ = height)

        self.tracker.brain.motion.coordHead(headMove)
        return headMove


    def lookToPoint(self, target):
        """
        If the relative y is positive, look left. Otherwise, look right.
        """
        
        if hasattr(target, "height"):
            height = target.height
        else:
            height = 0

        if target.rel_y > 0:
            self.executeHeadMove(HeadMoves.FIXED_PITCH_LOOK_LEFT)
        else:
            self.executeHeadMove(HeadMoves.FIXED_PITCH_LOOK_RIGHT)

    def lookToAngleWithTime(self, yaw, time):

        if yaw > 55 or yaw < -55:
            pitch = 11.0
        else:
            pitch = 17.0

        return (((yaw, pitch),
                 .5, time, StiffnessModes.LOW_HEAD_STIFFNESSES),)

    def lookToAngle(self, yaw):
        """
        Returns a headmove that will make the robot
        look to the given yaw at an appropriate (fixed) pitch.

        Note: Use as parameter for tracker.performHeadMove()
        """
        if yaw > 55 or yaw < -55:
            pitch = 11.0
        else:
            pitch = 17.0

        return (((yaw, pitch),
                 .5, 1, StiffnessModes.LOW_HEAD_STIFFNESSES),)

        # TODO: use constants above 

    def lookAtBallAngle(self):

        curYaw   = degrees(self.tracker.brain.interface.joints.head_yaw)
        ballYaw = self.tracker.brain.ball.bearing_deg

        maxSpeed = 2.0 # TODO: use a constant

        # Set motion message fields
        command = self.tracker.brain.interface.headMotionCommand
        command.type = command.CommandType.POS_HEAD_COMMAND

        if MyMath.fabs(curYaw - ballYaw) < 5:
            command.pos_command.head_yaw = curYaw

        else:
            command.pos_command.head_yaw = ballYaw

        command.pos_command.head_pitch = constants.FIXED_PITCH_VALUE
        command.pos_command.max_speed_yaw = maxSpeed
        command.pos_command.max_speed_pitch = maxSpeed

        command.timestamp = int(self.tracker.brain.time * 1000)

    def lookToXY(self, x, y):
        self.tracker.target.x = x
        self.tracker.target.y = y
        heading = self.tracker.brain.loc.h
        robx = self.tracker.brain.loc.x
        roby = self.tracker.brain.loc.y
        yaw = math.degrees(math.atan((y-roby)/(x-robx)))
        if robx > x:
            if roby < y:
                yaw = 180 + yaw
            else:
                yaw = -180 + yaw
        yaw = yaw - heading
        curYaw  = degrees(self.tracker.brain.interface.joints.head_yaw)
        maxSpeed = 2.0

        # Set motion message fields
        command = self.tracker.brain.interface.headMotionCommand
        command.type = command.CommandType.POS_HEAD_COMMAND

        command.pos_command.head_yaw = yaw
        command.pos_command.head_pitch = constants.FIXED_PITCH_VALUE
        command.pos_command.max_speed_yaw = maxSpeed
        command.pos_command.max_speed_pitch = maxSpeed

        command.timestamp = int(self.tracker.brain.time * 1000)

    def bounceTrackball(self):
        """
        Repeat a dynamic pan around the ball. Should keep the ball
        in sight at all times, but we need careful escape clauses.
        """
        ball = self.tracker.brain.ball
        self.executeHeadMove(self.convertKickPan(HeadMoves.BALLTRACK_PAN(ball.distance, ball.bearing)))

    def printHeadAngles(self):
        print "Current yaw is: " + str(degrees(self.tracker.brain.interface.joints.head_yaw))
        print "Current pitch is: " + str(degrees(self.tracker.brain.interface.joints.head_pitch))

    # Regardless of state, is the head moving?
    def isActive(self):
        return self.tracker.brain.motion.head_is_active
