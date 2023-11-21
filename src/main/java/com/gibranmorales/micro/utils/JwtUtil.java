package com.gibranmorales.micro.utils;

import com.gibranmorales.micro.model.GenericResponse;
import com.gibranmorales.micro.model.Token;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private  static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    private static final String secretKey = "Prueba123";

    public GenericResponse<Token> generateToken(String username) {
        GenericResponse<Token> response = new GenericResponse<>();
        Token token = new Token();
        logger.info("inicio generateToken");
        long now = System.currentTimeMillis();
        token.setToken(Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 900000)) // Token válido por 15 minutos
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact());
        logger.info("Token que expira en 15 mns : {}",token.getToken());
        response.setResultado(token);
        return response;
    }

    public GenericResponse<Token> generateTokenForTesting(String username) {
        GenericResponse<Token> response = new GenericResponse<>();
        Token token = new Token();
        logger.info("Generando token de prueba que no expira");
        long now = System.currentTimeMillis();

        token.setToken(Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact());
        logger.info("Token generado: {}",token.getToken());
        response.setResultado(token);
        return response;
    }

}