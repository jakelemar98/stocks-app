package com.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.util.*;
import com.grpc.services.email.EmailReply;
import com.gateway.grpc.email.EmailClient;
import com.gateway.utils.ConfigProperties;
import com.gateway.models.VerifyEmail;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {

    EmailClient ec = new EmailClient();

    @Autowired
    ConfigProperties config;

    @PostMapping("/email/verify")
	public ResponseEntity<String> sendVerificationEmail(@RequestBody VerifyEmail email, @RequestHeader("authorization") String token) {

        EmailReply er = ec.verifyEmail(email);

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(er);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }

   
}