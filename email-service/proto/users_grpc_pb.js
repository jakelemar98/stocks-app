// GENERATED CODE -- DO NOT EDIT!

// Original file comments:
// Proto to connect Java Gateway to Python Users-service
//
// 
// Java protoc complation done for you throug Gradle ( ./gradlew clean build )
//
// Python protoc complation command
// run from /stocks-app/proto dir
// python3 -m grpc_tools.protoc -I. --python_out=../users-service/proto --grpc_python_out=../users-service/proto  users.proto
//
// Node Compilation command 
// run from /stocks-app/proto dir
// grpc_tools_node_protoc -I=. --js_out=import_style=commonjs,binary:../email-service/proto --grpc_out=../email-service/proto --plugin=protoc-gen-grpc=`which grpc_tools_node_protoc_plugin` users.proto 
//
//
'use strict';
var grpc = require('grpc');
var users_pb = require('./users_pb.js');

function serialize_NewUserRequest(arg) {
  if (!(arg instanceof users_pb.NewUserRequest)) {
    throw new Error('Expected argument of type NewUserRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_NewUserRequest(buffer_arg) {
  return users_pb.NewUserRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_UserLogin(arg) {
  if (!(arg instanceof users_pb.UserLogin)) {
    throw new Error('Expected argument of type UserLogin');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_UserLogin(buffer_arg) {
  return users_pb.UserLogin.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_UserResponse(arg) {
  if (!(arg instanceof users_pb.UserResponse)) {
    throw new Error('Expected argument of type UserResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_UserResponse(buffer_arg) {
  return users_pb.UserResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_VerifyResponse(arg) {
  if (!(arg instanceof users_pb.VerifyResponse)) {
    throw new Error('Expected argument of type VerifyResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_VerifyResponse(buffer_arg) {
  return users_pb.VerifyResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_VerifyUserRequest(arg) {
  if (!(arg instanceof users_pb.VerifyUserRequest)) {
    throw new Error('Expected argument of type VerifyUserRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_VerifyUserRequest(buffer_arg) {
  return users_pb.VerifyUserRequest.deserializeBinary(new Uint8Array(buffer_arg));
}


var UserServiceService = exports.UserServiceService = {
  getUser: {
    path: '/UserService/GetUser',
    requestStream: false,
    responseStream: false,
    requestType: users_pb.UserLogin,
    responseType: users_pb.UserResponse,
    requestSerialize: serialize_UserLogin,
    requestDeserialize: deserialize_UserLogin,
    responseSerialize: serialize_UserResponse,
    responseDeserialize: deserialize_UserResponse,
  },
  createUser: {
    path: '/UserService/CreateUser',
    requestStream: false,
    responseStream: false,
    requestType: users_pb.NewUserRequest,
    responseType: users_pb.UserResponse,
    requestSerialize: serialize_NewUserRequest,
    requestDeserialize: deserialize_NewUserRequest,
    responseSerialize: serialize_UserResponse,
    responseDeserialize: deserialize_UserResponse,
  },
  verifyUser: {
    path: '/UserService/VerifyUser',
    requestStream: false,
    responseStream: false,
    requestType: users_pb.VerifyUserRequest,
    responseType: users_pb.VerifyResponse,
    requestSerialize: serialize_VerifyUserRequest,
    requestDeserialize: deserialize_VerifyUserRequest,
    responseSerialize: serialize_VerifyResponse,
    responseDeserialize: deserialize_VerifyResponse,
  },
};

exports.UserServiceClient = grpc.makeGenericClientConstructor(UserServiceService);
