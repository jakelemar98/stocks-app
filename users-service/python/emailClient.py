import grpc
import sys

sys.path.append("../proto")

import email_pb2
import email_pb2_grpc

def sendEmail():
    channel = grpc.insecure_channel('email-service:5001')
    stub = email_pb2_grpc.EmailServiceStub(channel)

    em = email_pb2.Email(toAddress=["JakeLemar@gmail.com"], fromAddress="hello@gmail.com", subject="not much", html="heyeyyyyy")
    print(em)
    response = stub.SendMail(email_pb2.EmailRequest(email=em))

    print(response.reply)