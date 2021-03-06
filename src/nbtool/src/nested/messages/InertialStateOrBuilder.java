// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: InertialState.proto

package messages;

public interface InertialStateOrBuilder
    extends com.google.protobuf.MessageOrBuilder {

  // optional float acc_x = 1;
  /**
   * <code>optional float acc_x = 1;</code>
   *
   * <pre>
   * Raw accelerometer data.
   * </pre>
   */
  boolean hasAccX();
  /**
   * <code>optional float acc_x = 1;</code>
   *
   * <pre>
   * Raw accelerometer data.
   * </pre>
   */
  float getAccX();

  // optional float acc_y = 2;
  /**
   * <code>optional float acc_y = 2;</code>
   */
  boolean hasAccY();
  /**
   * <code>optional float acc_y = 2;</code>
   */
  float getAccY();

  // optional float acc_z = 3;
  /**
   * <code>optional float acc_z = 3;</code>
   */
  boolean hasAccZ();
  /**
   * <code>optional float acc_z = 3;</code>
   */
  float getAccZ();

  // optional float gyr_x = 4;
  /**
   * <code>optional float gyr_x = 4;</code>
   *
   * <pre>
   * Raw gyrometer data.
   * </pre>
   */
  boolean hasGyrX();
  /**
   * <code>optional float gyr_x = 4;</code>
   *
   * <pre>
   * Raw gyrometer data.
   * </pre>
   */
  float getGyrX();

  // optional float gyr_y = 5;
  /**
   * <code>optional float gyr_y = 5;</code>
   */
  boolean hasGyrY();
  /**
   * <code>optional float gyr_y = 5;</code>
   */
  float getGyrY();

  // optional float gyr_z = 6;
  /**
   * <code>optional float gyr_z = 6;</code>
   */
  boolean hasGyrZ();
  /**
   * <code>optional float gyr_z = 6;</code>
   */
  float getGyrZ();

  // optional float angle_x = 7;
  /**
   * <code>optional float angle_x = 7;</code>
   *
   * <pre>
   * Filtered angle data.
   * </pre>
   */
  boolean hasAngleX();
  /**
   * <code>optional float angle_x = 7;</code>
   *
   * <pre>
   * Filtered angle data.
   * </pre>
   */
  float getAngleX();

  // optional float angle_y = 8;
  /**
   * <code>optional float angle_y = 8;</code>
   */
  boolean hasAngleY();
  /**
   * <code>optional float angle_y = 8;</code>
   */
  float getAngleY();

  // optional float angle_z = 9;
  /**
   * <code>optional float angle_z = 9;</code>
   */
  boolean hasAngleZ();
  /**
   * <code>optional float angle_z = 9;</code>
   */
  float getAngleZ();
}
