// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GameState.proto

package messages;

public final class _File_GameState {
  private _File_GameState() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_GameState_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_GameState_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_TeamInfo_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_TeamInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_RobotInfo_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_RobotInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017GameState.proto\022\010messages\"\353\001\n\tGameStat" +
      "e\022\r\n\005state\030\001 \001(\r\022\030\n\nfirst_half\030\002 \001(\010:\004tr" +
      "ue\022\025\n\rkick_off_team\030\003 \001(\r\022\027\n\017secondary_s" +
      "tate\030\004 \001(\r\022\024\n\014drop_in_team\030\005 \001(\r\022\030\n\014drop" +
      "_in_time\030\006 \001(\021:\002-1\022\033\n\016secs_remaining\030\007 \001" +
      "(\r:\003600\022\026\n\016have_remote_gc\030\010 \001(\010\022 \n\004team\030" +
      "\t \003(\0132\022.messages.TeamInfo\"{\n\010TeamInfo\022\023\n" +
      "\013team_number\030\001 \001(\r\022\022\n\nteam_color\030\002 \001(\r\022\r" +
      "\n\005score\030\003 \001(\r\022\022\n\ngoal_color\030\004 \001(\r\022#\n\006pla" +
      "yer\030\005 \003(\0132\023.messages.RobotInfo\"/\n\tRobotI",
      "nfo\022\017\n\007penalty\030\001 \001(\r\022\021\n\tsecs_left\030\002 \001(\rB" +
      "\023B\017_File_GameStateP\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_messages_GameState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_messages_GameState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_GameState_descriptor,
        new java.lang.String[] { "State", "FirstHalf", "KickOffTeam", "SecondaryState", "DropInTeam", "DropInTime", "SecsRemaining", "HaveRemoteGc", "Team", });
    internal_static_messages_TeamInfo_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_messages_TeamInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_TeamInfo_descriptor,
        new java.lang.String[] { "TeamNumber", "TeamColor", "Score", "GoalColor", "Player", });
    internal_static_messages_RobotInfo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_messages_RobotInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_RobotInfo_descriptor,
        new java.lang.String[] { "Penalty", "SecsLeft", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}