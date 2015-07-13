// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BatteryState.proto

package messages;

/**
 * Protobuf type {@code messages.BatteryState}
 */
public final class BatteryState extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:messages.BatteryState)
    BatteryStateOrBuilder {
  // Use BatteryState.newBuilder() to construct.
  private BatteryState(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private BatteryState(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final BatteryState defaultInstance;
  public static BatteryState getDefaultInstance() {
    return defaultInstance;
  }

  public BatteryState getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private BatteryState(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    initFields();
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
            charge_ = input.readFloat();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return messages._File_BatteryState.internal_static_messages_BatteryState_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_BatteryState.internal_static_messages_BatteryState_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.BatteryState.class, messages.BatteryState.Builder.class);
  }

  public static com.google.protobuf.Parser<BatteryState> PARSER =
      new com.google.protobuf.AbstractParser<BatteryState>() {
    public BatteryState parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BatteryState(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<BatteryState> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  public static final int CHARGE_FIELD_NUMBER = 1;
  private float charge_;
  /**
   * <code>optional float charge = 1;</code>
   */
  public boolean hasCharge() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional float charge = 1;</code>
   */
  public float getCharge() {
    return charge_;
  }

  private void initFields() {
    charge_ = 0F;
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
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeFloat(1, charge_);
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, charge_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static messages.BatteryState parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.BatteryState parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.BatteryState parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.BatteryState parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.BatteryState parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.BatteryState parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.BatteryState parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.BatteryState parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.BatteryState parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.BatteryState parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(messages.BatteryState prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code messages.BatteryState}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:messages.BatteryState)
      messages.BatteryStateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_BatteryState.internal_static_messages_BatteryState_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_BatteryState.internal_static_messages_BatteryState_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.BatteryState.class, messages.BatteryState.Builder.class);
    }

    // Construct using messages.BatteryState.newBuilder()
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
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      charge_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_BatteryState.internal_static_messages_BatteryState_descriptor;
    }

    public messages.BatteryState getDefaultInstanceForType() {
      return messages.BatteryState.getDefaultInstance();
    }

    public messages.BatteryState build() {
      messages.BatteryState result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.BatteryState buildPartial() {
      messages.BatteryState result = new messages.BatteryState(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.charge_ = charge_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.BatteryState) {
        return mergeFrom((messages.BatteryState)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.BatteryState other) {
      if (other == messages.BatteryState.getDefaultInstance()) return this;
      if (other.hasCharge()) {
        setCharge(other.getCharge());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      messages.BatteryState parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.BatteryState) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private float charge_ ;
    /**
     * <code>optional float charge = 1;</code>
     */
    public boolean hasCharge() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional float charge = 1;</code>
     */
    public float getCharge() {
      return charge_;
    }
    /**
     * <code>optional float charge = 1;</code>
     */
    public Builder setCharge(float value) {
      bitField0_ |= 0x00000001;
      charge_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float charge = 1;</code>
     */
    public Builder clearCharge() {
      bitField0_ = (bitField0_ & ~0x00000001);
      charge_ = 0F;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:messages.BatteryState)
  }

  static {
    defaultInstance = new BatteryState(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:messages.BatteryState)
}
