// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PMotion.proto

package messages;

public interface HeadMotionCommandOrBuilder
    extends com.google.protobuf.MessageOrBuilder {

  // optional .messages.HeadMotionCommand.CommandType type = 1;
  /**
   * <code>optional .messages.HeadMotionCommand.CommandType type = 1;</code>
   */
  boolean hasType();
  /**
   * <code>optional .messages.HeadMotionCommand.CommandType type = 1;</code>
   */
  messages.HeadMotionCommand.CommandType getType();

  // optional .messages.PositionHeadCommand pos_command = 2;
  /**
   * <code>optional .messages.PositionHeadCommand pos_command = 2;</code>
   */
  boolean hasPosCommand();
  /**
   * <code>optional .messages.PositionHeadCommand pos_command = 2;</code>
   */
  messages.PositionHeadCommand getPosCommand();
  /**
   * <code>optional .messages.PositionHeadCommand pos_command = 2;</code>
   */
  messages.PositionHeadCommandOrBuilder getPosCommandOrBuilder();

  // optional .messages.ScriptedHeadCommand scripted_command = 3;
  /**
   * <code>optional .messages.ScriptedHeadCommand scripted_command = 3;</code>
   */
  boolean hasScriptedCommand();
  /**
   * <code>optional .messages.ScriptedHeadCommand scripted_command = 3;</code>
   */
  messages.ScriptedHeadCommand getScriptedCommand();
  /**
   * <code>optional .messages.ScriptedHeadCommand scripted_command = 3;</code>
   */
  messages.ScriptedHeadCommandOrBuilder getScriptedCommandOrBuilder();

  // optional int64 timestamp = 4;
  /**
   * <code>optional int64 timestamp = 4;</code>
   */
  boolean hasTimestamp();
  /**
   * <code>optional int64 timestamp = 4;</code>
   */
  long getTimestamp();
}
