package com.example.grupo3.ProyectoDBD.models;

import java.util.Date;

public class Reseña {
    private Integer id_usuario;
    private Integer id_libro;
    private Integer nota;
    private String descripcion;
    private Date fecha;

    public Reseña(Integer id_usuario, Integer id_libro, Integer nota, String descripcion, Date fecha) {
        this.id_usuario = id_usuario;
        this.id_libro = id_libro;
        this.nota = nota;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
