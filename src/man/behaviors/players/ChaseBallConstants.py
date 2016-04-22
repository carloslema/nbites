from ..navigator import BrunswickSpeeds as speeds

DEBUG_ORBIT = False

# Transitions' Constants
# Ball on and off frame thresholds
BALL_ON_THRESH = 2
BALL_OFF_THRESH = 20
BALL_OFF_KICK_THRESH = 4 # 4 seconds, time threshold!

# should decelerate
SLOW_CHASE_DIST = 60.

# Should position for kick
BALL_PFK_LEFT_Y = 16.0
PREPARE_FOR_KICK_DIST = 50.0
SETUP_DISTANCE_X = 5
SLOW_DOWN_TO_BALL_DIST = 25.
WAIT_COUNT = 0

# Should approach ball again
APPROACH_BALL_AGAIN_DIST = PREPARE_FOR_KICK_DIST + 25.0
BALL_MOVED_THR = 3

# lineUpKick
KICK_SETUP_MULTIPLIER = 3
WAYPOINT_DIST = 35
MAX_BEARING_DIFF = 80

# Potentials
ATTRACTOR_BALL_DIST = 20
REPULSOR_BALL_DIST = ATTRACTOR_BALL_DIST - 15
ATTRACTOR_REPULSOR_RATIO = 2
CLOSE_TO_ATTRACTOR_DIST = 10

# Orbit
SHOULD_ORBIT_BEARING = 25
ORBIT_BALL_DISTANCE = 25
ORBIT_DISTANCE_FAR = 7
ORBIT_DISTANCE_CLOSE = 1
ORBIT_DISTANCE_GOOD = 2
ORBIT_GOOD_BEARING = 6
SHOULD_CANCEL_ORBIT_BALL_DIST = APPROACH_BALL_AGAIN_DIST
ORBIT_TOO_LONG_THR = 8

# Should kick again
SHOULD_KICK_AGAIN_CLOSE_X = 9.5
SHOULD_KICK_AGAIN_FAR_X = 20
SHOULD_KICK_AGAIN_Y = 15

# Ball in position
## NOTE: important that these values slightly overestimate the values in
##        navigator's PFK. Otherwise there can be bad looping.
BALL_X_OFFSET = 1.5
BALL_Y_OFFSET = 1.5
GOOD_ENOUGH_H = 6

# States' constants

# Spin To Ball
FIND_BALL_SPIN_SPEED = .7
FACING_BALL_ACCEPTABLE_BEARING = 20
SHOULD_SPIN_TO_BALL_BEARING = 40.0
FACING_KICK_ACCEPTABLE_BEARING = 4

# find ball
SPUN_ONCE_TIME_THRESH = 8
WALK_FIND_BALL_TIME_THRESH = SPUN_ONCE_TIME_THRESH * 3 # Roughly 3 spins

SPIN_SEARCH_BEARING = 20

BACK_PEDAL_SPEED = -.75
BACK_PEDAL_TIME = 2

FRONT_SPIN_SEARCH_SPEED_X = .1
FRONT_SPIN_SEARCH_SPEED_Y = -.65
FRONT_SPIN_SEARCH_SPEED_H = .15
FRONT_SPIN_LOOK_TO_ANGLE = 15

FAR_BALL_SEARCH_DIST = 110.
SCRUM_DIST = 60.

# WATSON16 HACK
BALL_MEM_THRESH = .15