"""
@Summer 2013: This entire state is an aid for localization, since we can only
hard reset to one of the two possible post-penalty positions.
"""

import ChaseBallTransitions as transitions
import RoleConstants as roleConstants
from noggin_constants import LineID
from math import copysign, fabs, pi
from objects import RelRobotLocation
from ..navigator import Navigator
from ..util import *

DEBUG_PENALTY_STATES = True
angle = 80

# So this entire state is cobbled together in the rush of China 2015.
# *IDEALLY* we would use exclusively corners and actively track them,
# I don't have time to do this so we're just going a static 80 degrees.

# Someone could really knock this out of the park with a good day of work,
# alternatively this could be a good newbie project. Please fix though

@superState('gameControllerResponder')
def afterPenalty(player):

    ## TODO TEST VALUES: NUMBER OF FRAMES AND RIGHT/LEFT DIFFS

    if player.firstFrame():
        if DEBUG_PENALTY_STATES:
            print "Entering the 'afterPenalty' state."

        afterPenalty.decidedSide = False
        afterPenalty.lookRight = True

        # count the number of times we see the goalbox and C-Corner on the right
        afterPenalty.cCornerRight = 0
        afterPenalty.goalboxRight = 0

        # count the number of times we see the CC and T-Corner on the left
        afterPenalty.tCornerLeft = 0
        afterPenalty.CenterCircleLeft = 0

        ## VARS FROM 2015 AFTERPENALTY ##
        afterPenalty.right = True
        afterPenalty.decidedSide = False
        player.brain.tracker.lookToAngle(-1 * angle)

        # state specific counters
        afterPenalty.rightDiff = 0
        afterPenalty.leftDiff = 0
        afterPenalty.cornerCOn = 0
        afterPenalty.cornerTOn = 0

        # number of times we see the horizon on either side - if corner check fails, try using this.
        afterPenalty.leftHorizSum = 0
        afterPenalty.rightHorizSum = 0

        # Keep track of frames since player was penalized
        afterPenalty.frameCount = 0

    # Update number of frames since player entered
    afterPenalty.frameCount += 1
    vis = player.brain.vision

    # Alternate looking left and right every several frames
        # Increment/Decrement all the counters
    # Check final values of corner counters after a certain number of frames in afterpenalty
    # Need to define threshold for this ^ 
    # If counters are too close to 0, use horizon counters instead

    if afterPenalty.frameCount % 50 == 0:

        ## LOOK RIGHT
        if afterPenalty.lookRight:
            player.brain.tracker.lookToAngle(angle)
            if DEBUG_PENALTY_STATES:
                print "Looking to my right!"
        else:
            player.brain.tracker.lookToAngle(-1 * angle)
            if DEBUG_PENALTY_STATES:
                print "Looking to my left!"


    if player.brain.tracker.isStopped() and afterPenalty.lookRight:
        # Increment horizon distance
        afterPenalty.rightHorizSum += vis.horizon_dist
        # Count corners

        if DEBUG_PENALTY_STATES:
            print "Looking to the right!"
            print "I've seen the C-Corner", afterPenalty.cCornerRight, "times, T-Corner", afterPenalty.tCornerLeft, "times"
            print "I've seen the goalbox", afterPenalty.goalboxRight, "times, Center Circle", afterPenalty.CenterCircleLeft, "times"
            print "Cumulative horizon distance on this side is", afterPenalty.rightHorizSum

    elif player.brain.tracker.isStopped() and not afterPenalty.lookRight:
        afterPenalty.leftHorizSum += vis.horizon_dist

        if DEBUG_PENALTY_STATES:
            print "Looking to the left and counting!"
            print "I've seen the C-Corner", afterPenalty.cCornerRight, "times, T-Corner", afterPenalty.tCornerLeft, "times"
            print "I've seen the goalbox", afterPenalty.goalboxRight, "times, Center Circle", afterPenalty.CenterCircleLeft, "times"
            print "Cumulative horizon distance on this side is", afterPenalty.leftHorizSum

    afterPenalty.lookRight = not afterPenalty.lookRight

    if afterPenalty.frameCount > 110:
        print "Done checking horizons!"
        return player.stay()

    ## ALTERNATE SOLUTION: LEAVE PENALTY AFTER COUNTERS REACH A CERTAIN NUMBER? --> not with negative counters

    """
    # Alternate between looking right and left every 70 frames
    if afterPenalty.frameCount % 70 == 0:
        # LOOK RIGHT
        if afterPenalty.right:
            afterPenalty.rightDiff += afterPenalty.cornerCOn - afterPenalty.cornerTOn
            if DEBUG_PENALTY_STATES:
                print "After Penalty right Diff: ", afterPenalty.rightDiff, " cOn: ", afterPenalty.cornerCOn, " tOn: ", afterPenalty.cornerTOn
                print "Right sum: ", afterPenalty.rightHorizSum
                #print "     right close: ", player.brain
            player.brain.tracker.lookToAngle(angle)

        else:
            player.brain.tracker.lookToAngle(-1 * angle)
            afterPenalty.leftDiff += afterPenalty.cornerCOn - afterPenalty.cornerTOn
            if DEBUG_PENALTY_STATES:
                print "After Penalty left Diff: ", afterPenalty.leftDiff, " cOn: ", afterPenalty.cornerCOn, " tOn: ", afterPenalty.cornerTOn
                print "Left sum: ", afterPenalty.leftHorizSum

        # SWAP TO LOOK LEFT AT NEXT ITERATION
        afterPenalty.right = not afterPenalty.right

        # Reset counters
        afterPenalty.cornerCOn = 0
        afterPenalty.cornerTOn = 0

    # Only count if we're looking right/left. Don't want to count anything while panning
    if player.brain.tracker.isStopped():

        ## increment where we see the horizons ## 
        if afterPenalty.right:
            afterPenalty.rightHorizSum += player.brain.vision.horizon_dist
        else:
            afterPenalty.leftHorizSum += player.brain.vision.horizon_dist

        ## THIS IS WHERE WE LOOK FOR CORNERS ##
        for i in range(0, vis.corner_size()):
            corner = vis.corner(i)
            if corner.id == 2:
                afterPenalty.cornerTOn += 1
            else:
                afterPenalty.cornerCOn += 1

    # China hack 2015. Please make this better. Fairly arbitrary thresholds.
    # The idea is if we're flip-flopping between T and C classifications we
    # have bigger vision problems going on.
    if afterPenalty.frameCount > 140:
        if afterPenalty.rightDiff > 5 and afterPenalty.leftDiff <= 0:
            afterPenalty.decidedSide = True
            afterPenalty.right = True
        elif afterPenalty.rightDiff < -5 and afterPenalty.leftDiff >= 0:
            afterPenalty.decidedSide = True
            afterPenalty.right = False
        elif afterPenalty.leftDiff > 5 and afterPenalty.rightDiff <= 0:
            afterPenalty.decidedSide = True
            afterPenalty.right = False
        elif afterPenalty.leftDiff < -5 and afterPenalty.rightDiff >= 0:
            afterPenalty.decidedSide = True
            afterPenalty.right = True

    if afterPenalty.decidedSide or afterPenalty.frameCount > 300:
        if afterPenalty.decidedSide:
            player.brain.resetLocalizationFromPenalty(afterPenalty.right)
        else:
            # This is a backup. We would prefer to use corners to determine our side as fieldedge could be noisy
            print "Corners didn't work! defaulting to horizonDist"
            player.brain.resetLocalizationFromPenalty(afterPenalty.rightHorizSum < afterPenalty.leftHorizSum)
        if DEBUG_PENALTY_STATES:
            print "We've decided! ", afterPenalty.right, " LeftDiff: ", afterPenalty.leftDiff, \
                " Right Diff: ", afterPenalty.rightDiff, " frameCount: ", afterPenalty.frameCount
            print "RSUM: ", afterPenalty.rightHorizSum, " LSUM: ", afterPenalty.leftHorizSum

        player.brain.tracker.repeatWidePan()

        if not roleConstants.isGoalie(player.role):
            return player.goNow('walkOut')
        return player.goLater(player.gameState)

    """

    if afterPenalty.decidedSide:
        # TODO see if the goalie role affects this
        return player.goNow('walkOut')

    return player.stay()

