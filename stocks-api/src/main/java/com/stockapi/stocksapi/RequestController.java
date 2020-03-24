package com.stockapi.stocksapi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class RequestController {

    StockWebClient swc = new StockWebClient();

	@GetMapping("/getPriceDaily")
	public String getPriceDaily(@RequestParam(value = "name") String name) {
        return swc.getPriceDaily(name);
    }
    
    @GetMapping("/getMatches")
	public String getMatches(@RequestParam(value = "name") String name) {
        return swc.getMatches(name);
    }

}