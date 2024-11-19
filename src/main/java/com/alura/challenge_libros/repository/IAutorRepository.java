package com.alura.challenge_libros.repository;

import com.alura.challenge_libros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findAuthorByNombre(String nombreAutor);
    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento <= :year AND (a.fechaDesceso IS NULL OR a.fechaDesceso >= :year)")
    List<Autor> findAuthorBetweenYear(int year);


}
