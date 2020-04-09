package com.gateway.grpc.users;

import org.springframework.beans.factory.annotation.Autowired;
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

    public UserResponse getUser(Login login) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("users-service", 8001).usePlaintext().build();

        final UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);

        response = stub.getUser(UserLogin.newBuilder()
                .setEmail(login.getEmail())
                .setPassword(login.getPassword())
                .build()
            );

        channel.shutdown();
        return response;
    }

    public UserResponse createUser(NewUser newUser) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("users-service", 8001).usePlaintext().build();
        String firstname = newUser.getFirstname();
        System.out.println(firstname);
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