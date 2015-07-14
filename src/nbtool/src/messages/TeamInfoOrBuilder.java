// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GameState.proto

package messages;

public interface TeamInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:messages.TeamInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional uint32 team_number = 1;</code>
   */
  boolean hasTeamNumber();
  /**
   * <code>optional uint32 team_number = 1;</code>
   */
  int getTeamNumber();

  /**
   * <code>optional uint32 team_color = 2;</code>
   */
  boolean hasTeamColor();
  /**
   * <code>optional uint32 team_color = 2;</code>
   */
  int getTeamColor();

  /**
   * <code>optional uint32 score = 3;</code>
   */
  boolean hasScore();
  /**
   * <code>optional uint32 score = 3;</code>
   */
  int getScore();

  /**
   * <code>optional uint32 goal_color = 4;</code>
   */
  boolean hasGoalColor();
  /**
   * <code>optional uint32 goal_color = 4;</code>
   */
  int getGoalColor();

  /**
   * <code>repeated .messages.RobotInfo player = 5;</code>
   */
  java.util.List<messages.RobotInfo> 
      getPlayerList();
  /**
   * <code>repeated .messages.RobotInfo player = 5;</code>
   */
  messages.RobotInfo getPlayer(int index);
  /**
   * <code>repeated .messages.RobotInfo player = 5;</code>
   */
  int getPlayerCount();
  /**
   * <code>repeated .messages.RobotInfo player = 5;</code>
   */
  java.util.List<? extends messages.RobotInfoOrBuilder> 
      getPlayerOrBuilderList();
  /**
   * <code>repeated .messages.RobotInfo player = 5;</code>
   */
  messages.RobotInfoOrBuilder getPlayerOrBuilder(
      int index);
}
