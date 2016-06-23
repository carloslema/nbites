import SharedTransitions as shared
import PlayOffBallTransitions as transitions
import RoleConstants as role
import ChaseBallTransitions as chase
import ChaseBallConstants as chaseConstants
import ClaimTransitions as claims
from SupporterConstants import getSupporterPosition, CHASER_DISTANCE, calculateHomePosition
import noggin_constants as NogginConstants
from ..navigator import Navigator as nav
from ..navigator import BrunswickSpeeds as speeds
from objects import Location, RobotLocation
from ..util import *
from math import hypot, fabs, atan2, degrees
import random

# IMPORTANT China 2015 bug found
# TODO fix oscillation between positionAtHome and positionAsSupporter

@defaultState('branchOnRole')
@superState('gameControllerResponder')
@ifSwitchNow(transitions.shouldFindSharedBall, 'searchFieldForSharedBall')
@ifSwitchNow(transitions.shouldBeSupporter, 'positionAsSupporter')
@ifSwitchNow(transitions.shouldApproachBall, 'approachBall')
def playOffBall(player):
    """
    Superstate for all off ball play.
    """
    player.inKickingState = False

#USOPEN2016: Back to Search Field by Quad
@superState('playOffBall')
def branchOnRole(player):
    """
    Chasers are going to have a different behavior again.
    We will branch on behavior based on role here
    """
    # print("TIME SINCE PLAYING:", player.brain.gameController.timeSincePlaying)
    if role.isChaser(player.role):
        if transitions.shouldFindSharedBall(player) and player.brain.gameController.timeSincePlaying > 75:
            return player.goNow('searchFieldForSharedBall')
        return player.goNow('searchFieldByQuad')
    return player.goNow('positionAtHome')


@superState('playOffBall')
@stay
@ifSwitchNow(shared.navAtPosition, 'watchForBall')
def positionAtHome(player):
    """
    Go to the player's home position.
    """

    print "Position at home"

    if role.isDefender(player.role):
        home = calculateHomePosition(player)
    else:
        home = player.homePosition

    if player.firstFrame():
        player.brain.tracker.trackBall()
        fastWalk = role.isChaser(player.role)
        player.brain.nav.goTo(home, precision = nav.HOME,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = fastWalk, pb = False)

    player.brain.nav.updateDest(home)

@superState('playOffBall')
@stay
@ifSwitchNow(transitions.shouldChangeDefenderPosition, 'positionAtHome')
@ifSwitchNow(transitions.shouldSpinSearchFromWatching, 'spinAtHome')
def watchForBall(player):
    """
    The player is at home, waiting for the ball to be within box.
    """

    if player.firstFrame():
        print "-----------Player at home-----------"
        player.brain.tracker.trackBall()
        player.brain.nav.stand()

    player.brain.defendingStateTime += 1

    if transitions.tooFarFromHome(player, 50, 20):
        fastWalk = role.isChaser(player.role)
        player.brain.nav.goTo(player.homePosition, precision = nav.HOME,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = True, pb = False)
        
    while player.stateTime < 8:
        return player.stay()

    return player.goNow('spinAtHome')

@defaultState('doFirstHalfSpin')
@superState('playOffBall')
@ifSwitchNow(transitions.shouldChangeDefenderPosition, 'positionAtHome')
# @ifSwitchNow(transitions.stopSpinning, 'positionAtHome')
def spinAtHome(player):
    """
    Spin while at home.
    """
    
    pass

@superState('spinAtHome')
def doFirstHalfSpin(player):
    """
    Spin to where we think the ball is.
    """

    player.brain.defendingStateTime += 1

    if player.firstFrame():
        print "------------First half spin-------------"
        
        if player.brain.playerNumber == 3:
            player.setWalk(0, 0, speeds.SPEED_FOUR)
            player.brain.tracker.lookToSpinDirection(1) #Clockwise
        else:
            player.setWalk(0, 0, -speeds.SPEED_FOUR)
            player.brain.tracker.lookToSpinDirection(-1) #AntiClockwise

    while player.stateTime < chaseConstants.SPUN_ONCE_TIME_THRESH / 2:
        return player.stay()

    return player.goNow('doPan')

@superState('spinAtHome')
@ifSwitchNow(transitions.shouldChangeDefenderPosition, 'positionAtHome')
def doPan(player):
    """
    Wide pan for 5 seconds.
    """

    player.brain.defendingStateTime += 1

    if player.firstFrame():
        print "------------Doing Pan-------------"

        player.stand()
        player.brain.tracker.repeatWideSnapPan()

    while player.stateTime < 4: #Should use constant for 1 pan here.
        return player.stay()

    return player.goNow('doSecondHalfSpin')

@superState('spinAtHome')
def doSecondHalfSpin(player):
    """
    Keep spinning in the same direction.
    """

    player.brain.defendingStateTime += 1

    if player.firstFrame():
        print "--------------Second Half Spin---------------"

        if player.brain.playerNumber == 3:
            player.setWalk(0, 0, speeds.SPEED_FOUR)
            player.brain.tracker.lookToSpinDirection(1) #Clockwise
        else:
            player.setWalk(0, 0, -speeds.SPEED_FOUR)
            player.brain.tracker.lookToSpinDirection(-1) #AntiClockwise

    while player.stateTime < chaseConstants.SPUN_ONCE_TIME_THRESH / 2:
        return player.stay()

    if role.isFirstChaser(player.role):
        return player.goNow('searchFieldByQuad')
    return player.goNow('playOffBall')

