package com.gateway.grpc.stocks;

import org.springframework.beans.factory.annotation.Autowired;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.grpc.services.StockServiceGrpc;
import com.grpc.services.Request;
import com.grpc.services.Response;

public class StockClient {

    @Autowired
    ManagedChannel managedChannel;

    private Response response;

    public Response getResponse(final String symbol, final String option) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("stocks-service", 8000).usePlaintext().build();

        final StockServiceGrpc.StockServiceBlockingStub stub = StockServiceGrpc.newBlockingStub(channel);

        if (option.equals("price")) {
            response = stub.getStockPrice(Request.newBuilder().setStockSymbol(symbol).build());
        } else if (option.equals("matches")) {
            response = stub.getStockOptions(Request.newBuilder().setStockSymbol(symbol).build());
        }

        channel.shutdown();
        return response;
    }
}