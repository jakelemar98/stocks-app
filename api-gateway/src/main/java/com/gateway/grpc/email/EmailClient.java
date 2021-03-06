package com.gateway.grpc.email;

import com.gateway.models.VerifyEmail;
import com.grpc.services.email.CheckRequest;
import com.grpc.services.email.Email;
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

    public EmailReply verifyEmail(VerifyEmail email, String url) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 5001).usePlaintext().build();
        final EmailServiceGrpc.EmailServiceBlockingStub stub = EmailServiceGrpc.newBlockingStub(channel);
    
        response = stub.verifyEmail(VerifyRequest.newBuilder()
            .setEmail(email.getEmail())
            .setId(email.getId())
            .build());
        
        channel.shutdown();
        return response;
    }

    public EmailReply checkVerified(VerifyEmail email, String url, int code) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 5001).usePlaintext().build();
        final EmailServiceGrpc.EmailServiceBlockingStub stub = EmailServiceGrpc.newBlockingStub(channel);
    
        response = stub.checkVerified(CheckRequest.newBuilder()
            .setId(email.getId())
            .setCode(code)
            .build());
        
        channel.shutdown();
        return response;
    }
}