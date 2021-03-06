package com.gateway.grpc.stocks;

import org.springframework.beans.factory.annotation.Autowired;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.grpc.services.stocks.StockServiceGrpc;
import com.grpc.services.stocks.TimeRequest;
import com.grpc.services.stocks.WatchRequest;
import com.gateway.models.Watcher;
import com.grpc.services.stocks.Request;
import com.grpc.services.stocks.Response;

public class StockClient {

    @Autowired
    ManagedChannel managedChannel;


    private Response response;

    public Response getResponse(final String symbol, final String url, final String option, final String time) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 8000).usePlaintext().build();

        final StockServiceGrpc.StockServiceBlockingStub stub = StockServiceGrpc.newBlockingStub(channel);

        if (option.equals("price")) {
            response = stub.getStockPrice(Request.newBuilder()
                .setStockSymbol(symbol)
                .build());
        } else if (option.equals("matches")) {
            response = stub.getStockOptions(Request.newBuilder()
                .setStockSymbol(symbol)
                .build());
        } else if (option.equals("time")) {
            response = stub.getTimeSeries(TimeRequest.newBuilder()
                .setSymbol(symbol)
                .setTime(time)
                .build());
        } else if (option.equals("crypto")) {
            System.out.print("HERE");
            response = stub.getCryptoPrice(Request.newBuilder()
                .setStockSymbol(symbol)
                .build());
        }
         

        channel.shutdown();
        return response;
    }

    public Response postWatcherResponse(final Watcher req, final String url) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 8000).usePlaintext().build();

        final StockServiceGrpc.StockServiceBlockingStub stub = StockServiceGrpc.newBlockingStub(channel);

        response = stub.addStockWatch(WatchRequest.newBuilder()
        .setSymbol(req.getSymbol())
        .setId(req.getId())
        .build());

        channel.shutdown();
        return response;
    }

    public Response getWatcherResponse(final String id, final String url) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 8000).usePlaintext().build();

        final StockServiceGrpc.StockServiceBlockingStub stub = StockServiceGrpc.newBlockingStub(channel);

        response = stub.getWatching(WatchRequest.newBuilder()
        .setId(id)
        .setSymbol("")
        .build());

        channel.shutdown();
        return response;
    }

    public Response putWatcherResponse(final String id, final String symbol, final String url) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 8000).usePlaintext().build();

        final StockServiceGrpc.StockServiceBlockingStub stub = StockServiceGrpc.newBlockingStub(channel);

        response = stub.updateWatching(WatchRequest.newBuilder()
        .setId(id)
        .setSymbol(symbol)
        .build());

        channel.shutdown();
        return response;
    }


}
