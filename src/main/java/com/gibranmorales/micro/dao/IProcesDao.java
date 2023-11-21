package com.gibranmorales.micro.dao;

import com.gibranmorales.micro.dto.Credentials;

public interface IProcesDao {

    Credentials getCredentials(String keyword);
}
