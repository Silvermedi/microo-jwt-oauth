package com.gibranmorales.micro.service;

import com.gibranmorales.micro.dto.Credentials;
import com.gibranmorales.micro.model.GenericResponse;


public interface IServiceProces {

    GenericResponse<Credentials> getCredentials(String keyword);
}
