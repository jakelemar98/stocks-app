# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

import email_pb2 as email__pb2


class EmailServiceStub(object):
  # missing associated documentation comment in .proto file
  pass

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.VerifyEmail = channel.unary_unary(
        '/EmailService/VerifyEmail',
        request_serializer=email__pb2.VerifyRequest.SerializeToString,
        response_deserializer=email__pb2.EmailReply.FromString,
        )
    self.CheckVerified = channel.unary_unary(
        '/EmailService/CheckVerified',
        request_serializer=email__pb2.CheckRequest.SerializeToString,
        response_deserializer=email__pb2.EmailReply.FromString,
        )


class EmailServiceServicer(object):
  # missing associated documentation comment in .proto file
  pass

  def VerifyEmail(self, request, context):
    # missing associated documentation comment in .proto file
    pass
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def CheckVerified(self, request, context):
    # missing associated documentation comment in .proto file
    pass
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_EmailServiceServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'VerifyEmail': grpc.unary_unary_rpc_method_handler(
          servicer.VerifyEmail,
          request_deserializer=email__pb2.VerifyRequest.FromString,
          response_serializer=email__pb2.EmailReply.SerializeToString,
      ),
      'CheckVerified': grpc.unary_unary_rpc_method_handler(
          servicer.CheckVerified,
          request_deserializer=email__pb2.CheckRequest.FromString,
          response_serializer=email__pb2.EmailReply.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'EmailService', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))
