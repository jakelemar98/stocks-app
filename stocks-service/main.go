package main

import (
	context "context"
	"flag"
	fmt "fmt"
	"log"
	"net"

	pb "./proto"

	"google.golang.org/grpc"
)

var (
	port = flag.String("port", "8001", "port")
)

func init() {
	flag.Parse()
}

type server struct {
	name string
}

func MessageService() *server {
	return &server{
		name: "Server",
	}
}

func (s *server) GetStockInfo(c context.Context, req *pb.Request) (*pb.Response, error) {
	log.Println("Incoming Request with name: ", req.Name)
	response := &pb.Response{
		Message: fmt.Sprintf("Hello %s! Welcome back!", req.Name),
	}
	return response, nil
}

func main() {
	log.Println("ZERO Server listening in :", *port)
	lis, err := net.Listen("tcp", ":"+*port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}

	grpcServer := grpc.NewServer()
	messageService := MessageService()
	pb.RegisterMessageServiceServer(grpcServer, messageService)

	if err := grpcServer.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
