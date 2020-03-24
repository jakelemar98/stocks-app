package com.stockapi.stocksapi;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import reactor.core.publisher.Mono;

public class StockWebClient {
    private WebClient client = WebClient.create("https://api.worldtradingdata.com/api/v1/");
    
    public String getPriceDaily(String name) {
        final String uri = String.format("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=N8ECE7S8XE8QTU03", name);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    public String getMatches(String name) {
        final String uri = String.format("https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=%s&apikey=N8ECE7S8XE8QTU03", name);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
}