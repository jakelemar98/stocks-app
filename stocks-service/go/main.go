package main

import (
	"flag"
	"log"
	"net"

	pbS "../proto/stocks"
	"google.golang.org/grpc"
)

var (
	port    = flag.String("port", "8000", "port")
	apiBase = "https://www.alphavantage.co/query?function="
	apiKey  = "N8ECE7S8XE8QTU03"
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
	pbS.RegisterStockServiceServer(grpcServer, stockService)

	if err := grpcServer.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
