// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: email.proto

package com.grpc.services.email;

public final class EmailOuterClass {
  private EmailOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmailRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmailRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmailReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmailReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VerifyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VerifyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Email_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Email_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013email.proto\"%\n\014EmailRequest\022\025\n\005email\030\001" +
      " \001(\0132\006.Email\"*\n\nEmailReply\022\014\n\004body\030\001 \001(\t" +
      "\022\016\n\006status\030\002 \001(\005\"*\n\rVerifyRequest\022\n\n\002id\030" +
      "\001 \001(\t\022\r\n\005email\030\002 \001(\t\"(\n\014CheckRequest\022\n\n\002" +
      "id\030\001 \001(\t\022\014\n\004code\030\002 \001(\005\"9\n\005Email\022\021\n\ttoAdd" +
      "ress\030\001 \003(\t\022\017\n\007subject\030\002 \001(\t\022\014\n\004html\030\003 \001(" +
      "\t2k\n\014EmailService\022,\n\013VerifyEmail\022\016.Verif" +
      "yRequest\032\013.EmailReply\"\000\022-\n\rCheckVerified" +
      "\022\r.CheckRequest\032\013.EmailReply\"\000B\033\n\027com.gr" +
      "pc.services.emailP\001b\006proto3"
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
    internal_static_EmailRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_EmailRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmailRequest_descriptor,
        new java.lang.String[] { "Email", });
    internal_static_EmailReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_EmailReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmailReply_descriptor,
        new java.lang.String[] { "Body", "Status", });
    internal_static_VerifyRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_VerifyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VerifyRequest_descriptor,
        new java.lang.String[] { "Id", "Email", });
    internal_static_CheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_CheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CheckRequest_descriptor,
        new java.lang.String[] { "Id", "Code", });
    internal_static_Email_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Email_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Email_descriptor,
        new java.lang.String[] { "ToAddress", "Subject", "Html", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
