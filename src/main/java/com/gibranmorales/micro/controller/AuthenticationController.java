package com.gibranmorales.micro.controller;

import com.gibranmorales.micro.model.GenericResponse;
import com.gibranmorales.micro.model.Token;
import com.gibranmorales.micro.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gibranmorales.micro.utils.Constants.SUCCESOPERATION;

@RestController
@RequestMapping("/GetToken")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<GenericResponse<Token>> authenticate() {
        logger.info("Entré al controlador /GetToken");
        GenericResponse<Token> response = new GenericResponse<>();
        response = jwtUtil.generateTokenForTesting("Gibran");
        response.setOperacion(SUCCESOPERATION);
        return ResponseEntity.ok(response);
    }
}
