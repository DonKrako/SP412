package com.henningSB412.entity;

public class AuthenticationResponse {
    private String JSESSIONID;

    public AuthenticationResponse() {
    }

    public String getJSESSIONID() {
        return JSESSIONID;
    }

    public void setJSESSIONID(String JSESSIONID) {
        this.JSESSIONID = JSESSIONID;
    }

    public AuthenticationResponse(String JSESSIONID) {
        this.JSESSIONID = JSESSIONID;
    }
}
