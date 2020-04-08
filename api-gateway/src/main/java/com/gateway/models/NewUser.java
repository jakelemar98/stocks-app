package com.gateway.models;

public class NewUser {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
    public String setFirstname(String firstname) {
        this.firstname = firstname;
        return this.firstname;
    }

    public String setLastname(String lastname) {
        this.lastname = lastname;
        return this.lastname;
    }

    public String setEmail(String email) {
        this.email = email;
        return this.email;
    }

    public String setPassword(String password) {
        this.password = password;
        return this.password;
    }
    
}