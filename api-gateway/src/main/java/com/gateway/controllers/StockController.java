package com.gateway.controllers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.util.*;
import com.grpc.services.Response;
import com.gateway.grpc.stocks.StockClient;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    StockClient sc = new StockClient();

    @GetMapping("/stocks/price")
    @Cacheable("getStockPrice")
	public String getStockPrice(@RequestParam(value = "symbol") String symbol) {
        Response messageResponse = sc.getResponse(symbol, "price");

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
        Response messageResponse = sc.getResponse(symbol, "matches");

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(messageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}