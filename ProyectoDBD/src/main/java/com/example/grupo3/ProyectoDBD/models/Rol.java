package com.example.grupo3.ProyectoDBD.models;

public class Rol {
    Integer id_rol;
    String nombre_rol;
    String descripcion_rol;
    String permisos;

    public Rol(Integer id_rol, String nombre_rol, String descripcion_rol, String permisos) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.descripcion_rol = descripcion_rol;
        this.permisos = permisos;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getDescripcion_rol() {
        return descripcion_rol;
    }

    public void setDescripcion_rol(String descripcion_rol) {
        this.descripcion_rol = descripcion_rol;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
}