@superState('gameControllerResponder')
def manualPlacement(player):
    """
    TODO / OPTIONAL for now: state in which a robot can still localize after being manually placed.
    We shouldn't go into after penalty in this case, but the GameController can still penalize us in
    GameReady, so this could be useful.

    """

    if player.firstFrame() and (player.lastDiffState == 'GameReady' or player.lastDiffState == 'GameSet'):
        print "Going into after penalty from ready or set; am I being manually placed?"
        player.wasPenalized = False
        return player.goLater(player.gameState)


    return player.stay()

@superState('gameControllerResponder')
def walkOut(player):
    player.brain.nav.walk(0.5, 0, 0)

    if player.stateTime > 5:
        return player.goNow('determineRole')
    return player.stay()

@superState('gameControllerResponder')
def determineRole(player):
    if not player.roleSwitching:
        return player.goLater(player.gameState)

    openSpaces = [True, True, True, True]
    for mate in player.brain.teamMembers:
        if mate.playerNumber == player.brain.playerNumber:
            continue
        if not roleConstants.isGoalie(mate.role) \
                and mate.frameSinceActive < 30:
            openSpaces[mate.role - 2] = False

    position = 0

    for i in range(4):
        if openSpaces[i] and roleConstants.canRoleSwitchTo(i+2):
            roleConstants.setRoleConstants(player, i+2)
            return player.goLater(player.gameState)
        elif openSpaces[i]:
            position = i+2

    if position == 0:
        print "Came out of penalty and found no open spaces!!!"

    roleConstants.setRoleConstants(player, i+2)
    return player.goLater(player.gameState)

