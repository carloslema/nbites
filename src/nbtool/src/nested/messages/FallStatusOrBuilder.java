// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FallStatus.proto

package messages;

public interface FallStatusOrBuilder
    extends com.google.protobuf.MessageOrBuilder {

  // optional bool falling = 1;
  /**
   * <code>optional bool falling = 1;</code>
   */
  boolean hasFalling();
  /**
   * <code>optional bool falling = 1;</code>
   */
  boolean getFalling();

  // optional bool fallen = 2;
  /**
   * <code>optional bool fallen = 2;</code>
   */
  boolean hasFallen();
  /**
   * <code>optional bool fallen = 2;</code>
   */
  boolean getFallen();

  // optional bool on_front = 3;
  /**
   * <code>optional bool on_front = 3;</code>
   *
   * <pre>
   *On back if false, undefined if not fallen.
   * </pre>
   */
  boolean hasOnFront();
  /**
   * <code>optional bool on_front = 3;</code>
   *
   * <pre>
   *On back if false, undefined if not fallen.
   * </pre>
   */
  boolean getOnFront();
}
