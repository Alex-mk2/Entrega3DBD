package com.example.grupo3.ProyectoDBD.models;

public class Libro_Restriccion {
    private Integer id_libro;

    private Integer id_restriccion;

    public Libro_Restriccion(Integer id_libro, Integer id_restriccion) {
        this.id_libro = id_libro;
        this.id_restriccion = id_restriccion;
    }


    public Integer getId_libro() {
        return id_libro;
    }

    public Integer getId_restriccion() {
        return id_restriccion;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public void setId_restriccion(Integer id_restriccion) {
        this.id_restriccion = id_restriccion;
    }
}
