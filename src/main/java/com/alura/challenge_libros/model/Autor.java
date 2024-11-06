package com.alura.challenge_libros.model;

public class Autor {
    private Long id;
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaDesceso;

    public Autor(String nombre, Integer fechaNacimiento, Integer fechaDesceso) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDesceso = fechaDesceso;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Integer getFechaDesceso(){
        return fechaDesceso;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaDesceso=" + fechaDesceso +
                '}';
    }
}
