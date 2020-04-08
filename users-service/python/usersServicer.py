import grpc
from concurrent import futures
import logging
import sys

sys.path.append("../proto")
import db
import users_pb2
import users_pb2_grpc

class UsersServicer(users_pb2_grpc.UserServiceServicer):
    
    def GetUser(self, request, context):
        print("Request made")
        return users_pb2.UserResponse(message='Hello, %s!' % request.message)

    def CreateUser(self, request, context):
        print("request made to create user")
        message = db.createUser(request)
        print(request)
        return users_pb2.UserResponse(message=message)