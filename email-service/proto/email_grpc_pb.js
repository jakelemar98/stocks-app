// GENERATED CODE -- DO NOT EDIT!

// Original file comments:
// Email proto file to connect 
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
