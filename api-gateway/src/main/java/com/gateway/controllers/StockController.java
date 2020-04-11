package com.gateway.controllers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.util.*;
import com.grpc.services.stocks.Response;
import com.gateway.grpc.stocks.StockClient;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    StockClient sc = new StockClient();

    @GetMapping("/stocks/price")
    @Cacheable("getStockPrice")
	public String getStockPrice(@RequestParam(value = "symbol") String symbol) {
        Response messageResponse = sc.getResponse(symbol, "price", "NA");

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(messageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    @GetMapping("/stocks/matches")
    @Cacheable("getMatches")
	public String getMatches(@RequestParam(value = "symbol") String symbol) {
        Response messageResponse = sc.getResponse(symbol, "matches", "NA");

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(messageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    @GetMapping("/stocks/timeSeries")
    @Cacheable("getTimeSeries")
    public String getTimeSeries(@RequestParam(value = "symbol") String symbol, @RequestParam(value = "time") String time) {
        Response sr = sc.getResponse(symbol, "time", time);
        System.out.println(sr);
        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}