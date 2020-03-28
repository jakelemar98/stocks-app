package com.stocks.stocks.grpc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.grpc.services.MessageServiceGrpc;
import com.grpc.services.Request;
import com.grpc.services.Response;

public class MessageClient {

    @Autowired
    ManagedChannel managedChannel;

    private static final Logger logger = Logger.getLogger(MessageClient.class.getName());


    public Response getMessage(String name){
        System.out.println("YOOOOOOOO");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8001)
        .usePlaintext()
        .build();

        MessageServiceGrpc.MessageServiceBlockingStub stub = MessageServiceGrpc.newBlockingStub(channel);

        Response response = stub.getStockInfo(Request.newBuilder().setName(name).build());

        channel.shutdown();
        return response;
    }
}