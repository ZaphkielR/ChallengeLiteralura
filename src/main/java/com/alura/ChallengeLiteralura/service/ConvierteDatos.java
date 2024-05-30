package com.alura.ChallengeLiteralura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;


public class ConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String convertirAStringJson(LinkedHashMap<String, Integer> linkedHashMap){
        try {
            return objectMapper.writeValueAsString(linkedHashMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
