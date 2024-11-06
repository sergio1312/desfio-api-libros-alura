package com.alura.challenge_libros.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
