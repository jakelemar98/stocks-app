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


    public Response getResponse(String name){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000)
        .usePlaintext()
        .build();

        StockServiceGrpc.StockServiceBlockingStub stub = StockServiceGrpc.newBlockingStub(channel);

        Response response = stub.getStockPrice(Request.newBuilder().setStockSymbol(name).build());

        channel.shutdown();
        return response;
    }
}