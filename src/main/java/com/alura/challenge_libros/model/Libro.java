package com.alura.challenge_libros.model;

import java.util.List;

public class Libro {
    private Long id;
    private String titulo;
    private List<Autor> autores;
    private List<String> idiomas;
    private Integer numDescargas;


    public Libro(){}

    public Libro(DatosLibros datosLibros) {
        this.titulo = datosLibros.titulo();
        this.idiomas = datosLibros.idiomas();
        this.numDescargas = datosLibros.numDescargas();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }


    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(Integer numDescargas) {
        this.numDescargas = numDescargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", idiomas=" + idiomas +
                ", numDescargas=" + numDescargas +
                '}';
    }
}
