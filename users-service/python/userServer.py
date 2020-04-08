import grpc
from concurrent import futures
import sys

sys.path.append("../proto")

import users_pb2_grpc
import usersServicer


def serve():
    print("Serving....")
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    users_pb2_grpc.add_UserServiceServicer_to_server(usersServicer.UsersServicer(), server)
    server.add_insecure_port('[::]:8001')
    server.start()
    server.wait_for_termination()

if __name__ == '__main__':
    serve()