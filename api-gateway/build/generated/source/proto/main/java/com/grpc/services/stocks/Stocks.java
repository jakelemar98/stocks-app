// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stocks.proto

package com.grpc.services.stocks;

public final class Stocks {
  private Stocks() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Request_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Request_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TimeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TimeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Response_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014stocks.proto\"\036\n\007Request\022\023\n\013stockSymbol" +
      "\030\001 \001(\t\"+\n\013TimeRequest\022\016\n\006Symbol\030\001 \001(\t\022\014\n" +
      "\004time\030\002 \001(\t\",\n\010Response\022\020\n\010response\030\001 \001(" +
      "\t\022\016\n\006status\030\002 \001(\0052\206\001\n\014StockService\022$\n\rGe" +
      "tStockPrice\022\010.Request\032\t.Response\022&\n\017GetS" +
      "tockOptions\022\010.Request\032\t.Response\022(\n\rGetT" +
      "imeSeries\022\014.TimeRequest\032\t.ResponseB\034\n\030co" +
      "m.grpc.services.stocksP\001b\006proto3"
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
    internal_static_Request_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Request_descriptor,
        new java.lang.String[] { "StockSymbol", });
    internal_static_TimeRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_TimeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TimeRequest_descriptor,
        new java.lang.String[] { "Symbol", "Time", });
    internal_static_Response_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Response_descriptor,
        new java.lang.String[] { "Response", "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
