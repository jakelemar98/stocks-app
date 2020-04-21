package com.grpc.services.email;

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
    comments = "Source: email.proto")
public final class EmailServiceGrpc {

  private EmailServiceGrpc() {}

  public static final String SERVICE_NAME = "EmailService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.services.email.VerifyRequest,
      com.grpc.services.email.EmailReply> getVerifyEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyEmail",
      requestType = com.grpc.services.email.VerifyRequest.class,
      responseType = com.grpc.services.email.EmailReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.services.email.VerifyRequest,
      com.grpc.services.email.EmailReply> getVerifyEmailMethod() {
    io.grpc.MethodDescriptor<com.grpc.services.email.VerifyRequest, com.grpc.services.email.EmailReply> getVerifyEmailMethod;
    if ((getVerifyEmailMethod = EmailServiceGrpc.getVerifyEmailMethod) == null) {
      synchronized (EmailServiceGrpc.class) {
        if ((getVerifyEmailMethod = EmailServiceGrpc.getVerifyEmailMethod) == null) {
          EmailServiceGrpc.getVerifyEmailMethod = getVerifyEmailMethod = 
              io.grpc.MethodDescriptor.<com.grpc.services.email.VerifyRequest, com.grpc.services.email.EmailReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "EmailService", "VerifyEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.email.VerifyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.email.EmailReply.getDefaultInstance()))
                  .setSchemaDescriptor(new EmailServiceMethodDescriptorSupplier("VerifyEmail"))
                  .build();
          }
        }
     }
     return getVerifyEmailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.services.email.CheckRequest,
      com.grpc.services.email.EmailReply> getCheckVerifiedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckVerified",
      requestType = com.grpc.services.email.CheckRequest.class,
      responseType = com.grpc.services.email.EmailReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.services.email.CheckRequest,
      com.grpc.services.email.EmailReply> getCheckVerifiedMethod() {
    io.grpc.MethodDescriptor<com.grpc.services.email.CheckRequest, com.grpc.services.email.EmailReply> getCheckVerifiedMethod;
    if ((getCheckVerifiedMethod = EmailServiceGrpc.getCheckVerifiedMethod) == null) {
      synchronized (EmailServiceGrpc.class) {
        if ((getCheckVerifiedMethod = EmailServiceGrpc.getCheckVerifiedMethod) == null) {
          EmailServiceGrpc.getCheckVerifiedMethod = getCheckVerifiedMethod = 
              io.grpc.MethodDescriptor.<com.grpc.services.email.CheckRequest, com.grpc.services.email.EmailReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "EmailService", "CheckVerified"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.email.CheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.services.email.EmailReply.getDefaultInstance()))
                  .setSchemaDescriptor(new EmailServiceMethodDescriptorSupplier("CheckVerified"))
                  .build();
          }
        }
     }
     return getCheckVerifiedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmailServiceStub newStub(io.grpc.Channel channel) {
    return new EmailServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmailServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EmailServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmailServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EmailServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EmailServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void verifyEmail(com.grpc.services.email.VerifyRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.email.EmailReply> responseObserver) {
      asyncUnimplementedUnaryCall(getVerifyEmailMethod(), responseObserver);
    }

    /**
     */
    public void checkVerified(com.grpc.services.email.CheckRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.email.EmailReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckVerifiedMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVerifyEmailMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.services.email.VerifyRequest,
                com.grpc.services.email.EmailReply>(
                  this, METHODID_VERIFY_EMAIL)))
          .addMethod(
            getCheckVerifiedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.services.email.CheckRequest,
                com.grpc.services.email.EmailReply>(
                  this, METHODID_CHECK_VERIFIED)))
          .build();
    }
  }

  /**
   */
  public static final class EmailServiceStub extends io.grpc.stub.AbstractStub<EmailServiceStub> {
    private EmailServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmailServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmailServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmailServiceStub(channel, callOptions);
    }

    /**
     */
    public void verifyEmail(com.grpc.services.email.VerifyRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.email.EmailReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVerifyEmailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkVerified(com.grpc.services.email.CheckRequest request,
        io.grpc.stub.StreamObserver<com.grpc.services.email.EmailReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckVerifiedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EmailServiceBlockingStub extends io.grpc.stub.AbstractStub<EmailServiceBlockingStub> {
    private EmailServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmailServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmailServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmailServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpc.services.email.EmailReply verifyEmail(com.grpc.services.email.VerifyRequest request) {
      return blockingUnaryCall(
          getChannel(), getVerifyEmailMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.services.email.EmailReply checkVerified(com.grpc.services.email.CheckRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckVerifiedMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EmailServiceFutureStub extends io.grpc.stub.AbstractStub<EmailServiceFutureStub> {
    private EmailServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmailServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmailServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmailServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.services.email.EmailReply> verifyEmail(
        com.grpc.services.email.VerifyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVerifyEmailMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.services.email.EmailReply> checkVerified(
        com.grpc.services.email.CheckRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckVerifiedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VERIFY_EMAIL = 0;
  private static final int METHODID_CHECK_VERIFIED = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmailServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmailServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VERIFY_EMAIL:
          serviceImpl.verifyEmail((com.grpc.services.email.VerifyRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.services.email.EmailReply>) responseObserver);
          break;
        case METHODID_CHECK_VERIFIED:
          serviceImpl.checkVerified((com.grpc.services.email.CheckRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.services.email.EmailReply>) responseObserver);
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

  private static abstract class EmailServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmailServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.services.email.EmailOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmailService");
    }
  }

  private static final class EmailServiceFileDescriptorSupplier
      extends EmailServiceBaseDescriptorSupplier {
    EmailServiceFileDescriptorSupplier() {}
  }

  private static final class EmailServiceMethodDescriptorSupplier
      extends EmailServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EmailServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EmailServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmailServiceFileDescriptorSupplier())
              .addMethod(getVerifyEmailMethod())
              .addMethod(getCheckVerifiedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
