import grpc
import sys

sys.path.append("../proto")

import email_pb2
import email_pb2_grpc

def sendEmail():
    channel = grpc.insecure_channel('email-service:5001')
    stub = email_pb2_grpc.EmailServiceStub(channel)

    em = email_pb2.Email(toAddress=["JakeLemar98@gmail.com"], subject="Hello, Soph", html="This is what I do at night after you go to bed")

    response = stub.SendMail(email_pb2.EmailRequest(email=em))

    print(response.reply)