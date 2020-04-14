package com.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.util.*;
import com.grpc.services.stocks.Response;
import com.gateway.grpc.stocks.StockClient;
import com.gateway.utils.ConfigProperties;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    ConfigProperties config;

    StockClient sc = new StockClient();

    @GetMapping("/stocks/price")
    @Cacheable("getStockPrice")
	public String getStockPrice(@RequestParam(value = "symbol") String symbol) {
        Response messageResponse = sc.getResponse(symbol, config.getConfigValue("stocks.url"),"price", "NA");

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
        Response messageResponse = sc.getResponse(symbol, config.getConfigValue("stocks.url"), "matches", "NA");

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
        Response sr = sc.getResponse(symbol, config.getConfigValue("stocks.url"),"time", time);
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