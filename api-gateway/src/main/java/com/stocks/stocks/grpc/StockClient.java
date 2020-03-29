package com.stocks.stocks.grpc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.grpc.services.StockServiceGrpc;
import com.grpc.services.Request;
import com.grpc.services.Response;

public class StockClient {

    @Autowired
    ManagedChannel managedChannel;

    private static final Logger logger = Logger.getLogger(StockClient.class.getName());

    private Response response;


    public Response getResponse(final String symbol, final String option) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000).usePlaintext().build();

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