package com.example.grupo3.ProyectoDBD.models;

public class Restriccion_Ubicacion {
    private Integer id_restriccion;

    private Integer id_ubicacion;

    public Restriccion_Ubicacion(Integer id_restriccion, Integer id_ubicacion) {
        this.id_restriccion = id_restriccion;
        this.id_ubicacion = id_ubicacion;
    }

    public Integer getId_restriccion() {
        return id_restriccion;
    }

    public Integer getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_restriccion(Integer id_restriccion) {
        this.id_restriccion = id_restriccion;
    }

    public void setId_ubicacion(Integer id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }
}
