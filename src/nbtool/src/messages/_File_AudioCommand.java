// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AudioCommand.proto

package messages;

public final class _File_AudioCommand {
  private _File_AudioCommand() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_AudioCommand_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_AudioCommand_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022AudioCommand.proto\022\010messages\"\"\n\014AudioC" +
      "ommand\022\022\n\naudio_file\030\001 \001(\tB\026B\022_File_Audi" +
      "oCommandP\001"
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
    internal_static_messages_AudioCommand_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_messages_AudioCommand_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_AudioCommand_descriptor,
        new java.lang.String[] { "AudioFile", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
