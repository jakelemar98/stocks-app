package main

import (
	"context"
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"

	pb "../proto/stocks"
)

var (
	apiBase = "https://www.alphavantage.co/query?function="
	apiKey  = "N8ECE7S8XE8QTU03"
)

type GlobalQuote struct {
	Stock map[string]string `json:"Global Quote"`
}

type BestMatches struct {
	Matches []map[string]string `json:"BestMatches"`
}

func (s *server) GetStockPrice(c context.Context, req *pb.Request) (*pb.Response, error) {
	res := stockPriceFetch(req.StockSymbol)
	response := &pb.Response{
		StockInfo: res,
	}
	return response, nil
}

func stockPriceFetch(symbol string) string {
	log.Println("stockPrice request.....")
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

		valueMap := map[string]int{"01. symbol": 0, "02. open": 1,
			"03. high": 2, "04. low": 3, "05. price": 4, "06. volume": 5,
			"07. latest trading day": 6, "08. previous close": 7,
			"09. change": 8, "10. change percent": 9}

		m := make(map[int]string)
		for k, v := range gq.Stock {
			m[valueMap[k]] = v
		}

		jsonString, _ := json.Marshal(m)
		returnVal = string(jsonString)
	}
	return returnVal
}

func (s *server) GetStockOptions(c context.Context, req *pb.Request) (*pb.Response, error) {
	res := stockOptionsFetch(req.StockSymbol)
	response := &pb.Response{
		StockInfo: res,
	}
	return response, nil
}

func stockOptionsFetch(symbol string) string {
	log.Println("stockOptions request.....")
	var returnVal string
	url := apiBase + "SYMBOL_SEARCH&keywords=" + symbol + "&apikey=" + apiKey
	response, err := http.Get(url)
	if err != nil {
		log.Fatalf("server error -> %s\n", err)
	} else {
		defer response.Body.Close()
		data, _ := ioutil.ReadAll(response.Body)
		var bm BestMatches
		err = json.Unmarshal(data, &bm)
		if err != nil {
			log.Fatal(err)
		}
		om := make(map[int]map[string]string)
		var i int = 0
		for k := range bm.Matches {
			m := make(map[string]string)
			for k2, v2 := range bm.Matches[k] {
				if k2 == "1. symbol" {
					m["symbol"] = v2
				}
				if k2 == "2. name" {
					m["name"] = v2
				}
			}
			om[i] = m
			i++
		}
		jsonString, _ := json.Marshal(om)
		returnVal = string(jsonString)
	}
	return returnVal
}
