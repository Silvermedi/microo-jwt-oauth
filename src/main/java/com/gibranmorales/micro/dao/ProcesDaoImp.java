package com.gibranmorales.micro.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gibranmorales.micro.dto.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class ProcesDaoImp implements IProcesDao{
    private static final Logger logger = LoggerFactory.getLogger(IProcesDao.class);
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    EntityManager entityManager;

    @Override
    public Credentials getCredentials(String palabraClave) {
        logger.info("Inicio - IProcesDao - getCredentials");
        Credentials credenciales = new Credentials();
        List<Object[]> resultados = null;

        try {
            StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("testing.credentials");

            sp.registerStoredProcedureParameter("keyword", String.class, ParameterMode.IN);
            sp.setParameter("keyword", palabraClave);

            sp.execute();

            resultados = sp.getResultList();

            if (resultados.isEmpty()) {
                String mensajeError = "No se encontraron credenciales para la palabra clave: " + palabraClave;
                logger.info(mensajeError);
                throw new RuntimeException(mensajeError);
            }

            Object[] resultado = resultados.get(0);
            credenciales.setUsername((String) resultado[0]);
            credenciales.setPassword((String) resultado[1]);
            String json = objectMapper.writeValueAsString(credenciales);
            logger.info("Credenciales encontradas: {}", json);

            return credenciales;

        } catch (DataAccessException e) {
            throw new RuntimeException("Error al obtener credenciales: " + e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
