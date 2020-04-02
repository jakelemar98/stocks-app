// Code generated by protoc-gen-go. DO NOT EDIT.
// source: email.proto

/*
Package email is a generated protocol buffer package.

It is generated from these files:
	email.proto

It has these top-level messages:
	EmailRequest
	EmailReply
	Email
*/
package email

import proto "github.com/golang/protobuf/proto"
import fmt "fmt"
import math "math"

import (
	context "golang.org/x/net/context"
	grpc "google.golang.org/grpc"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
// A compilation error at this line likely means your copy of the
// proto package needs to be updated.
const _ = proto.ProtoPackageIsVersion2 // please upgrade the proto package

type EmailRequest struct {
	Email *Email `protobuf:"bytes,1,opt,name=email" json:"email,omitempty"`
}

func (m *EmailRequest) Reset()                    { *m = EmailRequest{} }
func (m *EmailRequest) String() string            { return proto.CompactTextString(m) }
func (*EmailRequest) ProtoMessage()               {}
func (*EmailRequest) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{0} }

func (m *EmailRequest) GetEmail() *Email {
	if m != nil {
		return m.Email
	}
	return nil
}

type EmailReply struct {
	Reply string `protobuf:"bytes,1,opt,name=reply" json:"reply,omitempty"`
}

func (m *EmailReply) Reset()                    { *m = EmailReply{} }
func (m *EmailReply) String() string            { return proto.CompactTextString(m) }
func (*EmailReply) ProtoMessage()               {}
func (*EmailReply) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{1} }

func (m *EmailReply) GetReply() string {
	if m != nil {
		return m.Reply
	}
	return ""
}

type Email struct {
	ToAddress []string `protobuf:"bytes,1,rep,name=toAddress" json:"toAddress,omitempty"`
	Subject   string   `protobuf:"bytes,2,opt,name=subject" json:"subject,omitempty"`
	Html      string   `protobuf:"bytes,3,opt,name=html" json:"html,omitempty"`
}

func (m *Email) Reset()                    { *m = Email{} }
func (m *Email) String() string            { return proto.CompactTextString(m) }
func (*Email) ProtoMessage()               {}
func (*Email) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{2} }

func (m *Email) GetToAddress() []string {
	if m != nil {
		return m.ToAddress
	}
	return nil
}

func (m *Email) GetSubject() string {
	if m != nil {
		return m.Subject
	}
	return ""
}

func (m *Email) GetHtml() string {
	if m != nil {
		return m.Html
	}
	return ""
}

func init() {
	proto.RegisterType((*EmailRequest)(nil), "EmailRequest")
	proto.RegisterType((*EmailReply)(nil), "EmailReply")
	proto.RegisterType((*Email)(nil), "Email")
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion4

// Client API for EmailService service

type EmailServiceClient interface {
	SendMail(ctx context.Context, in *EmailRequest, opts ...grpc.CallOption) (*EmailReply, error)
}

type emailServiceClient struct {
	cc *grpc.ClientConn
}

func NewEmailServiceClient(cc *grpc.ClientConn) EmailServiceClient {
	return &emailServiceClient{cc}
}

func (c *emailServiceClient) SendMail(ctx context.Context, in *EmailRequest, opts ...grpc.CallOption) (*EmailReply, error) {
	out := new(EmailReply)
	err := grpc.Invoke(ctx, "/EmailService/SendMail", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// Server API for EmailService service

type EmailServiceServer interface {
	SendMail(context.Context, *EmailRequest) (*EmailReply, error)
}

func RegisterEmailServiceServer(s *grpc.Server, srv EmailServiceServer) {
	s.RegisterService(&_EmailService_serviceDesc, srv)
}

func _EmailService_SendMail_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(EmailRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(EmailServiceServer).SendMail(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/EmailService/SendMail",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(EmailServiceServer).SendMail(ctx, req.(*EmailRequest))
	}
	return interceptor(ctx, in, info, handler)
}

var _EmailService_serviceDesc = grpc.ServiceDesc{
	ServiceName: "EmailService",
	HandlerType: (*EmailServiceServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "SendMail",
			Handler:    _EmailService_SendMail_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "email.proto",
}

func init() { proto.RegisterFile("email.proto", fileDescriptor0) }

var fileDescriptor0 = []byte{
	// 188 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0xe2, 0xe2, 0x4e, 0xcd, 0x4d, 0xcc,
	0xcc, 0xd1, 0x2b, 0x28, 0xca, 0x2f, 0xc9, 0x57, 0xd2, 0xe1, 0xe2, 0x71, 0x05, 0x71, 0x83, 0x52,
	0x0b, 0x4b, 0x53, 0x8b, 0x4b, 0x84, 0x64, 0xb8, 0x58, 0xc1, 0xd2, 0x12, 0x8c, 0x0a, 0x8c, 0x1a,
	0xdc, 0x46, 0x6c, 0x7a, 0x10, 0x59, 0x88, 0xa0, 0x92, 0x12, 0x17, 0x17, 0x54, 0x75, 0x41, 0x4e,
	0xa5, 0x90, 0x08, 0x17, 0x6b, 0x11, 0x88, 0x01, 0x56, 0xcb, 0x19, 0x04, 0xe1, 0x28, 0x05, 0x73,
	0xb1, 0x82, 0xd5, 0x08, 0xc9, 0x70, 0x71, 0x96, 0xe4, 0x3b, 0xa6, 0xa4, 0x14, 0xa5, 0x16, 0x17,
	0x4b, 0x30, 0x2a, 0x30, 0x6b, 0x70, 0x06, 0x21, 0x04, 0x84, 0x24, 0xb8, 0xd8, 0x8b, 0x4b, 0x93,
	0xb2, 0x52, 0x93, 0x4b, 0x24, 0x98, 0xc0, 0xda, 0x61, 0x5c, 0x21, 0x21, 0x2e, 0x96, 0x8c, 0x92,
	0xdc, 0x1c, 0x09, 0x66, 0xb0, 0x30, 0x98, 0x6d, 0x64, 0x01, 0x75, 0x66, 0x70, 0x6a, 0x51, 0x59,
	0x66, 0x72, 0xaa, 0x90, 0x06, 0x17, 0x47, 0x70, 0x6a, 0x5e, 0x8a, 0x2f, 0xc8, 0x1e, 0x5e, 0x3d,
	0x64, 0x1f, 0x48, 0x71, 0xeb, 0x21, 0x9c, 0xa8, 0xc4, 0x90, 0xc4, 0x06, 0xf6, 0xa7, 0x31, 0x20,
	0x00, 0x00, 0xff, 0xff, 0xd2, 0x5d, 0x30, 0xf0, 0xf6, 0x00, 0x00, 0x00,
}