@superState('playOffBall')
@stay
@ifSwitchLater(transitions.shouldNotBeSupporter, 'playOffBall')
def positionAsSupporter(player):
    """
    Position to support teammate with claim.
    """
    positionAsSupporter.position = getSupporterPosition(player, player.role)
    fastWalk = False

    if player.firstFrame():
        player.brain.tracker.trackBall()

        player.brain.nav.goTo(positionAsSupporter.position, precision = nav.GENERAL_AREA,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = fastWalk, pb = False)

    if positionAsSupporter.position.distTo(player.brain.loc) > 20:
        player.brain.nav.goTo(positionAsSupporter.position, precision = nav.GENERAL_AREA,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = fastWalk, pb = False)
    
    player.brain.nav.updateDest(positionAsSupporter.position, fast = fastWalk)

@superState('playOffBall')
@stay
@ifSwitchNow(transitions.noBallFoundAtSharedBall, 'searchFieldByQuad') #was: positionAtHome USOPEN2016
@ifSwitchNow(transitions.shouldFindFlippedSharedBall, 'searchFieldForFlippedSharedBall')
@ifSwitchNow(transitions.shouldStopLookingForSharedBall, 'searchFieldByQuad') #was: positionAtHome USOPEN2016
def searchFieldForSharedBall(player):
    """
    Searches the field for the shared ball.
    """
    sharedball = Location(player.brain.sharedBall.x, player.brain.sharedBall.y)

    if player.firstFrame():
        player.brain.tracker.trackBall()
        player.brain.tracker.repeatWideSnapPan()
        player.sharedBallCloseCount = 0
        player.sharedBallOffCount = 0
        player.brain.nav.goTo(sharedball, precision = nav.GENERAL_AREA,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = True, pb = False)

    if sharedball.distTo(player.brain.loc) < 100:
        player.sharedBallCloseCount += 1
    else:
        player.sharedBallCloseCount = 0

    if not transitions.shouldFindSharedBall(player):
        player.sharedBallOffCount += 1
    else:
        player.sharedBallOffCount = 0

    player.brain.nav.updateDest(sharedball)

@superState('playOffBall')
@stay
@ifSwitchNow(transitions.shouldStopLookingForFlippedSharedBall, 'searchFieldByQuad') #was: positionAtHome USOPEN2016
def searchFieldForFlippedSharedBall(player):
    """
    Flips the shared ball and searches for it.
    """
    sharedball = Location(-1*(player.brain.sharedBall.x-NogginConstants.MIDFIELD_X) + NogginConstants.MIDFIELD_X,
                          -1*(player.brain.sharedBall.y-NogginConstants.MIDFIELD_Y) + NogginConstants.MIDFIELD_Y)

    if player.firstFrame():
        player.brain.tracker.trackBall()
        player.brain.tracker.repeatWideSnapPan()
        player.sharedBallCloseCount = 0
        player.brain.nav.goTo(sharedball, precision = nav.GENERAL_AREA,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = True, pb = False)

    if sharedball.distTo(player.brain.loc) < 100:
        player.sharedBallCloseCount += 1
    else:
        player.sharedBallCloseCount = 0

    if not transitions.shouldFindSharedBall(player):
        player.sharedBallOffCount += 1
    else:
        player.sharedBallOffCount = 0
        
    player.brain.nav.updateDest(sharedball)

@superState('playOffBall')
@stay
def searchFieldByQuad(player):
    """
    Search the field quadrant by quadrant. Choose first quadrant by loc heading.
    """
    if player.firstFrame():
        player.brain.tracker.trackBall()
        # player.brain.tracker.repeatWideSnapPan()
        searchFieldByQuad.dest = min(points, key=lambda x:fabs(player.brain.loc.distTo(x)))
        player.brain.nav.goTo(searchFieldByQuad.dest, precision = nav.GRAINY,
                          speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                          fast = True, pb = False)
        searchFieldByQuad.quadIndex = points.index(searchFieldByQuad.dest)
        searchFieldByQuad.quadsWalked = 0

    if shared.navAtPosition(player) and player.brain.loc.distTo(searchFieldByQuad.dest) < 60:
        searchFieldByQuad.quadIndex += 1
        searchFieldByQuad.quadsWalked += 1
        searchFieldByQuad.dest = points[searchFieldByQuad.quadIndex % len(points)]

    if searchFieldByQuad.quadsWalked > 3:
        return player.goLater('playOffBall')

    player.brain.nav.updateDest(searchFieldByQuad.dest)

quad1Center = Location(NogginConstants.CENTER_FIELD_X * .6, NogginConstants.CENTER_FIELD_Y * .6)
quad2Center = Location(NogginConstants.CENTER_FIELD_X * 1.4, NogginConstants.CENTER_FIELD_Y * 1.4)
quad3Center = Location(NogginConstants.CENTER_FIELD_X * 1.4, NogginConstants.CENTER_FIELD_Y * .6)
quad4Center = Location(NogginConstants.CENTER_FIELD_X * .6, NogginConstants.CENTER_FIELD_Y * 1.4)
points = [quad1Center, quad2Center, quad3Center, quad4Center]
