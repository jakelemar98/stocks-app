package main

import (
	"flag"
	"log"
	"net"

	pb "./proto"
	"google.golang.org/grpc"
)

var (
	port = flag.String("port", "8000", "port")
)

func init() {
	flag.Parse()
}

type server struct {
	name string
}

func StockService() *server {
	return &server{
		name: "Server",
	}
}

func main() {
	log.Println("ZERO Server listening in :", *port)
	lis, err := net.Listen("tcp", ":"+*port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}

	grpcServer := grpc.NewServer()
	stockService := StockService()
	pb.RegisterStockServiceServer(grpcServer, stockService)

	if err := grpcServer.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
