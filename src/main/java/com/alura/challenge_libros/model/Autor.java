package com.alura.challenge_libros.model;

public class Autor {
    private Long id;
    private String nombre;
    private Integer fechaNacimiento;

    public Autor(String nombre, Integer fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
