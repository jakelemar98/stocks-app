package com.gateway.grpc.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.grpc.services.users.UserServiceGrpc;
import com.grpc.services.users.UserRequest;
import com.grpc.services.users.UserResponse;

public class UserClient {

    @Autowired
    ManagedChannel managedChannel;

    @Value("${users.endpoint}")
    private String usersEndpoint;

    @Value("${users.endpoint}")
    private Integer usersPort;

    private UserResponse response;

    public UserResponse getResponse(final String symbol, final String option) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(usersEndpoint, usersPort).usePlaintext().build();

        final UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);

        response = stub.getUser(UserRequest.newBuilder().setMessage(symbol).build());

        channel.shutdown();
        return response;
    }
}