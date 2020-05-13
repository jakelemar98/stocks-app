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
import org.springframework.web.bind.annotation.PutMapping;
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

        String jsonString = serializeReturn(messageResponse);

        return jsonString;
    }

    @GetMapping("/stocks/matches")
    @Cacheable("getMatches")
	public String getMatches(@RequestParam(value = "symbol") String symbol) {
        Response messageResponse = sc.getResponse(symbol, config.getConfigValue("stocks.url"), "matches", "NA");

        String jsonString = serializeReturn(messageResponse);

        return jsonString;
    }

    @GetMapping("/stocks/timeSeries")
    @Cacheable("getTimeSeries")
    public String getTimeSeries(@RequestParam(value = "symbol") String symbol, @RequestParam(value = "time") String time) {
        Response sr = sc.getResponse(symbol, config.getConfigValue("stocks.url"),"time", time);
        
        String jsonString = serializeReturn(sr);

        return jsonString;
    }

    @GetMapping("/stocks/crypto")
    @Cacheable("getCrpyto")
	public String getCrypto(@RequestParam(value = "symbol") String symbol) {
        Response messageResponse = sc.getResponse(symbol, config.getConfigValue("stocks.url"),"crypto", "NA");

        String jsonString = serializeReturn(messageResponse);

        return jsonString;
    }

    @PostMapping("/stocks/watchers")
    public ResponseEntity<String> addWatcher(@RequestHeader("Authorization") String token, @RequestBody Watcher body) {

        String[] args = tokenExtraction(token, new String[]{"user_id"});

        if (args[0].equals("bad token")){
            new ResponseEntity<>("token is malformed", HttpStatus.UNAUTHORIZED);
        }

        body.setId(args[0]);

        Response messageResponse = sc.postWatcherResponse(body, config.getConfigValue("stocks.url"));

        String jsonString = serializeReturn(messageResponse);

        return new ResponseEntity<>(jsonString, HttpStatus.CREATED);
    }

    @GetMapping("stocks/watchers")
    public ResponseEntity<String> getWatching(@RequestHeader("Authorization") String token) {

        String[] args = tokenExtraction(token, new String[]{"user_id"});

        if (args[0].equals("bad token")){
            new ResponseEntity<>("token is malformed", HttpStatus.UNAUTHORIZED);
        }

        Response messageResponse = sc.getWatcherResponse(args[0], config.getConfigValue("stocks.url"));

        String jsonString = serializeReturn(messageResponse);


        return new ResponseEntity<>(jsonString, HttpStatus.ACCEPTED);
    }

    @PutMapping("stocks/watchers")
    public ResponseEntity<String> updateWatching(@RequestHeader("Authorization") String token ,@RequestBody String symbol) {
        
        String[] args = tokenExtraction(token, new String[]{"user_id"});

        if (args[0].equals("bad token")){
            new ResponseEntity<>("token is malformed", HttpStatus.UNAUTHORIZED);
        }

        Response res = sc.putWatcherResponse(args[0], symbol, config.getConfigValue("stocks.url"));

        String jsonString = serializeReturn(res);

        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }

    private String[] tokenExtraction(String token, String[] claims) {
        
        String[] authHeader = token.split("\\s");
        
        VerifiedAndClaims vc = tokenVerifier.verifyTokenAndReturnClaims(authHeader[1], claims);

        if (!vc.getVerified()) {
            return new String[]{"bad token"};
        }
        
        String[] args = vc.getClaims();
        return args;
    }

    private String serializeReturn(Response req) {
        String res = "";
        try {
            res = JsonFormat.printer().print(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
}