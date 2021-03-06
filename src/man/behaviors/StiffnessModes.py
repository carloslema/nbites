
STANDUP_GAINS_VALUE = 1.0
GAINS_ON_VALUE = 0.85
GAINS_ARMS_VALUE = 0.2
GAINS_OFF_VALUE = -1.0
LOWER_HEAD_VALUE = 0.8
DIVE_VALUE = 0

def flipStiffness( (headYaw, headPitch,
                    LShoulderPitch, LShoulderRoll, LElbowYaw, LElbowRoll,
                    LHipYawPitch,
                    LHipRoll, LHipPitch, LKneePitch, LAnklePitch, LAnkleRoll,
                    RHipYawPitch,
                    RHipRoll, RHipPitch, RKneePitch, RAnklePitch, RAnkleRoll,
                    RShoulderPitch, RShoulderRoll, RElbowYaw, RElbowRoll) ):
    return ((headYaw, headPitch,
                 RShoulderPitch, RShoulderRoll, RElbowYaw, RElbowRoll,
                 RHipYawPitch,
                 RHipRoll, RHipPitch, RKneePitch, RAnklePitch, RAnkleRoll,
                 LHipYawPitch,
                 LHipRoll, LHipPitch, LKneePitch, LAnklePitch, LAnkleRoll,
                 LShoulderPitch, LShoulderRoll, LElbowYaw, LElbowRoll))


LOW_HEAD_STIFFNESSES = (LOWER_HEAD_VALUE, # Head
                        LOWER_HEAD_VALUE,
                        GAINS_ARMS_VALUE, # larm
                        GAINS_ARMS_VALUE,
                        GAINS_ARMS_VALUE,
                        GAINS_ARMS_VALUE,
                        GAINS_ON_VALUE, # lleg
                        GAINS_ON_VALUE,
                        GAINS_ON_VALUE,
                        GAINS_ON_VALUE,
                        GAINS_ON_VALUE,
                        GAINS_ON_VALUE,
                        GAINS_ON_VALUE, # rleg
                        GAINS_ON_VALUE,
                        GAINS_ON_VALUE,
                        GAINS_ON_VALUE,
                        GAINS_ON_VALUE,
                        GAINS_ON_VALUE,
                        GAINS_ARMS_VALUE, # rarm
                        GAINS_ARMS_VALUE,
                        GAINS_ARMS_VALUE,
                        GAINS_ARMS_VALUE,)

STANDUP_STIFFNESSES = (STANDUP_GAINS_VALUE, # Head
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE, # larm
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE, # lleg
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE, # rleg
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE, # rarm
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,
                       STANDUP_GAINS_VALUE,)

NORMAL_STIFFNESSES = (GAINS_ON_VALUE, # Head
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE, # larm
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE, # lleg
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE, # rleg
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE, # rarm
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,
                      GAINS_ON_VALUE,)

LOW_LEG_STIFFNESSES =  (GAINS_OFF_VALUE, # Head
                          GAINS_OFF_VALUE,
                          GAINS_ARMS_VALUE, # larm
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE, # lleg
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE, # rleg
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE, # rarm
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,
                          GAINS_ARMS_VALUE,)

NO_HEAD_STIFFNESSES = (GAINS_OFF_VALUE, # Head
                          GAINS_OFF_VALUE,
                          GAINS_OFF_VALUE, # larm
                          GAINS_OFF_VALUE,
                          GAINS_OFF_VALUE,
                          GAINS_OFF_VALUE,
                          GAINS_ON_VALUE, # lleg
                          GAINS_ON_VALUE,
                          GAINS_ON_VALUE,
                          GAINS_ON_VALUE,
                          GAINS_ON_VALUE,
                          GAINS_ON_VALUE,
                          GAINS_ON_VALUE, # rleg
                          GAINS_ON_VALUE,
                          GAINS_ON_VALUE,
                          GAINS_ON_VALUE,
                          GAINS_ON_VALUE,
                          GAINS_ON_VALUE,
                          GAINS_OFF_VALUE, # rarm
                          GAINS_OFF_VALUE,
                          GAINS_OFF_VALUE,
                          GAINS_OFF_VALUE,)

GOALIE_DIVE_RIGHT_STIFFNESSES=  (LOWER_HEAD_VALUE, # Head
                                 LOWER_HEAD_VALUE,
                                 GAINS_ON_VALUE, # larm
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE, # lleg
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE, # rleg
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE, # rarm
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,
                                 GAINS_ON_VALUE,)

GOALIE_GROUND_STIFFNESSES = (LOWER_HEAD_VALUE, # Head
                             LOWER_HEAD_VALUE,
                             DIVE_VALUE, # larm
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE, # lleg
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE, # rleg
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE, # rarm
                             DIVE_VALUE,
                             DIVE_VALUE,
                             DIVE_VALUE,)