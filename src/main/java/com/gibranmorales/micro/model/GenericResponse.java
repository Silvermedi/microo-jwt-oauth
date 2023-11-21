package com.gibranmorales.micro.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class GenericResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String operacion;
    private T resultado;

    public GenericResponse() {
        super();
    }

    public GenericResponse(String operacion) {
        super();
        this.operacion = operacion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    public T getResultado() {

        return resultado;
    }
    public void setResultado(T resultado) {
        this.resultado = resultado;
    }
    public static long getSerialversionuid() {

        return serialVersionUID;
    }

}
