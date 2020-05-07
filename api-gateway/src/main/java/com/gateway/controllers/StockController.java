package com.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.gateway.utils.ConfigProperties;
import com.gateway.utils.JWTVerify;
import com.gateway.utils.VerifiedAndClaims;
import com.gateway.models.Watcher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    ConfigProperties config;

    StockClient sc = new StockClient();

    JWTVerify tokenVerifier = new JWTVerify();

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
        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @GetMapping("/stocks/crypto")
    @Cacheable("getCrpyto")
	public String getCrypto(@RequestParam(value = "symbol") String symbol) {
        Response messageResponse = sc.getResponse(symbol, config.getConfigValue("stocks.url"),"crypto", "NA");

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(messageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    @PostMapping("/stocks/watchers")
    public ResponseEntity<String> addWatcher(@RequestHeader("Authorization") String token, @RequestBody Watcher body) {

        String[] authHeader = token.split("\\s");
        String[] claims = new String[]{"user_id"};
        VerifiedAndClaims vc = tokenVerifier.verifyTokenAndReturnClaims(authHeader[1], claims);

        if (!vc.getVerified()) {
            return new ResponseEntity<>("token is malformed", HttpStatus.UNAUTHORIZED);
        }

        String[] args = vc.getClaims();

        body.setId(args[0]);

        Response messageResponse = sc.watcherResponse(body, config.getConfigValue("stocks.url"));

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(messageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(jsonString, HttpStatus.ACCEPTED);
    }
    
}