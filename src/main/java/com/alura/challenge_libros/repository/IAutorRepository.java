package com.alura.challenge_libros.repository;

import com.alura.challenge_libros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findAuthorByNombre(String nombreAutor);

}
