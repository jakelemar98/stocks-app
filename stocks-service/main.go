package main

import (
	context "context"
	"encoding/json"
	"flag"
	"fmt"
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

type TimeSeriesDaily struct {
	Data interface{} `json:"Time Series (Daily)"`
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
	log.Println("fetching......")
	var returnVal []byte
	url := apiBase + "TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + apiKey
	response, err := http.Get(url)
	if err != nil {
		log.Fatalf("server error -> %s\n", err)
	} else {
		data, _ := ioutil.ReadAll(response.Body)
		returnVal = data
	}

	var tsdi TimeSeriesDaily
	err = json.Unmarshal(returnVal, &tsdi)
	if err != nil {
		log.Fatal(err)
	}
	tsd, _ := tsdi.Data.(map[string]interface{})
	fmt.Println(tsd["2020-03-27"])
	res := string(returnVal)
	return res
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
