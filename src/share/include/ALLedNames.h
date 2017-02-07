#ifndef _ALLedNames_h_DEFINED
#define _ALLedNames_h_DEFINED

namespace ALNames {

static const std::string BrainLed = "Head/Led";
static const std::string FaceLed ="Face/Led";
static const std::string EarLed ="Ears/Led";
static const std::string LFootLed ="LFoot/Led";
static const std::string RFootLed ="RFoot/Led";
static const std::string ChestLed ="ChestBoard/Led";

static const std::string Green ="/Green";
static const std::string Red ="/Red";
static const std::string Blue ="/Blue";

static const std::string Left ="/Left";
static const std::string Right ="/Right";

static const std::string PositionPostFix = "/Position/Actuator/Value";
static const std::string HardnessPostFix = "/Hardness/Actuator/Value";
static const std::string LedPostFix      = "/Actuator/Value";
static const std::string ValuePostFix    = "/Position/Sensor/Value";
static const std::string ValuePreFix     = "Device/SubDeviceList/";
static const std::string TempValuePostFix= "/Temperature/Sensor/Value";

enum LedColor{
    RED_LED = 0,
    GREEN_LED,
    BLUE_LED
};
enum LedOrientation{
    LEFT_LED = 0,
    RIGHT_LED
};

// NUM_FACE_LEDS refers to how many LEDS there are per eye
static const unsigned int NUM_BRAIN_LEDS = 12;
static const unsigned int NUM_FACE_LEDS  = 8;
static const unsigned int NUM_EAR_LEDS   = 10;
static const unsigned int NUM_FOOT_LEDS  = 1;
static const unsigned int NUM_CHEST_LEDS = 1;

/**
 * The following were added by Wils Dawson on 6/7/12.
 * The ears are broken up into comm and calibration halves where
 * calibration is toward the front of the robot.
 * The eyes are broken up into three parts (top broken in half
 * and bottom is the third segment).
 *   For the right eye, the bottom shows my goal or opp goal,
 *   the top right shows the right goal, the top left shows the left goal
 *   For the left eye, the bottom shows the ball,
 *   the top shows the role.
 */
static const unsigned int NUM_COMM_LEDS = 1;
static const unsigned int NUM_CALIBRATION_LEDS  = 1;
static const unsigned int NUM_BALL_LEDS = 5;
static const unsigned int NUM_GOALBOX_LEDS = NUM_FACE_LEDS - NUM_BALL_LEDS;
static const unsigned int NUM_ROLE_LEDS = NUM_FACE_LEDS;

static const unsigned int NUM_LED_COLORS = 3;
static const unsigned int NUM_LED_ORIENTATIONS = 2;
static const unsigned int NUM_ONE_EYE_LEDS = NUM_LED_COLORS * NUM_FACE_LEDS;

static const unsigned int NUM_UNIQUE_LEDS = 51;

// NUM_RGB_LEDS shows how many lights are in a grouping. An RGB triplet counts
// as one. So if you were to have a group of 5 eye segments it would get a
// 5 in this array.
static const unsigned int NUM_RGB_LEDS[NUM_UNIQUE_LEDS] = {
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 
    1, 1, 1, 1, 1, 1, 1, 1, 
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
    1, 1, 1};

// LED_START_COLOR indicates the start color index for that grouping. LEDs that
// are single-colored (just blue) start at index 2, skipping over red and green.
// LEDs that are multicolored start at index 0, getting red, green, then blue.
// I don't totally get what's going on here, but it has to do with either
// string array indexing or hex color splitting.
static const unsigned int LED_START_COLOR[NUM_UNIQUE_LEDS] ={
    2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
    0, 0, 0, 0, 0, 0, 0, 0, 
    0, 0, 0, 0, 0, 0, 0, 0, 
    2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 
    2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 
    0, 0, 0};

// LED_END_COLOR is the end color index. See above.
static const unsigned int LED_END_COLOR[NUM_UNIQUE_LEDS] ={
    3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
    3, 3, 3, 3, 3, 3, 3, 3, 
    3, 3, 3, 3, 3, 3, 3, 3, 
    3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 
    3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 
    3, 3, 3};

static const std::string brain[NUM_BRAIN_LEDS] = {
    ValuePreFix + BrainLed + std::string("/Front/Right/1") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Front/Right/0") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Middle/Right/0") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Rear/Right/0") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Rear/Right/1") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Rear/Right/2") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Rear/Left/2") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Rear/Left/1") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Rear/Left/0") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Middle/Left/0") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Front/Left/0") + LedPostFix,
    ValuePreFix + BrainLed + std::string("/Front/Left/1") + LedPostFix,
};

