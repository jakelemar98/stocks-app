package com.gateway.utils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import org.springframework.util.ResourceUtils;

public class JWTVerify {
    FileInputStream fis;
    CertificateFactory f;
    Certificate certificate;
    PublicKey pk;
    DecodedJWT jwt;

    public VerifiedAndClaims verifyTokenAndReturnClaims(String token, String[] claims) {

        final PublicKey pubkey = getPublicKey();
        Algorithm rsaAlgorithm = Algorithm.RSA256((RSAPublicKey) pubkey);
        
        String[] returnClaims = new String[claims.length];

        try {
            JWTVerifier verifier = JWT.require(rsaAlgorithm).build();
            jwt = verifier.verify(token);

            for (int i = 0; i < claims.length; i++) {
                String claimVal = jwt.getClaim(claims[i]).asString();
                returnClaims[i] = claimVal;
                System.out.println(returnClaims[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new VerifiedAndClaims(false, new String[]{""});
        }
        return new VerifiedAndClaims(true, returnClaims);
    }

    public PublicKey getPublicKey() {
        try {
            // File pubFile = ResourceUtils.getFile("classpath:publickey.crt");
            // fis = new FileInputStream(pubFile);
            InputStream stream = getClass().getResourceAsStream("/publickey.crt");
            DataInputStream dis = new DataInputStream(stream);
            byte[] keyBytes = new byte[(int) stream.available()];
            dis.readFully(keyBytes);
            dis.close();

            String temp = new String(keyBytes);
            String publicKeyPEM = temp.replace("-----BEGIN PUBLIC KEY-----\n", "");
            publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");

            byte[] decoded = Base64.getMimeDecoder().decode(publicKeyPEM.getBytes(StandardCharsets.UTF_8));

            X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            pk = kf.generatePublic(spec);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pk;
    }
}