package com.gibranmorales.micro.model;

import java.io.Serializable;

public class ErrorResponse implements Serializable {
    private int codigo;
    private String mensaje;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(int codigo, String mensaje) {
        super();
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}