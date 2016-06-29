#
# All of the constants used for the Goalie
# are kept here.
#

import noggin_constants as constants
from objects import RelRobotLocation, RobotLocation, Location
from math import atan2, degrees

RIGHT = 0
LEFT = 1
UNKNOWN = 2

CENTER_POSE = 0
RIGHT_POSE = 1
LEFT_POSE = 2

EXPECTED_CORNER_DIST_FROM_CENTER = 115.0
EXPECTED_LEFT_CORNER_BEARING_FROM_CENTER = 65.0
EXPECTED_RIGHT_CORNER_BEARING_FROM_CENTER = -65.0

CORNER_DISTANCE_THRESH = 20.0
CORNER_BEARING_THRESH = 15.0

GOALIE_OFFSET = 0.0
BUFFER_THRESH = 10

OVERZEALOUS_ODO = 2.0
STOP_NAV_THRESH = 5.0

BALL_ON_SAFE_THRESH = 50
BALL_SAFE_DISTANCE_THRESH = 350.0

# -----------------------------------
# Crazy new vision system constants:
EXPECTED_SIDE_LINE_R = 90.0
EXPECTED_FRONT_LINE_R = 50.0

EXPECTED_LEFT_LINE_T = 90.0
EXPECTED_RIGHT_LINE_T = 270.0
EXPECTED_FRONT_LINE_T = 5.0
EXPECTED_FRONT_LINE_T_2 = 355.0

T_THRESH = 15.0
R_THRESH = 20.0

MEM_THRESH = 15
CORNER_MEM_THRESH = 30

CLEARIT_DIST_FRONT = 120.0
CLEARIT_DIST_SIDE = 170.0
CLEARIT_DIST_FAR = 160.0

CENTER_POSITION = 1
RIGHT_POSITION = 2
LEFT_POSITION = 3
NOT_IN_POSITION = 0

# SAVING
SAVE_X_VEL_FRONT = -9.0
SAVE_X_VEL = -9.0
SAVE_X_VEL_SIDE = -11.0
SAVE_DIST = 150.0

POSITION_FOR_KICK_DIST = 45.0
SLOW_DOWN_DIST = 60.0

BALL_X_OFFSET = 5
BALL_Y_OFFSET = 3
GOOD_ENOUGH_H = 6

HOME = 0
LEFT = 1
FAR_LEFT = 2
RIGHT = -1
FAR_RIGHT = -2

HOME_POSITION = RobotLocation(constants.FIELD_WHITE_LEFT_SIDELINE_X + 15.0,
                        constants.MIDFIELD_Y,
                        0.0)

LEFT_POSITION = RobotLocation(constants.FIELD_WHITE_LEFT_SIDELINE_X + 10.0,
						HOME_POSITION.y + 35,
						0.0)

FAR_LEFT_POSITION = RobotLocation(constants.FIELD_WHITE_LEFT_SIDELINE_X + 17.0,
						HOME_POSITION.y + 65,
						0.0)

RIGHT_POSITION = RobotLocation(constants.FIELD_WHITE_LEFT_SIDELINE_X + 10.0,
						HOME_POSITION.y - 35,
						0.0)

FAR_RIGHT_POSITION = RobotLocation(constants.FIELD_WHITE_LEFT_SIDELINE_X + 17.0,
						HOME_POSITION.y - 65,
						0.0)



LEFT_SHIFT = RelRobotLocation(5.0, 30.0, 0.0)
RIGHT_SHIFT = RelRobotLocation(5.0, -30.0, 0.0)

# LEFT_SHIFT = RobotLocation(HOME_POSITION.x + 10,
# 						HOME_POSITION.y + 35,
# 						0.0)
# RIGHT_SHIFT = RobotLocation(HOME_POSITION.x,
# 						HOME_POSITION.y - 35,
# 						-15)
