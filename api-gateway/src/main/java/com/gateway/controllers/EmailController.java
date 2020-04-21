package com.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.util.*; 
import com.grpc.services.email.EmailReply;
import com.gateway.grpc.email.EmailClient;
import com.gateway.utils.ConfigProperties;
import com.gateway.utils.JWTVerify;
import com.gateway.utils.VerifiedAndClaims;
import com.gateway.models.VerifyEmail;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {

    EmailClient ec = new EmailClient();

    JWTVerify tokenVerifier = new JWTVerify();

    @Autowired
    ConfigProperties config;

    @GetMapping("/email/verify")
	public ResponseEntity<String> sendVerificationEmail(@RequestHeader("authorization") String token) {

        String[] authHeader = token.split("\\s");
        String[] claims = new String[]{"email", "user_id"};
        VerifiedAndClaims vc = tokenVerifier.verifyTokenAndReturnClaims(authHeader[1], claims);
        
        if (!vc.getVerified()) {
            return new ResponseEntity<>("token is malformed", HttpStatus.UNAUTHORIZED);
        }

        VerifyEmail email = new VerifyEmail();
        String[] args = vc.getClaims();
        email.setEmail(args[0]);
        email.setId(args[1]);


        EmailReply er = ec.verifyEmail(email, config.getConfigValue("email.url"));

        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(er);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }

    @GetMapping("/email/code")
    public ResponseEntity<String> checkVerificaionCode(@RequestHeader("authorization") String token, @RequestParam(value = "value") int code) {
        String[] authHeader = token.split("\\s");
        String[] claims = new String[]{"user_id"};
        VerifiedAndClaims vc = tokenVerifier.verifyTokenAndReturnClaims(authHeader[1], claims);

        if (!vc.getVerified()) {
            return new ResponseEntity<>("token is malformed", HttpStatus.UNAUTHORIZED);
        }

        VerifyEmail email = new VerifyEmail();
        String[] args = vc.getClaims();
        email.setId(args[0]);

        EmailReply er = ec.checkVerified(email, config.getConfigValue("email.url"), code);
        
        String jsonString = "";
        try {
            jsonString = JsonFormat.printer().print(er);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }
}