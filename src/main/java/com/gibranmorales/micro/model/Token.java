package com.gibranmorales.micro.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;
    private String token;
    private String msj;

    public Token() {
        super();
    }

    public Token(String token, String msj) {
        super();
        this.token = token;
        this.msj = msj;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
}
