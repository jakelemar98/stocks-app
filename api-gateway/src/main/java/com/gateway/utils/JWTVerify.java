package com.gateway.utils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import org.springframework.util.ResourceUtils;

public class JWTVerify {
    FileInputStream fis;
    CertificateFactory f;
    Certificate certificate;
    PublicKey pk;
    DecodedJWT jwt;

    public Boolean verifyToken(String token) {
        final PublicKey pubkey = getPublicKey();
        Algorithm rsaAlgorithm = Algorithm.RSA256((RSAPublicKey) pubkey);
        try {
            JWTVerifier verifier = JWT.require(rsaAlgorithm)
                .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public PublicKey getPublicKey() {
        try {
            File pubFile = ResourceUtils.getFile("classpath:publickey.crt");
            fis = new FileInputStream(pubFile);
            DataInputStream dis = new DataInputStream(fis);
            byte[] keyBytes = new byte[(int) pubFile.length()];
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