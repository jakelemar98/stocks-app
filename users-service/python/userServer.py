import grpc
from concurrent import futures
import logging

import sys

sys.path.append("../proto")

import emailClient
import users_pb2
import users_pb2_grpc

class UsersServicer(users_pb2_grpc.UserServiceServicer):

    def GetUser(self, request, context):
        print("Request made")
        return users_pb2.UserResponse(message='Hello, %s!' % request.message)


def serve():
    emailClient.sendEmail()
    print("Serving....")
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    users_pb2_grpc.add_UserServiceServicer_to_server(UsersServicer(), server)
    server.add_insecure_port('[::]:8001')
    server.start()
    server.wait_for_termination()

if __name__ == '__main__':
    serve()