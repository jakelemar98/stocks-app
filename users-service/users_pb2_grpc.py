# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

import users_pb2 as users__pb2


class UserServiceStub(object):
  # missing associated documentation comment in .proto file
  pass

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.GetUser = channel.unary_unary(
        '/UserService/GetUser',
        request_serializer=users__pb2.UserRequest.SerializeToString,
        response_deserializer=users__pb2.UserResponse.FromString,
        )


class UserServiceServicer(object):
  # missing associated documentation comment in .proto file
  pass

  def GetUser(self, request, context):
    # missing associated documentation comment in .proto file
    pass
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_UserServiceServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'GetUser': grpc.unary_unary_rpc_method_handler(
          servicer.GetUser,
          request_deserializer=users__pb2.UserRequest.FromString,
          response_serializer=users__pb2.UserResponse.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'UserService', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))
