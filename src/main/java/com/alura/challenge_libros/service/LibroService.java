package com.alura.challenge_libros.service;

import com.alura.challenge_libros.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private ILibroRepository repository;
}
