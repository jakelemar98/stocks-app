// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: users.proto

package com.grpc.services.users;

public final class Users {
  private Users() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_NewUserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_NewUserRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013users.proto\"\036\n\013UserRequest\022\017\n\007message\030" +
      "\001 \001(\t\"\037\n\014UserResponse\022\017\n\007message\030\001 \001(\t\"V" +
      "\n\016NewUserRequest\022\021\n\tfirstname\030\001 \001(\t\022\020\n\010l" +
      "astname\030\002 \001(\t\022\r\n\005email\030\003 \001(\t\022\020\n\010password" +
      "\030\004 \001(\t2c\n\013UserService\022&\n\007GetUser\022\014.UserR" +
      "equest\032\r.UserResponse\022,\n\nCreateUser\022\017.Ne" +
      "wUserRequest\032\r.UserResponseB\033\n\027com.grpc." +
      "services.usersP\001b\006proto3"
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
    internal_static_UserRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_UserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserRequest_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_UserResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_UserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_NewUserRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_NewUserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_NewUserRequest_descriptor,
        new java.lang.String[] { "Firstname", "Lastname", "Email", "Password", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
