package com.gateway.grpc.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.grpc.services.users.UserServiceGrpc;
import com.grpc.services.users.UserResponse;
import com.grpc.services.users.NewUserRequest;
import com.grpc.services.users.UserLogin;
import com.gateway.models.*;

public class UserClient {

    @Autowired
    ManagedChannel managedChannel;

    private UserResponse response;

    public UserResponse getUser(Login login, String url) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 8001).usePlaintext().build();
        final UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
    
        response = stub.getUser(UserLogin.newBuilder()
                .setEmail(login.getEmail())
                .setPassword(login.getPassword())
                .build()
            );
        channel.shutdown();
        return response;
    }

    public UserResponse createUser(NewUser newUser, String url) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 8001).usePlaintext().build();
        final UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
    
        response = stub.createUser(NewUserRequest.newBuilder()
                        .setFirstname(newUser.getFirstname())
                        .setLastname(newUser.getLastname())
                        .setEmail(newUser.getEmail())
                        .setPassword(newUser.getPassword())
                        .build()
                    );
        channel.shutdown();
        return response;
    }
}