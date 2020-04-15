package main

import (
	"context"

	pb "../proto/stocks"
)

func (s *server) GetStockPrice(c context.Context, req *pb.Request) (*pb.Response, error) {
	res := stockPriceFetch(req.StockSymbol)
	response := &pb.Response{
		Response: res,
		Status:   200,
	}
	return response, nil
}

func (s *server) GetStockOptions(c context.Context, req *pb.Request) (*pb.Response, error) {
	res := stockOptionsFetch(req.StockSymbol)
	response := &pb.Response{
		Response: res,
		Status:   200,
	}
	return response, nil
}

func (s *server) GetTimeSeries(c context.Context, req *pb.TimeRequest) (*pb.Response, error) {
	res := timeSeriesFetch(req.Symbol, req.Time)
	response := &pb.Response{
		Response: res,
		Status:   200,
	}
	return response, nil
}

func (s *server) GetCryptoPrice(c context.Context, req *pb.Request) (*pb.Response, error) {
	res := cryptoPriceFetch(req.StockSymbol)
	response := &pb.Response{
		Response: res,
		Status:   200,
	}
	return response, nil
}
