package com.gibranmorales.micro.service;

import com.gibranmorales.micro.dao.IProcesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gibranmorales.micro.dto.Credentials;
import com.gibranmorales.micro.model.GenericResponse;
import com.gibranmorales.micro.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class ServiceProcesImp implements IServiceProces{

    @Autowired
    IProcesDao iProcesDao;
    private static final Logger logger = LoggerFactory.getLogger(IServiceProces.class);
    @Override
    public GenericResponse<Credentials> getCredentials(String keyword) {
        logger.info("Inicio - ServiceProces - getCredentials");
        GenericResponse<Credentials> response = new GenericResponse<>();
        Credentials credentials = new Credentials();
        credentials = iProcesDao.getCredentials(keyword);
        response.setResultado(credentials);
        response.setOperacion(Constants.SUCCESOPERATION);
        return response;
    }
}
