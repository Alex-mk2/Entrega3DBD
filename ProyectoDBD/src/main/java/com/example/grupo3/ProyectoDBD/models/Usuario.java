package com.example.grupo3.ProyectoDBD.models;

import java.util.Date;

public class Usuario {

    private Integer id_usuario;

    private String nombre;

    private String correo;

    private String contraseña;

    //Contructor
    public Usuario(Integer id_usuario, String nombre, String correo, String contraseña, String telefono, Date fecha_nacimiento, Integer id_ubicacion) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_ubicacion = id_ubicacion;
    }

    // Getters y Setters
    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(Integer id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    private String telefono;

    private Date fecha_nacimiento;

    private Integer id_ubicacion;
}
