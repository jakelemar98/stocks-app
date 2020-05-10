package main

import (
	pbS "../proto/stocks"
	"flag"
	"google.golang.org/grpc"
	"log"
	"math/rand"
	"net"
)

var (
	port    = flag.String("port", "8000", "port")
	apiBase = "https://www.alphavantage.co/query?function="
	apiKeys = [3]string{"N8ECE7S8XE8QTU03", "31F5E2JCSVEGY11D", "XVK5WJEDTOJQY1QJ"}
)

func randAPIKey() string {
	randNum := rand.Intn(3)
	return apiKeys[randNum]
}

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
