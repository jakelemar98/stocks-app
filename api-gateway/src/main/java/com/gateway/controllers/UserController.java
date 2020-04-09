package com.gateway.controllers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.util.*;
import com.grpc.services.users.UserResponse;
import com.gateway.grpc.users.UserClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.gateway.models.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    UserClient uc = new UserClient();

    @PostMapping("/users/login")
	public ResponseEntity<String> getUser(@RequestBody Login login) {
        UserResponse ur = uc.getUser(login);
        HttpStatus status;

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(ur);
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch(ur.getStatus()) {
            case 200:
                status = HttpStatus.OK;
                break;
            case 404:
                status = HttpStatus.NOT_FOUND; 
                break;
            case 401:
                status = HttpStatus.UNAUTHORIZED;
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
          }

        return new ResponseEntity<>(jsonString, status);
    }

    @PostMapping(value="/users/create")
    public ResponseEntity<String> createUser(@RequestBody NewUser user) {
        UserResponse ur = uc.createUser(user);
        HttpStatus status;

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(ur);
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch(ur.getStatus()) {
            case 201:
                status = HttpStatus.CREATED;
                break;
            case 400:
                status = HttpStatus.BAD_REQUEST; 
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
          }

        return new ResponseEntity<>(jsonString, status);
    }
    

}