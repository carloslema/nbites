// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GameState.proto

package messages;

/**
 * Protobuf type {@code messages.TeamInfo}
 */
public  final class TeamInfo extends
    com.google.protobuf.GeneratedMessage
    implements TeamInfoOrBuilder {
  // Use TeamInfo.newBuilder() to construct.
  private TeamInfo(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private TeamInfo(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final TeamInfo defaultInstance;
  public static TeamInfo getDefaultInstance() {
    return defaultInstance;
  }

  public TeamInfo getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private TeamInfo(
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
          case 8: {
            bitField0_ |= 0x00000001;
            teamNumber_ = input.readUInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            teamColor_ = input.readUInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            score_ = input.readUInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            goalColor_ = input.readUInt32();
            break;
          }
          case 42: {
            if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
              player_ = new java.util.ArrayList<messages.RobotInfo>();
              mutable_bitField0_ |= 0x00000010;
            }
            player_.add(input.readMessage(messages.RobotInfo.PARSER, extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
        player_ = java.util.Collections.unmodifiableList(player_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return messages._File_GameState.internal_static_messages_TeamInfo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_GameState.internal_static_messages_TeamInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.TeamInfo.class, messages.TeamInfo.Builder.class);
  }

  public static com.google.protobuf.Parser<TeamInfo> PARSER =
      new com.google.protobuf.AbstractParser<TeamInfo>() {
    public TeamInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TeamInfo(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<TeamInfo> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  // optional uint32 team_number = 1;
  public static final int TEAM_NUMBER_FIELD_NUMBER = 1;
  private int teamNumber_;
  /**
   * <code>optional uint32 team_number = 1;</code>
   */
  public boolean hasTeamNumber() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional uint32 team_number = 1;</code>
   */
  public int getTeamNumber() {
    return teamNumber_;
  }

  // optional uint32 team_color = 2;
  public static final int TEAM_COLOR_FIELD_NUMBER = 2;
  private int teamColor_;
  /**
   * <code>optional uint32 team_color = 2;</code>
   */
  public boolean hasTeamColor() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional uint32 team_color = 2;</code>
   */
  public int getTeamColor() {
    return teamColor_;
  }

  // optional uint32 score = 3;
  public static final int SCORE_FIELD_NUMBER = 3;
  private int score_;
  /**
   * <code>optional uint32 score = 3;</code>
   */
  public boolean hasScore() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional uint32 score = 3;</code>
   */
  public int getScore() {
    return score_;
  }

  // optional uint32 goal_color = 4;
  public static final int GOAL_COLOR_FIELD_NUMBER = 4;
  private int goalColor_;
  /**
   * <code>optional uint32 goal_color = 4;</code>
   */
  public boolean hasGoalColor() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional uint32 goal_color = 4;</code>
   */
  public int getGoalColor() {
    return goalColor_;
  }

  // repeated .messages.RobotInfo player = 5;
  public static final int PLAYER_FIELD_NUMBER = 5;
  private java.util.List<messages.RobotInfo> player_;
  /**
   * <code>repeated .messages.RobotInfo player = 5;</code>
   */
  public java.util.List<messages.RobotInfo> getPlayerList() {
    return player_;
  }
  /**
   * <code>repeated .messages.RobotInfo player = 5;</code>
   */
  public java.util.List<? extends messages.RobotInfoOrBuilder> 
      getPlayerOrBuilderList() {
    return player_;
  }
  /**
   * <code>repeated .messages.RobotInfo player = 5;</code>
   */
  public int getPlayerCount() {
    return player_.size();
  }
  /**
   * <code>repeated .messages.RobotInfo player = 5;</code>
   */
  public messages.RobotInfo getPlayer(int index) {
    return player_.get(index);
  }
  /**
   * <code>repeated .messages.RobotInfo player = 5;</code>
   */
  public messages.RobotInfoOrBuilder getPlayerOrBuilder(
      int index) {
    return player_.get(index);
  }

  private void initFields() {
    teamNumber_ = 0;
    teamColor_ = 0;
    score_ = 0;
    goalColor_ = 0;
    player_ = java.util.Collections.emptyList();
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) return isInitialized == 1;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeUInt32(1, teamNumber_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeUInt32(2, teamColor_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeUInt32(3, score_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeUInt32(4, goalColor_);
    }
    for (int i = 0; i < player_.size(); i++) {
      output.writeMessage(5, player_.get(i));
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
        .computeUInt32Size(1, teamNumber_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, teamColor_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(3, score_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(4, goalColor_);
    }
    for (int i = 0; i < player_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, player_.get(i));
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

  public static messages.TeamInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.TeamInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.TeamInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.TeamInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.TeamInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.TeamInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.TeamInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.TeamInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.TeamInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.TeamInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(messages.TeamInfo prototype) {
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
   * Protobuf type {@code messages.TeamInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder>
     implements messages.TeamInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_GameState.internal_static_messages_TeamInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_GameState.internal_static_messages_TeamInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.TeamInfo.class, messages.TeamInfo.Builder.class);
    }

    // Construct using messages.TeamInfo.newBuilder()
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
        getPlayerFieldBuilder();
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      teamNumber_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      teamColor_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      score_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      goalColor_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      if (playerBuilder_ == null) {
        player_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
      } else {
        playerBuilder_.clear();
      }
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_GameState.internal_static_messages_TeamInfo_descriptor;
    }

    public messages.TeamInfo getDefaultInstanceForType() {
      return messages.TeamInfo.getDefaultInstance();
    }

    public messages.TeamInfo build() {
      messages.TeamInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.TeamInfo buildPartial() {
      messages.TeamInfo result = new messages.TeamInfo(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.teamNumber_ = teamNumber_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.teamColor_ = teamColor_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.score_ = score_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.goalColor_ = goalColor_;
      if (playerBuilder_ == null) {
        if (((bitField0_ & 0x00000010) == 0x00000010)) {
          player_ = java.util.Collections.unmodifiableList(player_);
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.player_ = player_;
      } else {
        result.player_ = playerBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.TeamInfo) {
        return mergeFrom((messages.TeamInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.TeamInfo other) {
      if (other == messages.TeamInfo.getDefaultInstance()) return this;
      if (other.hasTeamNumber()) {
        setTeamNumber(other.getTeamNumber());
      }
      if (other.hasTeamColor()) {
        setTeamColor(other.getTeamColor());
      }
      if (other.hasScore()) {
        setScore(other.getScore());
      }
      if (other.hasGoalColor()) {
        setGoalColor(other.getGoalColor());
      }
      if (playerBuilder_ == null) {
        if (!other.player_.isEmpty()) {
          if (player_.isEmpty()) {
            player_ = other.player_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensurePlayerIsMutable();
            player_.addAll(other.player_);
          }
          onChanged();
        }
      } else {
        if (!other.player_.isEmpty()) {
          if (playerBuilder_.isEmpty()) {
            playerBuilder_.dispose();
            playerBuilder_ = null;
            player_ = other.player_;
            bitField0_ = (bitField0_ & ~0x00000010);
            playerBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getPlayerFieldBuilder() : null;
          } else {
            playerBuilder_.addAllMessages(other.player_);
          }
        }
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
      messages.TeamInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.TeamInfo) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    // optional uint32 team_number = 1;
    private int teamNumber_ ;
    /**
     * <code>optional uint32 team_number = 1;</code>
     */
    public boolean hasTeamNumber() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional uint32 team_number = 1;</code>
     */
    public int getTeamNumber() {
      return teamNumber_;
    }
    /**
     * <code>optional uint32 team_number = 1;</code>
     */
    public Builder setTeamNumber(int value) {
      bitField0_ |= 0x00000001;
      teamNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint32 team_number = 1;</code>
     */
    public Builder clearTeamNumber() {
      bitField0_ = (bitField0_ & ~0x00000001);
      teamNumber_ = 0;
      onChanged();
      return this;
    }

    // optional uint32 team_color = 2;
    private int teamColor_ ;
    /**
     * <code>optional uint32 team_color = 2;</code>
     */
    public boolean hasTeamColor() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional uint32 team_color = 2;</code>
     */
    public int getTeamColor() {
      return teamColor_;
    }
    /**
     * <code>optional uint32 team_color = 2;</code>
     */
    public Builder setTeamColor(int value) {
      bitField0_ |= 0x00000002;
      teamColor_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint32 team_color = 2;</code>
     */
    public Builder clearTeamColor() {
      bitField0_ = (bitField0_ & ~0x00000002);
      teamColor_ = 0;
      onChanged();
      return this;
    }

    // optional uint32 score = 3;
    private int score_ ;
    /**
     * <code>optional uint32 score = 3;</code>
     */
    public boolean hasScore() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional uint32 score = 3;</code>
     */
    public int getScore() {
      return score_;
    }
    /**
     * <code>optional uint32 score = 3;</code>
     */
    public Builder setScore(int value) {
      bitField0_ |= 0x00000004;
      score_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint32 score = 3;</code>
     */
    public Builder clearScore() {
      bitField0_ = (bitField0_ & ~0x00000004);
      score_ = 0;
      onChanged();
      return this;
    }

    // optional uint32 goal_color = 4;
    private int goalColor_ ;
    /**
     * <code>optional uint32 goal_color = 4;</code>
     */
    public boolean hasGoalColor() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional uint32 goal_color = 4;</code>
     */
    public int getGoalColor() {
      return goalColor_;
    }
    /**
     * <code>optional uint32 goal_color = 4;</code>
     */
    public Builder setGoalColor(int value) {
      bitField0_ |= 0x00000008;
      goalColor_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint32 goal_color = 4;</code>
     */
    public Builder clearGoalColor() {
      bitField0_ = (bitField0_ & ~0x00000008);
      goalColor_ = 0;
      onChanged();
      return this;
    }

    // repeated .messages.RobotInfo player = 5;
    private java.util.List<messages.RobotInfo> player_ =
      java.util.Collections.emptyList();
    private void ensurePlayerIsMutable() {
      if (!((bitField0_ & 0x00000010) == 0x00000010)) {
        player_ = new java.util.ArrayList<messages.RobotInfo>(player_);
        bitField0_ |= 0x00000010;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        messages.RobotInfo, messages.RobotInfo.Builder, messages.RobotInfoOrBuilder> playerBuilder_;

    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public java.util.List<messages.RobotInfo> getPlayerList() {
      if (playerBuilder_ == null) {
        return java.util.Collections.unmodifiableList(player_);
      } else {
        return playerBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public int getPlayerCount() {
      if (playerBuilder_ == null) {
        return player_.size();
      } else {
        return playerBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public messages.RobotInfo getPlayer(int index) {
      if (playerBuilder_ == null) {
        return player_.get(index);
      } else {
        return playerBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public Builder setPlayer(
        int index, messages.RobotInfo value) {
      if (playerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePlayerIsMutable();
        player_.set(index, value);
        onChanged();
      } else {
        playerBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public Builder setPlayer(
        int index, messages.RobotInfo.Builder builderForValue) {
      if (playerBuilder_ == null) {
        ensurePlayerIsMutable();
        player_.set(index, builderForValue.build());
        onChanged();
      } else {
        playerBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public Builder addPlayer(messages.RobotInfo value) {
      if (playerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePlayerIsMutable();
        player_.add(value);
        onChanged();
      } else {
        playerBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public Builder addPlayer(
        int index, messages.RobotInfo value) {
      if (playerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePlayerIsMutable();
        player_.add(index, value);
        onChanged();
      } else {
        playerBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public Builder addPlayer(
        messages.RobotInfo.Builder builderForValue) {
      if (playerBuilder_ == null) {
        ensurePlayerIsMutable();
        player_.add(builderForValue.build());
        onChanged();
      } else {
        playerBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public Builder addPlayer(
        int index, messages.RobotInfo.Builder builderForValue) {
      if (playerBuilder_ == null) {
        ensurePlayerIsMutable();
        player_.add(index, builderForValue.build());
        onChanged();
      } else {
        playerBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public Builder addAllPlayer(
        java.lang.Iterable<? extends messages.RobotInfo> values) {
      if (playerBuilder_ == null) {
        ensurePlayerIsMutable();
        super.addAll(values, player_);
        onChanged();
      } else {
        playerBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public Builder clearPlayer() {
      if (playerBuilder_ == null) {
        player_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
      } else {
        playerBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public Builder removePlayer(int index) {
      if (playerBuilder_ == null) {
        ensurePlayerIsMutable();
        player_.remove(index);
        onChanged();
      } else {
        playerBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public messages.RobotInfo.Builder getPlayerBuilder(
        int index) {
      return getPlayerFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public messages.RobotInfoOrBuilder getPlayerOrBuilder(
        int index) {
      if (playerBuilder_ == null) {
        return player_.get(index);  } else {
        return playerBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public java.util.List<? extends messages.RobotInfoOrBuilder> 
         getPlayerOrBuilderList() {
      if (playerBuilder_ != null) {
        return playerBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(player_);
      }
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public messages.RobotInfo.Builder addPlayerBuilder() {
      return getPlayerFieldBuilder().addBuilder(
          messages.RobotInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public messages.RobotInfo.Builder addPlayerBuilder(
        int index) {
      return getPlayerFieldBuilder().addBuilder(
          index, messages.RobotInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .messages.RobotInfo player = 5;</code>
     */
    public java.util.List<messages.RobotInfo.Builder> 
         getPlayerBuilderList() {
      return getPlayerFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        messages.RobotInfo, messages.RobotInfo.Builder, messages.RobotInfoOrBuilder> 
        getPlayerFieldBuilder() {
      if (playerBuilder_ == null) {
        playerBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            messages.RobotInfo, messages.RobotInfo.Builder, messages.RobotInfoOrBuilder>(
                player_,
                ((bitField0_ & 0x00000010) == 0x00000010),
                getParentForChildren(),
                isClean());
        player_ = null;
      }
      return playerBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:messages.TeamInfo)
  }

  static {
    defaultInstance = new TeamInfo(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:messages.TeamInfo)
}

