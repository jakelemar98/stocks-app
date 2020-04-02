// GENERATED CODE -- DO NOT EDIT!

// Original file comments:
// Email proto file to connect services to Email-Service
//
// 
// Command For Node Compolation
// run from /stocks-app/proto dir
// grpc_tools_node_protoc -I=. --js_out=import_style=commonjs,binary:../email-service/proto --grpc_out=../email-service/proto --plugin=protoc-gen-grpc=`which grpc_tools_node_protoc_plugin` email.proto 
//
// Go protoc complation command
// run from /stocks-app/proto dir
// protoc --go_out=plugins=grpc:../stocks-service/proto email.proto
//
// Python Protoc complation command
// run from /stocks-app/proto dir
// python3 -m grpc_tools.protoc -I. --python_out=../users-service/proto --grpc_python_out=../users-service/proto  email.proto
//
'use strict';
var grpc = require('grpc');
var email_pb = require('./email_pb.js');

function serialize_EmailReply(arg) {
  if (!(arg instanceof email_pb.EmailReply)) {
    throw new Error('Expected argument of type EmailReply');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_EmailReply(buffer_arg) {
  return email_pb.EmailReply.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_EmailRequest(arg) {
  if (!(arg instanceof email_pb.EmailRequest)) {
    throw new Error('Expected argument of type EmailRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_EmailRequest(buffer_arg) {
  return email_pb.EmailRequest.deserializeBinary(new Uint8Array(buffer_arg));
}


var EmailServiceService = exports.EmailServiceService = {
  sendMail: {
    path: '/EmailService/SendMail',
    requestStream: false,
    responseStream: false,
    requestType: email_pb.EmailRequest,
    responseType: email_pb.EmailReply,
    requestSerialize: serialize_EmailRequest,
    requestDeserialize: deserialize_EmailRequest,
    responseSerialize: serialize_EmailReply,
    responseDeserialize: deserialize_EmailReply,
  },
};

exports.EmailServiceClient = grpc.makeGenericClientConstructor(EmailServiceService);
