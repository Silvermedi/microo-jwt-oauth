package com.gibranmorales.micro.exception;

import com.gibranmorales.micro.model.ErrorResponse;
import com.gibranmorales.micro.model.GenericResponse;
import com.gibranmorales.micro.utils.Constants;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<GenericResponse<ErrorResponse>> handleExpiredJwtException(ExpiredJwtException exception, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCodigo(Constants.ERROR401);
        errorResponse.setMensaje("Token expirado: " + exception.getMessage());

        GenericResponse<ErrorResponse> genericResponse = new GenericResponse<>();
        genericResponse.setResultado(errorResponse);
        genericResponse.setOperacion(Constants.FAILOPERATION);

        return new ResponseEntity<>(genericResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<GenericResponse<ErrorResponse>> handleMalformedJwtException(MalformedJwtException exception, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCodigo(Constants.ERROR400);
        errorResponse.setMensaje("JWT malformado: " + exception.getMessage());

        GenericResponse<ErrorResponse> genericResponse = new GenericResponse<>();
        genericResponse.setResultado(errorResponse);
        genericResponse.setOperacion(Constants.FAILOPERATION);

        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse<ErrorResponse>> handleException(Exception exception, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCodigo(Constants.ERROR500);
        errorResponse.setMensaje("Error interno del servidor: " + exception.getMessage());

        GenericResponse<ErrorResponse> genericResponse = new GenericResponse<>();
        genericResponse.setResultado(errorResponse);
        genericResponse.setOperacion(Constants.FAILOPERATION);

        return new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
