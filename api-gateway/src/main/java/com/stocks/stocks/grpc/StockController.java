package com.stocks.stocks.grpc;

import com.google.protobuf.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.grpc.services.Response;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    StockClient sc = new StockClient();

	@GetMapping("/stocks/price")
	public ResponseEntity<String> getStockPrice(@RequestParam(value = "symbol") String symbol) {
        Response messageResponse = sc.getResponse(symbol, "price");

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(messageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }

    @GetMapping("/stocks/matches")
	public ResponseEntity<String> getMatches(@RequestParam(value = "symbol") String symbol) {
        Response messageResponse = sc.getResponse(symbol, "matches");

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(messageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }
}