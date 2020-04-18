package com.gateway.utils;


public class VerifiedAndClaims {
    boolean verified;
    String[] claims;

    public VerifiedAndClaims(Boolean verified, String[] claims){
        this.verified = verified;
        this.claims = claims;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setClaims(String[] claims) {
        for (int i = 0; i < claims.length; i++) {
            this.claims[i] = claims[i];
        }
    }

    public Boolean getVerified() {
        return this.verified;
    }

    public String[] getClaims() {
        return this.claims;
    }
}