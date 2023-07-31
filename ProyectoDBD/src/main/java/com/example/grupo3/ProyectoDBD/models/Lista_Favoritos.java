package com.example.grupo3.ProyectoDBD.models;

public class Lista_Favoritos {
    private Integer id_usuario;
    private Integer id_libre;

    public Lista_Favoritos(Integer id_usuario, Integer id_libre) {
        this.id_usuario = id_usuario;
        this.id_libre = id_libre;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public Integer getId_libre() {
        return id_libre;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_libre(Integer id_libre) {
        this.id_libre = id_libre;
    }
}
