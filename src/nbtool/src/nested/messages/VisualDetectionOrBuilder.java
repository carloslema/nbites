// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VisionField.proto

package messages;

public interface VisualDetectionOrBuilder
    extends com.google.protobuf.MessageOrBuilder {

  // optional float distance = 1;
  /**
   * <code>optional float distance = 1;</code>
   */
  boolean hasDistance();
  /**
   * <code>optional float distance = 1;</code>
   */
  float getDistance();

  // optional float bearing = 2;
  /**
   * <code>optional float bearing = 2;</code>
   */
  boolean hasBearing();
  /**
   * <code>optional float bearing = 2;</code>
   */
  float getBearing();

  // optional float bearing_deg = 3;
  /**
   * <code>optional float bearing_deg = 3;</code>
   */
  boolean hasBearingDeg();
  /**
   * <code>optional float bearing_deg = 3;</code>
   */
  float getBearingDeg();

  // optional float distance_sd = 4;
  /**
   * <code>optional float distance_sd = 4;</code>
   */
  boolean hasDistanceSd();
  /**
   * <code>optional float distance_sd = 4;</code>
   */
  float getDistanceSd();

  // optional float bearing_sd = 5;
  /**
   * <code>optional float bearing_sd = 5;</code>
   */
  boolean hasBearingSd();
  /**
   * <code>optional float bearing_sd = 5;</code>
   */
  float getBearingSd();

  // optional int32 certainty = 6;
  /**
   * <code>optional int32 certainty = 6;</code>
   */
  boolean hasCertainty();
  /**
   * <code>optional int32 certainty = 6;</code>
   */
  int getCertainty();

  // optional bool on = 7;
  /**
   * <code>optional bool on = 7;</code>
   */
  boolean hasOn();
  /**
   * <code>optional bool on = 7;</code>
   */
  boolean getOn();

  // optional int32 frames_on = 8;
  /**
   * <code>optional int32 frames_on = 8;</code>
   */
  boolean hasFramesOn();
  /**
   * <code>optional int32 frames_on = 8;</code>
   */
  int getFramesOn();

  // optional int32 frames_off = 9;
  /**
   * <code>optional int32 frames_off = 9;</code>
   */
  boolean hasFramesOff();
  /**
   * <code>optional int32 frames_off = 9;</code>
   */
  int getFramesOff();

  // repeated .messages.Point concrete_coords = 10;
  /**
   * <code>repeated .messages.Point concrete_coords = 10;</code>
   */
  java.util.List<messages.Point> 
      getConcreteCoordsList();
  /**
   * <code>repeated .messages.Point concrete_coords = 10;</code>
   */
  messages.Point getConcreteCoords(int index);
  /**
   * <code>repeated .messages.Point concrete_coords = 10;</code>
   */
  int getConcreteCoordsCount();
  /**
   * <code>repeated .messages.Point concrete_coords = 10;</code>
   */
  java.util.List<? extends messages.PointOrBuilder> 
      getConcreteCoordsOrBuilderList();
  /**
   * <code>repeated .messages.Point concrete_coords = 10;</code>
   */
  messages.PointOrBuilder getConcreteCoordsOrBuilder(
      int index);

  // optional float angle_x_deg = 11;
  /**
   * <code>optional float angle_x_deg = 11;</code>
   */
  boolean hasAngleXDeg();
  /**
   * <code>optional float angle_x_deg = 11;</code>
   */
  float getAngleXDeg();

  // optional float angle_y_deg = 12;
  /**
   * <code>optional float angle_y_deg = 12;</code>
   */
  boolean hasAngleYDeg();
  /**
   * <code>optional float angle_y_deg = 12;</code>
   */
  float getAngleYDeg();

  // optional bool red_goalie = 13;
  /**
   * <code>optional bool red_goalie = 13;</code>
   *
   * <pre>
   * HACK until we have a unified message for goal posts.
   * </pre>
   */
  boolean hasRedGoalie();
  /**
   * <code>optional bool red_goalie = 13;</code>
   *
   * <pre>
   * HACK until we have a unified message for goal posts.
   * </pre>
   */
  boolean getRedGoalie();

  // optional bool navy_goalie = 14;
  /**
   * <code>optional bool navy_goalie = 14;</code>
   */
  boolean hasNavyGoalie();
  /**
   * <code>optional bool navy_goalie = 14;</code>
   */
  boolean getNavyGoalie();

  // optional bool intopcam = 15;
  /**
   * <code>optional bool intopcam = 15;</code>
   */
  boolean hasIntopcam();
  /**
   * <code>optional bool intopcam = 15;</code>
   */
  boolean getIntopcam();

  // optional int32 x = 17;
  /**
   * <code>optional int32 x = 17;</code>
   */
  boolean hasX();
  /**
   * <code>optional int32 x = 17;</code>
   */
  int getX();

  // optional int32 y = 18;
  /**
   * <code>optional int32 y = 18;</code>
   */
  boolean hasY();
  /**
   * <code>optional int32 y = 18;</code>
   */
  int getY();
}
