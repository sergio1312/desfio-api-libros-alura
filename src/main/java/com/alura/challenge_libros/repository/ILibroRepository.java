package com.alura.challenge_libros.repository;

import com.alura.challenge_libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTituloContainsIgnoreCase(String tituloLibro);
    List<Libro> findBookByIdiomas(String idioma);
}
