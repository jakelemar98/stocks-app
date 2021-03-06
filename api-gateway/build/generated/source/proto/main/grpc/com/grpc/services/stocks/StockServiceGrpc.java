package com.grpc.services.stocks;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: stocks.proto")
public final class StockServiceGrpc {

  private StockServiceGrpc() {}

  public static final String SERVICE_NAME = "StockService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.services.stocks.Request,
      com.grpc.services.stocks.Response> getGetStockPriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStockPrice",
      requestType = com.grpc.services.stocks.Request.class,
      responseType = com.grpc.services.stocks.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.services.stocks.Request,
      com.grpc.services.stocks.Response> getGetStockPriceMethod() {
    io.grpc.MethodDescriptor<com.grpc.services.stocks.Request, com.grpc.services.stocks.Response> getGetStockPriceMethod;
    if ((getGetStockPriceMethod = StockServiceGrpc.getGetStockPriceMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getGetStockPriceMethod = StockServiceGrpc.getGetStockPriceMethod) == null) {
          StockServiceGrpc.getGetStockPriceMethod = getGetStockPriceMethod = 
              io.grpc.MethodDescriptor.<com.grpc.services.stocks.Request, com.grpc.services.stocks.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockService", "GetStockPrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("GetStockPrice"))
                  .build();
          }
        }
     }
     return getGetStockPriceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.services.stocks.Request,
      com.grpc.services.stocks.Response> getGetStockOptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStockOptions",
      requestType = com.grpc.services.stocks.Request.class,
      responseType = com.grpc.services.stocks.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.services.stocks.Request,
      com.grpc.services.stocks.Response> getGetStockOptionsMethod() {
    io.grpc.MethodDescriptor<com.grpc.services.stocks.Request, com.grpc.services.stocks.Response> getGetStockOptionsMethod;
    if ((getGetStockOptionsMethod = StockServiceGrpc.getGetStockOptionsMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getGetStockOptionsMethod = StockServiceGrpc.getGetStockOptionsMethod) == null) {
          StockServiceGrpc.getGetStockOptionsMethod = getGetStockOptionsMethod = 
              io.grpc.MethodDescriptor.<com.grpc.services.stocks.Request, com.grpc.services.stocks.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockService", "GetStockOptions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("GetStockOptions"))
                  .build();
          }
        }
     }
     return getGetStockOptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.services.stocks.TimeRequest,
      com.grpc.services.stocks.Response> getGetTimeSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTimeSeries",
      requestType = com.grpc.services.stocks.TimeRequest.class,
      responseType = com.grpc.services.stocks.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.services.stocks.TimeRequest,
      com.grpc.services.stocks.Response> getGetTimeSeriesMethod() {
    io.grpc.MethodDescriptor<com.grpc.services.stocks.TimeRequest, com.grpc.services.stocks.Response> getGetTimeSeriesMethod;
    if ((getGetTimeSeriesMethod = StockServiceGrpc.getGetTimeSeriesMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getGetTimeSeriesMethod = StockServiceGrpc.getGetTimeSeriesMethod) == null) {
          StockServiceGrpc.getGetTimeSeriesMethod = getGetTimeSeriesMethod = 
              io.grpc.MethodDescriptor.<com.grpc.services.stocks.TimeRequest, com.grpc.services.stocks.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockService", "GetTimeSeries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.TimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("GetTimeSeries"))
                  .build();
          }
        }
     }
     return getGetTimeSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.services.stocks.Request,
      com.grpc.services.stocks.Response> getGetCryptoPriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCryptoPrice",
      requestType = com.grpc.services.stocks.Request.class,
      responseType = com.grpc.services.stocks.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.services.stocks.Request,
      com.grpc.services.stocks.Response> getGetCryptoPriceMethod() {
    io.grpc.MethodDescriptor<com.grpc.services.stocks.Request, com.grpc.services.stocks.Response> getGetCryptoPriceMethod;
    if ((getGetCryptoPriceMethod = StockServiceGrpc.getGetCryptoPriceMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getGetCryptoPriceMethod = StockServiceGrpc.getGetCryptoPriceMethod) == null) {
          StockServiceGrpc.getGetCryptoPriceMethod = getGetCryptoPriceMethod = 
              io.grpc.MethodDescriptor.<com.grpc.services.stocks.Request, com.grpc.services.stocks.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockService", "GetCryptoPrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("GetCryptoPrice"))
                  .build();
          }
        }
     }
     return getGetCryptoPriceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.services.stocks.WatchRequest,
      com.grpc.services.stocks.Response> getAddStockWatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddStockWatch",
      requestType = com.grpc.services.stocks.WatchRequest.class,
      responseType = com.grpc.services.stocks.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.services.stocks.WatchRequest,
      com.grpc.services.stocks.Response> getAddStockWatchMethod() {
    io.grpc.MethodDescriptor<com.grpc.services.stocks.WatchRequest, com.grpc.services.stocks.Response> getAddStockWatchMethod;
    if ((getAddStockWatchMethod = StockServiceGrpc.getAddStockWatchMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getAddStockWatchMethod = StockServiceGrpc.getAddStockWatchMethod) == null) {
          StockServiceGrpc.getAddStockWatchMethod = getAddStockWatchMethod = 
              io.grpc.MethodDescriptor.<com.grpc.services.stocks.WatchRequest, com.grpc.services.stocks.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockService", "AddStockWatch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.WatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("AddStockWatch"))
                  .build();
          }
        }
     }
     return getAddStockWatchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.services.stocks.WatchRequest,
      com.grpc.services.stocks.Response> getGetWatchingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWatching",
      requestType = com.grpc.services.stocks.WatchRequest.class,
      responseType = com.grpc.services.stocks.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.services.stocks.WatchRequest,
      com.grpc.services.stocks.Response> getGetWatchingMethod() {
    io.grpc.MethodDescriptor<com.grpc.services.stocks.WatchRequest, com.grpc.services.stocks.Response> getGetWatchingMethod;
    if ((getGetWatchingMethod = StockServiceGrpc.getGetWatchingMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getGetWatchingMethod = StockServiceGrpc.getGetWatchingMethod) == null) {
          StockServiceGrpc.getGetWatchingMethod = getGetWatchingMethod = 
              io.grpc.MethodDescriptor.<com.grpc.services.stocks.WatchRequest, com.grpc.services.stocks.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockService", "GetWatching"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.WatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("GetWatching"))
                  .build();
          }
        }
     }
     return getGetWatchingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.services.stocks.WatchRequest,
      com.grpc.services.stocks.Response> getUpdateWatchingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWatching",
      requestType = com.grpc.services.stocks.WatchRequest.class,
      responseType = com.grpc.services.stocks.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.services.stocks.WatchRequest,
      com.grpc.services.stocks.Response> getUpdateWatchingMethod() {
    io.grpc.MethodDescriptor<com.grpc.services.stocks.WatchRequest, com.grpc.services.stocks.Response> getUpdateWatchingMethod;
    if ((getUpdateWatchingMethod = StockServiceGrpc.getUpdateWatchingMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getUpdateWatchingMethod = StockServiceGrpc.getUpdateWatchingMethod) == null) {
          StockServiceGrpc.getUpdateWatchingMethod = getUpdateWatchingMethod = 
              io.grpc.MethodDescriptor.<com.grpc.services.stocks.WatchRequest, com.grpc.services.stocks.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockService", "UpdateWatching"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.WatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.stocks.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("UpdateWatching"))
                  .build();
          }
        }
     }
     return getUpdateWatchingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StockServiceStub newStub(io.grpc.Channel channel) {
    return new StockServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StockServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StockServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StockServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getStockPrice(com.grpc.services.stocks.Request request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStockPriceMethod(), responseObserver);
    }

    /**
     */
    public void getStockOptions(com.grpc.services.stocks.Request request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStockOptionsMethod(), responseObserver);
    }

    /**
     */
    public void getTimeSeries(com.grpc.services.stocks.TimeRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTimeSeriesMethod(), responseObserver);
    }

    /**
     */
    public void getCryptoPrice(com.grpc.services.stocks.Request request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCryptoPriceMethod(), responseObserver);
    }

    /**
     */
    public void addStockWatch(com.grpc.services.stocks.WatchRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getAddStockWatchMethod(), responseObserver);
    }

    /**
     */
    public void getWatching(com.grpc.services.stocks.WatchRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetWatchingMethod(), responseObserver);
    }

    /**
     */
    public void updateWatching(com.grpc.services.stocks.WatchRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateWatchingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetStockPriceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.services.stocks.Request,
                com.grpc.services.stocks.Response>(
                  this, METHODID_GET_STOCK_PRICE)))
          .addMethod(
            getGetStockOptionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.services.stocks.Request,
                com.grpc.services.stocks.Response>(
                  this, METHODID_GET_STOCK_OPTIONS)))
          .addMethod(
            getGetTimeSeriesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.services.stocks.TimeRequest,
                com.grpc.services.stocks.Response>(
                  this, METHODID_GET_TIME_SERIES)))
          .addMethod(
            getGetCryptoPriceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.services.stocks.Request,
                com.grpc.services.stocks.Response>(
                  this, METHODID_GET_CRYPTO_PRICE)))
          .addMethod(
            getAddStockWatchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.services.stocks.WatchRequest,
                com.grpc.services.stocks.Response>(
                  this, METHODID_ADD_STOCK_WATCH)))
          .addMethod(
            getGetWatchingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.services.stocks.WatchRequest,
                com.grpc.services.stocks.Response>(
                  this, METHODID_GET_WATCHING)))
          .addMethod(
            getUpdateWatchingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.services.stocks.WatchRequest,
                com.grpc.services.stocks.Response>(
                  this, METHODID_UPDATE_WATCHING)))
          .build();
    }
  }

  /**
   */
  public static final class StockServiceStub extends io.grpc.stub.AbstractStub<StockServiceStub> {
    private StockServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceStub(channel, callOptions);
    }

    /**
     */
    public void getStockPrice(com.grpc.services.stocks.Request request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStockPriceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStockOptions(com.grpc.services.stocks.Request request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStockOptionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTimeSeries(com.grpc.services.stocks.TimeRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTimeSeriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCryptoPrice(com.grpc.services.stocks.Request request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCryptoPriceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addStockWatch(com.grpc.services.stocks.WatchRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddStockWatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getWatching(com.grpc.services.stocks.WatchRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetWatchingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateWatching(com.grpc.services.stocks.WatchRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateWatchingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StockServiceBlockingStub extends io.grpc.stub.AbstractStub<StockServiceBlockingStub> {
    private StockServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpc.services.stocks.Response getStockPrice(com.grpc.services.stocks.Request request) {
      return blockingUnaryCall(
          getChannel(), getGetStockPriceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.services.stocks.Response getStockOptions(com.grpc.services.stocks.Request request) {
      return blockingUnaryCall(
          getChannel(), getGetStockOptionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.services.stocks.Response getTimeSeries(com.grpc.services.stocks.TimeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTimeSeriesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.services.stocks.Response getCryptoPrice(com.grpc.services.stocks.Request request) {
      return blockingUnaryCall(
          getChannel(), getGetCryptoPriceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.services.stocks.Response addStockWatch(com.grpc.services.stocks.WatchRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddStockWatchMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.services.stocks.Response getWatching(com.grpc.services.stocks.WatchRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetWatchingMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.services.stocks.Response updateWatching(com.grpc.services.stocks.WatchRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateWatchingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StockServiceFutureStub extends io.grpc.stub.AbstractStub<StockServiceFutureStub> {
    private StockServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.services.stocks.Response> getStockPrice(
        com.grpc.services.stocks.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStockPriceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.services.stocks.Response> getStockOptions(
        com.grpc.services.stocks.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStockOptionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.services.stocks.Response> getTimeSeries(
        com.grpc.services.stocks.TimeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTimeSeriesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.services.stocks.Response> getCryptoPrice(
        com.grpc.services.stocks.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCryptoPriceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.services.stocks.Response> addStockWatch(
        com.grpc.services.stocks.WatchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddStockWatchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.services.stocks.Response> getWatching(
        com.grpc.services.stocks.WatchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetWatchingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.services.stocks.Response> updateWatching(
        com.grpc.services.stocks.WatchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateWatchingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STOCK_PRICE = 0;
  private static final int METHODID_GET_STOCK_OPTIONS = 1;
  private static final int METHODID_GET_TIME_SERIES = 2;
  private static final int METHODID_GET_CRYPTO_PRICE = 3;
  private static final int METHODID_ADD_STOCK_WATCH = 4;
  private static final int METHODID_GET_WATCHING = 5;
  private static final int METHODID_UPDATE_WATCHING = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StockServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StockServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STOCK_PRICE:
          serviceImpl.getStockPrice((com.grpc.services.stocks.Request) request,
              (io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response>) responseObserver);
          break;
        case METHODID_GET_STOCK_OPTIONS:
          serviceImpl.getStockOptions((com.grpc.services.stocks.Request) request,
              (io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response>) responseObserver);
          break;
        case METHODID_GET_TIME_SERIES:
          serviceImpl.getTimeSeries((com.grpc.services.stocks.TimeRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response>) responseObserver);
          break;
        case METHODID_GET_CRYPTO_PRICE:
          serviceImpl.getCryptoPrice((com.grpc.services.stocks.Request) request,
              (io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response>) responseObserver);
          break;
        case METHODID_ADD_STOCK_WATCH:
          serviceImpl.addStockWatch((com.grpc.services.stocks.WatchRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response>) responseObserver);
          break;
        case METHODID_GET_WATCHING:
          serviceImpl.getWatching((com.grpc.services.stocks.WatchRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response>) responseObserver);
          break;
        case METHODID_UPDATE_WATCHING:
          serviceImpl.updateWatching((com.grpc.services.stocks.WatchRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.services.stocks.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StockServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.services.stocks.Stocks.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StockService");
    }
  }

  private static final class StockServiceFileDescriptorSupplier
      extends StockServiceBaseDescriptorSupplier {
    StockServiceFileDescriptorSupplier() {}
  }

  private static final class StockServiceMethodDescriptorSupplier
      extends StockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StockServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StockServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StockServiceFileDescriptorSupplier())
              .addMethod(getGetStockPriceMethod())
              .addMethod(getGetStockOptionsMethod())
              .addMethod(getGetTimeSeriesMethod())
              .addMethod(getGetCryptoPriceMethod())
              .addMethod(getAddStockWatchMethod())
              .addMethod(getGetWatchingMethod())
              .addMethod(getUpdateWatchingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
