package com.example.grupo3.ProyectoDBD.models;

public class Restriccion {
    private Integer id_restriccion;
    private Integer edad_minima;

    public Restriccion(Integer id_restriccion, Integer edad_minima) {
        this.id_restriccion = id_restriccion;
        this.edad_minima = edad_minima;
    }

    public Integer getId_restriccion() {
        return id_restriccion;
    }

    public void setId_restriccion(Integer id_restriccion) {
        this.id_restriccion = id_restriccion;
    }

    public Integer getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(Integer edad_minima) {
        this.edad_minima = edad_minima;
    }
}
