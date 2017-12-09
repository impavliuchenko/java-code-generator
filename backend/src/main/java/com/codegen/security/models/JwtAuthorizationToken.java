package com.codegen.security.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

//used for other classes as a model
public class JwtAuthorizationToken extends UsernamePasswordAuthenticationToken {

    //store the token here
    private String token;

    public JwtAuthorizationToken(String token) {
        super(null, null);
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
