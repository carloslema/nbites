// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MotionStatus.proto

package messages;

public final class _File_MotionStatus {
  private _File_MotionStatus() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_MotionStatus_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_MotionStatus_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022MotionStatus.proto\022\010messages\"\215\001\n\014Motio" +
      "nStatus\022\020\n\010standing\030\001 \001(\010\022\026\n\016body_is_act" +
      "ive\030\002 \001(\010\022\026\n\016walk_is_active\030\003 \001(\010\022\026\n\016hea" +
      "d_is_active\030\004 \001(\010\022\022\n\ncalibrated\030\005 \001(\010\022\017\n" +
      "\007upright\030\006 \001(\010B\026B\022_File_MotionStatusP\001"
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
    internal_static_messages_MotionStatus_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_messages_MotionStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_MotionStatus_descriptor,
        new java.lang.String[] { "Standing", "BodyIsActive", "WalkIsActive", "HeadIsActive", "Calibrated", "Upright", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
