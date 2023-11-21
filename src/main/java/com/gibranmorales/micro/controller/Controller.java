package com.gibranmorales.micro.controller;

import com.gibranmorales.micro.dto.Credentials;
import com.gibranmorales.micro.model.GenericResponse;
import com.gibranmorales.micro.model.Token;
import com.gibranmorales.micro.service.IServiceProces;
import com.gibranmorales.micro.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.gibranmorales.micro.utils.Constants.SUCCESOPERATION;

@RestController
@RequestMapping("/jwtfilter")
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private JwtUtil jwtUtil = new JwtUtil();
    @Autowired
    private IServiceProces iService;

    @PostMapping(value = "/autentificacion", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<Credentials> getCredentials(@RequestHeader String username) {
        logger.info("Inicio - Controller - getCredentials");
        return iService.getCredentials(username);
    }

    @PostMapping(value = "/TokenExpires", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GenericResponse<Token>> TokenExpires(@RequestHeader String username) {
        logger.info("Entré al controlador /jwtfilter/autentificacion");
        GenericResponse<Token> response = new GenericResponse<>();
        response = jwtUtil.generateToken(username);
        response.setOperacion(SUCCESOPERATION);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<String> procesoVerboHealth() {
        logger.info("Entré al controlador /jwtfilter/health");
        GenericResponse<String> response = new GenericResponse<>();
        response.setOperacion(SUCCESOPERATION);
        response.setResultado(null);
        return response;
    }
}
