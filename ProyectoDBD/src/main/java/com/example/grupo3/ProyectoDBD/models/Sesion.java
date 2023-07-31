package com.example.grupo3.ProyectoDBD.models;
import java.util.Date;

public class Sesion {
    int id_sesion;
    int id_usuario;
    Date comienzo_sesion;
    Date fin_sesion;

    public Sesion(int id_sesion, int id_usuario, Date comienzo_sesion, Date fin_sesion) {
        this.id_sesion = id_sesion;
        this.id_usuario = id_usuario;
        this.comienzo_sesion = comienzo_sesion;
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

    public Date getComienzo_sesion() {
        return comienzo_sesion;
    }

    public void setComienzo_sesion(Date comienzo_sesion) {
        this.comienzo_sesion = comienzo_sesion;
    }

    public Date getFin_sesion() {
        return fin_sesion;
    }

    public void setFin_sesion(Date fin_sesion) {
        this.fin_sesion = fin_sesion;
    }
}
