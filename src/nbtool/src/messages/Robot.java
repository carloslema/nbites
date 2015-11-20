// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VisionRobot.proto

package messages;

/**
 * Protobuf type {@code messages.Robot}
 */
public  final class Robot extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:messages.Robot)
    RobotOrBuilder {
  // Use Robot.newBuilder() to construct.
  private Robot(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private Robot() {
    distance_ = 0F;
    bearing_ = 0F;
    bearingDeg_ = 0F;
    angleXDeg_ = 0F;
    angleYDeg_ = 0F;
    x_ = 0;
    y_ = 0;
    elevationDeg_ = 0F;
    on_ = false;
    height_ = 0;
    width_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Robot(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 13: {
            bitField0_ |= 0x00000001;
            distance_ = input.readFloat();
            break;
          }
          case 21: {
            bitField0_ |= 0x00000002;
            bearing_ = input.readFloat();
            break;
          }
          case 29: {
            bitField0_ |= 0x00000004;
            bearingDeg_ = input.readFloat();
            break;
          }
          case 37: {
            bitField0_ |= 0x00000008;
            angleXDeg_ = input.readFloat();
            break;
          }
          case 45: {
            bitField0_ |= 0x00000010;
            angleYDeg_ = input.readFloat();
            break;
          }
          case 48: {
            bitField0_ |= 0x00000020;
            x_ = input.readSInt32();
            break;
          }
          case 56: {
            bitField0_ |= 0x00000040;
            y_ = input.readSInt32();
            break;
          }
          case 69: {
            bitField0_ |= 0x00000080;
            elevationDeg_ = input.readFloat();
            break;
          }
          case 72: {
            bitField0_ |= 0x00000100;
            on_ = input.readBool();
            break;
          }
          case 80: {
            bitField0_ |= 0x00000200;
            height_ = input.readSInt32();
            break;
          }
          case 88: {
            bitField0_ |= 0x00000400;
            width_ = input.readSInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw new RuntimeException(e.setUnfinishedMessage(this));
    } catch (java.io.IOException e) {
      throw new RuntimeException(
          new com.google.protobuf.InvalidProtocolBufferException(
              e.getMessage()).setUnfinishedMessage(this));
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return messages._File_VisionRobot.internal_static_messages_Robot_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_VisionRobot.internal_static_messages_Robot_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.Robot.class, messages.Robot.Builder.class);
  }

  private int bitField0_;
  public static final int DISTANCE_FIELD_NUMBER = 1;
  private float distance_;
  /**
   * <code>optional float distance = 1;</code>
   */
  public boolean hasDistance() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional float distance = 1;</code>
   */
  public float getDistance() {
    return distance_;
  }

  public static final int BEARING_FIELD_NUMBER = 2;
  private float bearing_;
  /**
   * <code>optional float bearing = 2;</code>
   */
  public boolean hasBearing() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional float bearing = 2;</code>
   */
  public float getBearing() {
    return bearing_;
  }

  public static final int BEARING_DEG_FIELD_NUMBER = 3;
  private float bearingDeg_;
  /**
   * <code>optional float bearing_deg = 3;</code>
   */
  public boolean hasBearingDeg() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional float bearing_deg = 3;</code>
   */
  public float getBearingDeg() {
    return bearingDeg_;
  }

  public static final int ANGLE_X_DEG_FIELD_NUMBER = 4;
  private float angleXDeg_;
  /**
   * <code>optional float angle_x_deg = 4;</code>
   */
  public boolean hasAngleXDeg() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional float angle_x_deg = 4;</code>
   */
  public float getAngleXDeg() {
    return angleXDeg_;
  }

  public static final int ANGLE_Y_DEG_FIELD_NUMBER = 5;
  private float angleYDeg_;
  /**
   * <code>optional float angle_y_deg = 5;</code>
   */
  public boolean hasAngleYDeg() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>optional float angle_y_deg = 5;</code>
   */
  public float getAngleYDeg() {
    return angleYDeg_;
  }

  public static final int X_FIELD_NUMBER = 6;
  private int x_;
  /**
   * <code>optional sint32 x = 6;</code>
   */
  public boolean hasX() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <code>optional sint32 x = 6;</code>
   */
  public int getX() {
    return x_;
  }

  public static final int Y_FIELD_NUMBER = 7;
  private int y_;
  /**
   * <code>optional sint32 y = 7;</code>
   */
  public boolean hasY() {
    return ((bitField0_ & 0x00000040) == 0x00000040);
  }
  /**
   * <code>optional sint32 y = 7;</code>
   */
  public int getY() {
    return y_;
  }

  public static final int ELEVATION_DEG_FIELD_NUMBER = 8;
  private float elevationDeg_;
  /**
   * <code>optional float elevation_deg = 8;</code>
   */
  public boolean hasElevationDeg() {
    return ((bitField0_ & 0x00000080) == 0x00000080);
  }
  /**
   * <code>optional float elevation_deg = 8;</code>
   */
  public float getElevationDeg() {
    return elevationDeg_;
  }

  public static final int ON_FIELD_NUMBER = 9;
  private boolean on_;
  /**
   * <code>optional bool on = 9;</code>
   */
  public boolean hasOn() {
    return ((bitField0_ & 0x00000100) == 0x00000100);
  }
  /**
   * <code>optional bool on = 9;</code>
   */
  public boolean getOn() {
    return on_;
  }

  public static final int HEIGHT_FIELD_NUMBER = 10;
  private int height_;
  /**
   * <code>optional sint32 height = 10;</code>
   */
  public boolean hasHeight() {
    return ((bitField0_ & 0x00000200) == 0x00000200);
  }
  /**
   * <code>optional sint32 height = 10;</code>
   */
  public int getHeight() {
    return height_;
  }

  public static final int WIDTH_FIELD_NUMBER = 11;
  private int width_;
  /**
   * <code>optional sint32 width = 11;</code>
   */
  public boolean hasWidth() {
    return ((bitField0_ & 0x00000400) == 0x00000400);
  }
  /**
   * <code>optional sint32 width = 11;</code>
   */
  public int getWidth() {
    return width_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeFloat(1, distance_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeFloat(2, bearing_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeFloat(3, bearingDeg_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeFloat(4, angleXDeg_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeFloat(5, angleYDeg_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      output.writeSInt32(6, x_);
    }
    if (((bitField0_ & 0x00000040) == 0x00000040)) {
      output.writeSInt32(7, y_);
    }
    if (((bitField0_ & 0x00000080) == 0x00000080)) {
      output.writeFloat(8, elevationDeg_);
    }
    if (((bitField0_ & 0x00000100) == 0x00000100)) {
      output.writeBool(9, on_);
    }
    if (((bitField0_ & 0x00000200) == 0x00000200)) {
      output.writeSInt32(10, height_);
    }
    if (((bitField0_ & 0x00000400) == 0x00000400)) {
      output.writeSInt32(11, width_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, distance_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, bearing_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(3, bearingDeg_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(4, angleXDeg_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(5, angleYDeg_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(6, x_);
    }
    if (((bitField0_ & 0x00000040) == 0x00000040)) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(7, y_);
    }
    if (((bitField0_ & 0x00000080) == 0x00000080)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(8, elevationDeg_);
    }
    if (((bitField0_ & 0x00000100) == 0x00000100)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(9, on_);
    }
    if (((bitField0_ & 0x00000200) == 0x00000200)) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(10, height_);
    }
    if (((bitField0_ & 0x00000400) == 0x00000400)) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(11, width_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static messages.Robot parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.Robot parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.Robot parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.Robot parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.Robot parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.Robot parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.Robot parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.Robot parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.Robot parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.Robot parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(messages.Robot prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code messages.Robot}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:messages.Robot)
      messages.RobotOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_VisionRobot.internal_static_messages_Robot_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_VisionRobot.internal_static_messages_Robot_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.Robot.class, messages.Robot.Builder.class);
    }

    // Construct using messages.Robot.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      distance_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000001);
      bearing_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000002);
      bearingDeg_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000004);
      angleXDeg_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000008);
      angleYDeg_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000010);
      x_ = 0;
      bitField0_ = (bitField0_ & ~0x00000020);
      y_ = 0;
      bitField0_ = (bitField0_ & ~0x00000040);
      elevationDeg_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000080);
      on_ = false;
      bitField0_ = (bitField0_ & ~0x00000100);
      height_ = 0;
      bitField0_ = (bitField0_ & ~0x00000200);
      width_ = 0;
      bitField0_ = (bitField0_ & ~0x00000400);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_VisionRobot.internal_static_messages_Robot_descriptor;
    }

    public messages.Robot getDefaultInstanceForType() {
      return messages.Robot.getDefaultInstance();
    }

    public messages.Robot build() {
      messages.Robot result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.Robot buildPartial() {
      messages.Robot result = new messages.Robot(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.distance_ = distance_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.bearing_ = bearing_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.bearingDeg_ = bearingDeg_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.angleXDeg_ = angleXDeg_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.angleYDeg_ = angleYDeg_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      result.x_ = x_;
      if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
        to_bitField0_ |= 0x00000040;
      }
      result.y_ = y_;
      if (((from_bitField0_ & 0x00000080) == 0x00000080)) {
        to_bitField0_ |= 0x00000080;
      }
      result.elevationDeg_ = elevationDeg_;
      if (((from_bitField0_ & 0x00000100) == 0x00000100)) {
        to_bitField0_ |= 0x00000100;
      }
      result.on_ = on_;
      if (((from_bitField0_ & 0x00000200) == 0x00000200)) {
        to_bitField0_ |= 0x00000200;
      }
      result.height_ = height_;
      if (((from_bitField0_ & 0x00000400) == 0x00000400)) {
        to_bitField0_ |= 0x00000400;
      }
      result.width_ = width_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.Robot) {
        return mergeFrom((messages.Robot)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.Robot other) {
      if (other == messages.Robot.getDefaultInstance()) return this;
      if (other.hasDistance()) {
        setDistance(other.getDistance());
      }
      if (other.hasBearing()) {
        setBearing(other.getBearing());
      }
      if (other.hasBearingDeg()) {
        setBearingDeg(other.getBearingDeg());
      }
      if (other.hasAngleXDeg()) {
        setAngleXDeg(other.getAngleXDeg());
      }
      if (other.hasAngleYDeg()) {
        setAngleYDeg(other.getAngleYDeg());
      }
      if (other.hasX()) {
        setX(other.getX());
      }
      if (other.hasY()) {
        setY(other.getY());
      }
      if (other.hasElevationDeg()) {
        setElevationDeg(other.getElevationDeg());
      }
      if (other.hasOn()) {
        setOn(other.getOn());
      }
      if (other.hasHeight()) {
        setHeight(other.getHeight());
      }
      if (other.hasWidth()) {
        setWidth(other.getWidth());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      messages.Robot parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.Robot) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private float distance_ ;
    /**
     * <code>optional float distance = 1;</code>
     */
    public boolean hasDistance() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional float distance = 1;</code>
     */
    public float getDistance() {
      return distance_;
    }
    /**
     * <code>optional float distance = 1;</code>
     */
    public Builder setDistance(float value) {
      bitField0_ |= 0x00000001;
      distance_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float distance = 1;</code>
     */
    public Builder clearDistance() {
      bitField0_ = (bitField0_ & ~0x00000001);
      distance_ = 0F;
      onChanged();
      return this;
    }

    private float bearing_ ;
    /**
     * <code>optional float bearing = 2;</code>
     */
    public boolean hasBearing() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional float bearing = 2;</code>
     */
    public float getBearing() {
      return bearing_;
    }
    /**
     * <code>optional float bearing = 2;</code>
     */
    public Builder setBearing(float value) {
      bitField0_ |= 0x00000002;
      bearing_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float bearing = 2;</code>
     */
    public Builder clearBearing() {
      bitField0_ = (bitField0_ & ~0x00000002);
      bearing_ = 0F;
      onChanged();
      return this;
    }

    private float bearingDeg_ ;
    /**
     * <code>optional float bearing_deg = 3;</code>
     */
    public boolean hasBearingDeg() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional float bearing_deg = 3;</code>
     */
    public float getBearingDeg() {
      return bearingDeg_;
    }
    /**
     * <code>optional float bearing_deg = 3;</code>
     */
    public Builder setBearingDeg(float value) {
      bitField0_ |= 0x00000004;
      bearingDeg_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float bearing_deg = 3;</code>
     */
    public Builder clearBearingDeg() {
      bitField0_ = (bitField0_ & ~0x00000004);
      bearingDeg_ = 0F;
      onChanged();
      return this;
    }

    private float angleXDeg_ ;
    /**
     * <code>optional float angle_x_deg = 4;</code>
     */
    public boolean hasAngleXDeg() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional float angle_x_deg = 4;</code>
     */
    public float getAngleXDeg() {
      return angleXDeg_;
    }
    /**
     * <code>optional float angle_x_deg = 4;</code>
     */
    public Builder setAngleXDeg(float value) {
      bitField0_ |= 0x00000008;
      angleXDeg_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float angle_x_deg = 4;</code>
     */
    public Builder clearAngleXDeg() {
      bitField0_ = (bitField0_ & ~0x00000008);
      angleXDeg_ = 0F;
      onChanged();
      return this;
    }

    private float angleYDeg_ ;
    /**
     * <code>optional float angle_y_deg = 5;</code>
     */
    public boolean hasAngleYDeg() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional float angle_y_deg = 5;</code>
     */
    public float getAngleYDeg() {
      return angleYDeg_;
    }
    /**
     * <code>optional float angle_y_deg = 5;</code>
     */
    public Builder setAngleYDeg(float value) {
      bitField0_ |= 0x00000010;
      angleYDeg_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float angle_y_deg = 5;</code>
     */
    public Builder clearAngleYDeg() {
      bitField0_ = (bitField0_ & ~0x00000010);
      angleYDeg_ = 0F;
      onChanged();
      return this;
    }

    private int x_ ;
    /**
     * <code>optional sint32 x = 6;</code>
     */
    public boolean hasX() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional sint32 x = 6;</code>
     */
    public int getX() {
      return x_;
    }
    /**
     * <code>optional sint32 x = 6;</code>
     */
    public Builder setX(int value) {
      bitField0_ |= 0x00000020;
      x_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional sint32 x = 6;</code>
     */
    public Builder clearX() {
      bitField0_ = (bitField0_ & ~0x00000020);
      x_ = 0;
      onChanged();
      return this;
    }

    private int y_ ;
    /**
     * <code>optional sint32 y = 7;</code>
     */
    public boolean hasY() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    /**
     * <code>optional sint32 y = 7;</code>
     */
    public int getY() {
      return y_;
    }
    /**
     * <code>optional sint32 y = 7;</code>
     */
    public Builder setY(int value) {
      bitField0_ |= 0x00000040;
      y_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional sint32 y = 7;</code>
     */
    public Builder clearY() {
      bitField0_ = (bitField0_ & ~0x00000040);
      y_ = 0;
      onChanged();
      return this;
    }

    private float elevationDeg_ ;
    /**
     * <code>optional float elevation_deg = 8;</code>
     */
    public boolean hasElevationDeg() {
      return ((bitField0_ & 0x00000080) == 0x00000080);
    }
    /**
     * <code>optional float elevation_deg = 8;</code>
     */
    public float getElevationDeg() {
      return elevationDeg_;
    }
    /**
     * <code>optional float elevation_deg = 8;</code>
     */
    public Builder setElevationDeg(float value) {
      bitField0_ |= 0x00000080;
      elevationDeg_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float elevation_deg = 8;</code>
     */
    public Builder clearElevationDeg() {
      bitField0_ = (bitField0_ & ~0x00000080);
      elevationDeg_ = 0F;
      onChanged();
      return this;
    }

    private boolean on_ ;
    /**
     * <code>optional bool on = 9;</code>
     */
    public boolean hasOn() {
      return ((bitField0_ & 0x00000100) == 0x00000100);
    }
    /**
     * <code>optional bool on = 9;</code>
     */
    public boolean getOn() {
      return on_;
    }
    /**
     * <code>optional bool on = 9;</code>
     */
    public Builder setOn(boolean value) {
      bitField0_ |= 0x00000100;
      on_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool on = 9;</code>
     */
    public Builder clearOn() {
      bitField0_ = (bitField0_ & ~0x00000100);
      on_ = false;
      onChanged();
      return this;
    }

    private int height_ ;
    /**
     * <code>optional sint32 height = 10;</code>
     */
    public boolean hasHeight() {
      return ((bitField0_ & 0x00000200) == 0x00000200);
    }
    /**
     * <code>optional sint32 height = 10;</code>
     */
    public int getHeight() {
      return height_;
    }
    /**
     * <code>optional sint32 height = 10;</code>
     */
    public Builder setHeight(int value) {
      bitField0_ |= 0x00000200;
      height_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional sint32 height = 10;</code>
     */
    public Builder clearHeight() {
      bitField0_ = (bitField0_ & ~0x00000200);
      height_ = 0;
      onChanged();
      return this;
    }

    private int width_ ;
    /**
     * <code>optional sint32 width = 11;</code>
     */
    public boolean hasWidth() {
      return ((bitField0_ & 0x00000400) == 0x00000400);
    }
    /**
     * <code>optional sint32 width = 11;</code>
     */
    public int getWidth() {
      return width_;
    }
    /**
     * <code>optional sint32 width = 11;</code>
     */
    public Builder setWidth(int value) {
      bitField0_ |= 0x00000400;
      width_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional sint32 width = 11;</code>
     */
    public Builder clearWidth() {
      bitField0_ = (bitField0_ & ~0x00000400);
      width_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:messages.Robot)
  }

  // @@protoc_insertion_point(class_scope:messages.Robot)
  private static final messages.Robot DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new messages.Robot();
  }

  public static messages.Robot getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<Robot>
      PARSER = new com.google.protobuf.AbstractParser<Robot>() {
    public Robot parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new Robot(input, extensionRegistry);
      } catch (RuntimeException e) {
        if (e.getCause() instanceof
            com.google.protobuf.InvalidProtocolBufferException) {
          throw (com.google.protobuf.InvalidProtocolBufferException)
              e.getCause();
        }
        throw e;
      }
    }
  };

  public static com.google.protobuf.Parser<Robot> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Robot> getParserForType() {
    return PARSER;
  }

  public messages.Robot getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

