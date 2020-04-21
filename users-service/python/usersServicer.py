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
        print("Request made to get user %s", request.email)
        body, token, status = db.getUser(request)
        return users_pb2.UserResponse(body = body, token = token, status = status)

    def CreateUser(self, request, context):
        print("request made to create user")
        body, token, status = db.createUser(request)
        return users_pb2.UserResponse(body = body, token = token, status = status)

    def VerifyUser(self, request, context):
        print("request made to verify user")
        body, status = db.verifyUser(request)
        return users_pb2.VerifyResponse(body = body, status = status)