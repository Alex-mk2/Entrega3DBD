package com.example.grupo3.ProyectoDBD.models;

public class Usuario_Rol {

    private Integer id_usuario;
    private Integer id_rol;

    public Usuario_Rol(Integer id_usuario, Integer id_rol) {
        this.id_usuario = id_usuario;
        this.id_rol = id_rol;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }
}
