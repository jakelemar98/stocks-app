package com.gateway.grpc.email;

import com.gateway.models.VerifyEmail;
import com.grpc.services.email.EmailReply;
import com.grpc.services.email.EmailServiceGrpc;
import com.grpc.services.email.VerifyRequest;

import org.springframework.beans.factory.annotation.Autowired;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class EmailClient {
    @Autowired
    ManagedChannel managedChannel;

    private EmailReply response;

    public EmailReply getUser(VerifyEmail email) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5001).usePlaintext().build();
        final EmailServiceGrpc.EmailServiceBlockingStub stub = EmailServiceGrpc.newBlockingStub(channel);
    
        response = stub.verifyEmail(VerifyRequest.newBuilder()
            .setEmail(email.getEmail())
            .setId(email.getId())
            .build());
        
        channel.shutdown();
        return response;
    }
}