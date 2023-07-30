package com.example.grupo3.ProyectoDBD.models;

public class Ubicacion {
    private Integer id_ubicacion;

    private String pais;

    private String ciudad;

    public Integer getId_ubicacion() {
        return id_ubicacion;
    }

    //Contrustor
    public Ubicacion(Integer id_ubicacion, String pais, String ciudad) {
        this.id_ubicacion = id_ubicacion;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public void setId_ubicacion(Integer id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
