package com.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestHeader;

import com.gateway.models.*;
import com.gateway.utils.ConfigProperties;
import com.gateway.utils.JWTVerify;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    UserClient uc = new UserClient();
    JWTVerify jwtVerify = new JWTVerify();

    @Autowired
    ConfigProperties config;

    @PostMapping("/users/login")
	public ResponseEntity<String> getUser(@RequestBody Login login) {
        String url = config.getConfigValue("users.url");
        UserResponse ur = uc.getUser(login, url);
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
        String url = config.getConfigValue("users.url");
        UserResponse ur = uc.createUser(user, url);
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

    @GetMapping(value="/users/verify")
    public ResponseEntity<String> verify(@RequestHeader("authorization") String token) {
        String[] bearer = token.split(" ");
        Boolean verified = jwtVerify.verifyToken(bearer[1]);
        System.out.println(verified);
        return new ResponseEntity<>(verified.toString(), HttpStatus.OK);
    }
    

}