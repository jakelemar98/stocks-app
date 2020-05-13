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
    internal_static_WatchRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_WatchRequest_fieldAccessorTable;
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
      "\030\001 \001(\t\"*\n\014WatchRequest\022\016\n\006symbol\030\001 \001(\t\022\n" +
      "\n\002id\030\002 \001(\t\"+\n\013TimeRequest\022\016\n\006Symbol\030\001 \001(" +
      "\t\022\014\n\004time\030\002 \001(\t\",\n\010Response\022\020\n\010response\030" +
      "\001 \001(\t\022\016\n\006status\030\002 \001(\0052\255\002\n\014StockService\022$" +
      "\n\rGetStockPrice\022\010.Request\032\t.Response\022&\n\017" +
      "GetStockOptions\022\010.Request\032\t.Response\022(\n\r" +
      "GetTimeSeries\022\014.TimeRequest\032\t.Response\022%" +
      "\n\016GetCryptoPrice\022\010.Request\032\t.Response\022)\n" +
      "\rAddStockWatch\022\r.WatchRequest\032\t.Response" +
      "\022\'\n\013GetWatching\022\r.WatchRequest\032\t.Respons" +
      "e\022*\n\016UpdateWatching\022\r.WatchRequest\032\t.Res" +
      "ponseB\034\n\030com.grpc.services.stocksP\001b\006pro" +
      "to3"
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
    internal_static_WatchRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_WatchRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_WatchRequest_descriptor,
        new java.lang.String[] { "Symbol", "Id", });
    internal_static_TimeRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_TimeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TimeRequest_descriptor,
        new java.lang.String[] { "Symbol", "Time", });
    internal_static_Response_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Response_descriptor,
        new java.lang.String[] { "Response", "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
