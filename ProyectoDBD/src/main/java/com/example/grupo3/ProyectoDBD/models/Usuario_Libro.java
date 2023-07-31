package com.example.grupo3.ProyectoDBD.models;

public class Usuario_Libro {
    private Integer id_usuario;
    private Integer id_libro;

    public Usuario_Libro(Integer id_usuario, Integer id_libro) {
        this.id_usuario = id_usuario;
        this.id_libro = id_libro;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }
}
