package com.gateway.controllers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.util.*;
import com.grpc.services.users.UserResponse;
import com.gateway.grpc.users.UserClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.gateway.models.NewUser;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    UserClient uc = new UserClient();

    @GetMapping("/users")
    @Cacheable("getUsers")
	public String getUsers(@RequestParam(value = "id") String id) {
        UserResponse messageResponse = uc.getUser(id);

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(messageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    @PostMapping(value="/users")
    public String createUser(@RequestBody NewUser user) {
        UserResponse messageResponse = uc.createUser(user);
        
        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(messageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return jsonString;
    }
    

}