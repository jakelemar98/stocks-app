package main

import (
	context "context"
	"encoding/json"
	"flag"
	"io/ioutil"
	"log"
	"net"
	"net/http"

	pb "./proto"

	"google.golang.org/grpc"
)

var (
	port    = flag.String("port", "8000", "port")
	apiBase = "https://www.alphavantage.co/query?function="
	apiKey  = "N8ECE7S8XE8QTU03"
)

type GlobalQuote struct {
	Stock map[string]string `json:"Global Quote"`
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

func (s *server) GetStockPrice(c context.Context, req *pb.Request) (*pb.Response, error) {
	log.Println("Incoming Request with Symbol: ", req.StockSymbol)
	res := stockPriceFetch(req.StockSymbol)
	response := &pb.Response{
		StockInfo: res,
	}
	return response, nil
}

func stockPriceFetch(symbol string) string {
	var returnVal string
	url := apiBase + "GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey
	response, err := http.Get(url)
	if err != nil {
		log.Fatalf("server error -> %s\n", err)
	} else {
		defer response.Body.Close()
		data, _ := ioutil.ReadAll(response.Body)
		var gq GlobalQuote
		err = json.Unmarshal(data, &gq)
		if err != nil {
			log.Fatal(err)
		}
		jsonString, _ := json.Marshal(gq.Stock)
		returnVal = string(jsonString)
	}
	return returnVal
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