static const std::string eye[NUM_LED_ORIENTATIONS][NUM_FACE_LEDS][NUM_LED_COLORS] = {
    /* Eye LEDs Right */
    {
        {
            ValuePreFix + FaceLed + Red + Right + std::string("/0Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Right + std::string("/0Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Right + std::string("/0Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Right + std::string("/45Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Right + std::string("/45Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Right + std::string("/45Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Right + std::string("/90Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Right + std::string("/90Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Right + std::string("/90Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Right + std::string("/135Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Right + std::string("/135Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Right + std::string("/135Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Right + std::string("/180Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Right + std::string("/180Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Right + std::string("/180Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Right + std::string("/225Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Right + std::string("/225Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Right + std::string("/225Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Right + std::string("/270Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Right + std::string("/270Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Right + std::string("/270Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Right + std::string("/315Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Right + std::string("/315Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Right + std::string("/315Deg")+LedPostFix,
        }
    },
    
    /* Eye LEDs Left */
    {
        {
            ValuePreFix + FaceLed + Red + Left + std::string("/0Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Left + std::string("/0Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Left + std::string("/0Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Left + std::string("/45Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Left + std::string("/45Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Left + std::string("/45Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Left + std::string("/90Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Left + std::string("/90Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Left + std::string("/90Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Left + std::string("/135Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Left + std::string("/135Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Left + std::string("/135Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Left + std::string("/180Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Left + std::string("/180Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Left + std::string("/180Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Left + std::string("/225Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Left + std::string("/225Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Left + std::string("/225Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Left + std::string("/270Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Left + std::string("/270Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Left + std::string("/270Deg")+LedPostFix,
        },
        {
            ValuePreFix + FaceLed + Red + Left + std::string("/315Deg")+LedPostFix,
            ValuePreFix + FaceLed + Green + Left + std::string("/315Deg")+LedPostFix,
            ValuePreFix + FaceLed + Blue + Left + std::string("/315Deg")+LedPostFix,
        }
    }
};

static const std::string ear[NUM_LED_ORIENTATIONS][NUM_EAR_LEDS] ={
/* Ear Led Left*/
    {ValuePreFix + EarLed + Left + std::string("/0Deg")+LedPostFix,
     ValuePreFix + EarLed + Left + std::string("/36Deg")+LedPostFix,
     ValuePreFix + EarLed + Left + std::string("/72Deg")+LedPostFix,
     ValuePreFix + EarLed + Left + std::string("/108Deg")+LedPostFix,
     ValuePreFix + EarLed + Left + std::string("/144Deg")+LedPostFix,
     ValuePreFix + EarLed + Left + std::string("/180Deg")+LedPostFix,
     ValuePreFix + EarLed + Left + std::string("/216Deg")+LedPostFix,
     ValuePreFix + EarLed + Left + std::string("/252Deg")+LedPostFix,
     ValuePreFix + EarLed + Left + std::string("/288Deg")+LedPostFix,
     ValuePreFix + EarLed + Left + std::string("/324Deg")+LedPostFix},
/* Ear Led Right*/
    {ValuePreFix + EarLed + Right + std::string("/0Deg")+LedPostFix,
     ValuePreFix + EarLed + Right + std::string("/36Deg")+LedPostFix,
     ValuePreFix + EarLed + Right + std::string("/72Deg")+LedPostFix,
     ValuePreFix + EarLed + Right + std::string("/108Deg")+LedPostFix,
     ValuePreFix + EarLed + Right + std::string("/144Deg")+LedPostFix,
     ValuePreFix + EarLed + Right + std::string("/180Deg")+LedPostFix,
     ValuePreFix + EarLed + Right + std::string("/216Deg")+LedPostFix,
     ValuePreFix + EarLed + Right + std::string("/252Deg")+LedPostFix,
     ValuePreFix + EarLed + Right + std::string("/288Deg")+LedPostFix,
     ValuePreFix + EarLed + Right + std::string("/324Deg")+LedPostFix},
};

static const std::string foot[NUM_LED_ORIENTATIONS][NUM_LED_COLORS]={
/* Foot Led Left*/
    {ValuePreFix +LFootLed + Red +LedPostFix,
     ValuePreFix +LFootLed + Green +LedPostFix,
     ValuePreFix +LFootLed + Blue +LedPostFix},
/* Foot Led Right*/
    {ValuePreFix +RFootLed + Red +LedPostFix,
     ValuePreFix +RFootLed + Green +LedPostFix,
     ValuePreFix +RFootLed + Blue +LedPostFix},
};

static const std::string chest[NUM_LED_COLORS]={
/* Chest Led*/
    ValuePreFix +ChestLed + Red +LedPostFix,
    ValuePreFix +ChestLed + Green +LedPostFix,
    ValuePreFix +ChestLed + Blue +LedPostFix
};

static const std::string * RGB_LED_STRINGS[NUM_UNIQUE_LEDS] ={
    &brain[0], //0
    &brain[1], //1
    &brain[2], //2
    &brain[3], 
    &brain[4],
    &brain[5],
    &brain[6],
    &brain[7],
    &brain[8],
    &brain[9],
    &brain[10],
    &brain[11],
    
    &eye[RIGHT_LED][0][0], //12
    &eye[RIGHT_LED][1][0], //13
    &eye[RIGHT_LED][2][0], //14
    &eye[RIGHT_LED][3][0], //15
    &eye[RIGHT_LED][4][0], //16
    &eye[RIGHT_LED][5][0], //17
    &eye[RIGHT_LED][6][0], //18
    &eye[RIGHT_LED][7][0], //19

    &eye[LEFT_LED][0][0], //0x14
    &eye[LEFT_LED][1][0],
    &eye[LEFT_LED][2][0],
    &eye[LEFT_LED][3][0],
    &eye[LEFT_LED][4][0],
    &eye[LEFT_LED][5][0],
    &eye[LEFT_LED][6][0],
    &eye[LEFT_LED][7][0],

    &ear[RIGHT_LED][0],
    &ear[RIGHT_LED][1],
    &ear[RIGHT_LED][2],
    &ear[RIGHT_LED][3],
    &ear[RIGHT_LED][4],
    &ear[RIGHT_LED][5],
    &ear[RIGHT_LED][6],
    &ear[RIGHT_LED][7],
    &ear[RIGHT_LED][8],
    &ear[RIGHT_LED][9],

    &ear[LEFT_LED][0],
    &ear[LEFT_LED][1],
    &ear[LEFT_LED][2],
    &ear[LEFT_LED][3],
    &ear[LEFT_LED][4],
    &ear[LEFT_LED][5],
    &ear[LEFT_LED][6],
    &ear[LEFT_LED][7],
    &ear[LEFT_LED][8],
    &ear[LEFT_LED][9],

    &chest[0],
    &foot[RIGHT_LED][0],
    &foot[LEFT_LED][0]
};

};

#endif
