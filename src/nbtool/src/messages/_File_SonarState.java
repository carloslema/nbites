// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SonarState.proto

package messages;

public final class _File_SonarState {
  private _File_SonarState() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_SonarState_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_SonarState_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020SonarState.proto\022\010messages\"/\n\nSonarSta" +
      "te\022\017\n\007us_left\030\001 \001(\002\022\020\n\010us_right\030\002 \001(\002B\024B" +
      "\020_File_SonarStateP\001"
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
    internal_static_messages_SonarState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_messages_SonarState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_SonarState_descriptor,
        new java.lang.String[] { "UsLeft", "UsRight", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
