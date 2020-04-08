# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: users.proto

from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='users.proto',
  package='',
  syntax='proto3',
  serialized_options=b'\n\027com.grpc.services.usersP\001',
  serialized_pb=b'\n\x0busers.proto\"\x1f\n\x0cUserResponse\x12\x0f\n\x07message\x18\x01 \x01(\t\"V\n\x0eNewUserRequest\x12\x11\n\tfirstname\x18\x01 \x01(\t\x12\x10\n\x08lastname\x18\x02 \x01(\t\x12\r\n\x05\x65mail\x18\x03 \x01(\t\x12\x10\n\x08password\x18\x04 \x01(\t\",\n\tUserLogin\x12\r\n\x05\x65mail\x18\x01 \x01(\t\x12\x10\n\x08password\x18\x02 \x01(\t2a\n\x0bUserService\x12$\n\x07GetUser\x12\n.UserLogin\x1a\r.UserResponse\x12,\n\nCreateUser\x12\x0f.NewUserRequest\x1a\r.UserResponseB\x1b\n\x17\x63om.grpc.services.usersP\x01\x62\x06proto3'
)




_USERRESPONSE = _descriptor.Descriptor(
  name='UserResponse',
  full_name='UserResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='message', full_name='UserResponse.message', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=15,
  serialized_end=46,
)


_NEWUSERREQUEST = _descriptor.Descriptor(
  name='NewUserRequest',
  full_name='NewUserRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='firstname', full_name='NewUserRequest.firstname', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='lastname', full_name='NewUserRequest.lastname', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='email', full_name='NewUserRequest.email', index=2,
      number=3, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='password', full_name='NewUserRequest.password', index=3,
      number=4, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=48,
  serialized_end=134,
)


_USERLOGIN = _descriptor.Descriptor(
  name='UserLogin',
  full_name='UserLogin',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='email', full_name='UserLogin.email', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='password', full_name='UserLogin.password', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=136,
  serialized_end=180,
)

DESCRIPTOR.message_types_by_name['UserResponse'] = _USERRESPONSE
DESCRIPTOR.message_types_by_name['NewUserRequest'] = _NEWUSERREQUEST
DESCRIPTOR.message_types_by_name['UserLogin'] = _USERLOGIN
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

UserResponse = _reflection.GeneratedProtocolMessageType('UserResponse', (_message.Message,), {
  'DESCRIPTOR' : _USERRESPONSE,
  '__module__' : 'users_pb2'
  # @@protoc_insertion_point(class_scope:UserResponse)
  })
_sym_db.RegisterMessage(UserResponse)

NewUserRequest = _reflection.GeneratedProtocolMessageType('NewUserRequest', (_message.Message,), {
  'DESCRIPTOR' : _NEWUSERREQUEST,
  '__module__' : 'users_pb2'
  # @@protoc_insertion_point(class_scope:NewUserRequest)
  })
_sym_db.RegisterMessage(NewUserRequest)

UserLogin = _reflection.GeneratedProtocolMessageType('UserLogin', (_message.Message,), {
  'DESCRIPTOR' : _USERLOGIN,
  '__module__' : 'users_pb2'
  # @@protoc_insertion_point(class_scope:UserLogin)
  })
_sym_db.RegisterMessage(UserLogin)


DESCRIPTOR._options = None

_USERSERVICE = _descriptor.ServiceDescriptor(
  name='UserService',
  full_name='UserService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=182,
  serialized_end=279,
  methods=[
  _descriptor.MethodDescriptor(
    name='GetUser',
    full_name='UserService.GetUser',
    index=0,
    containing_service=None,
    input_type=_USERLOGIN,
    output_type=_USERRESPONSE,
    serialized_options=None,
  ),
  _descriptor.MethodDescriptor(
    name='CreateUser',
    full_name='UserService.CreateUser',
    index=1,
    containing_service=None,
    input_type=_NEWUSERREQUEST,
    output_type=_USERRESPONSE,
    serialized_options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_USERSERVICE)

DESCRIPTOR.services_by_name['UserService'] = _USERSERVICE

# @@protoc_insertion_point(module_scope)
