package com.stocks.stocks.grpc;

import com.google.protobuf.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.grpc.services.Response;


@RestController
public class StockController {

    StockClient sc = new StockClient();

	@GetMapping("/stocks/price")
	public ResponseEntity<String> sendResponse(@RequestParam(value = "name") String name) {
        Response messageResponse = sc.getResponse(name);

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(messageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }
    
    @GetMapping("/getMatches")
	public String getMatches(@RequestParam(value = "name") String name) {
        return "hey";
    }

}