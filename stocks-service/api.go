package main

import (
	"context"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"

	pb "./proto"
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

type Option struct {
	symbol string
	name   string
}

func (s *server) GetStockPrice(c context.Context, req *pb.Request) (*pb.Response, error) {
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
		fmt.Println(&gq)
		jsonString, _ := json.Marshal(gq.Stock)
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
