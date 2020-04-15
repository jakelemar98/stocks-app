package com.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.util.*;
import com.grpc.services.stocks.Response;
import com.gateway.grpc.stocks.StockClient;
import com.gateway.utils.ConfigProperties;
import com.gateway.models.VerifyEmail;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {

    @Autowired
    ConfigProperties config;

    @PostMapping("/email/verify")
	public String sendVerificationEmail(@RequestBody VerifyEmail email, @RequestHeader("authorization") String token) {
        System.out.println(email);
        return token;
    }

   
}