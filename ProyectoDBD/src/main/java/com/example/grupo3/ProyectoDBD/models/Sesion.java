package com.example.grupo3.ProyectoDBD.models;
import java.time.LocalDateTime;

public class Sesion {
    int id_sesion;
    int id_usuario;
    LocalDateTime inicio_sesion;
    LocalDateTime fin_sesion;

    public Sesion(int id_sesion, int id_usuario, LocalDateTime inicio_sesion, LocalDateTime fin_sesion) {
        this.id_sesion = id_sesion;
        this.id_usuario = id_usuario;
        this.inicio_sesion = inicio_sesion;
        this.fin_sesion = fin_sesion;
    }

    public int getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(int id_sesion) {
        this.id_sesion = id_sesion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDateTime getInicio_sesion() {
        return inicio_sesion;
    }

    public void setInicio_sesion(LocalDateTime inicio_sesion) {
        this.inicio_sesion = inicio_sesion;
    }

    public LocalDateTime getFin_sesion() {
        return fin_sesion;
    }

    public void setFin_sesion(LocalDateTime fin_sesion) {
        this.fin_sesion = fin_sesion;
    }
}
