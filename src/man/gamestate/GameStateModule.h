 #pragma once

#include "RoboGrams.h"
#include "Toggle.pb.h"
#include "GameState.pb.h"
#include "GCResponse.pb.h"

#include "Control.hpp"

#include "whistle.hpp"

namespace man{
namespace gamestate{

/**
 * @class: Should be a syncronized version of the game controller.
 *         In the cognition diagram, should attempt to provide
 *         accurate data about the game even when there is lag between
 *         game controller packets. Should store and update its data
 *         given no input change.
 */

class GameStateModule : public portals::Module
{
public:
    GameStateModule(int team, int player);
    virtual ~GameStateModule();

    void run_();

    portals::OutPortal<messages::GameState> gameStateOutput;
    portals::OutPortal<messages::GCResponse> gcResponseOutput;

    portals::InPortal<messages::GameState> commInput;
    portals::InPortal<messages::Toggle>    buttonPressInput;
    portals::InPortal<messages::Toggle>    initialStateInput;
    portals::InPortal<messages::Toggle>    switchTeamInput;
    portals::InPortal<messages::Toggle>    switchKickOffInput;

private:
    void latchInputs();
    void update();
    void advanceState();
    void manual_penalize();
    void reset();
    void switchTeam();
    void switchKickOff();

    void flag_setPenalized(bool p);
    void flag_setPlaying();

    messages::GameState latest_data;
    unsigned int team_number;
    unsigned int player_number;

    bool last_button;
    bool last_initial;
    bool last_team;
    bool last_kickoff;
    int  response_status;

    bool keep_time;
    long long start_time;

    whistle::SharedMemory sharedMemory;

    typedef int game_state_t;

    void whistleHandler(game_state_t lastState, game_state_t& nextState);
};

}
}
