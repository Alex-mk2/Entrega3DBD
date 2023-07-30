package com.example.grupo3.ProyectoDBD.models;

import java.util.Date;

public class CarritoCompra {
    private Integer id_carrito;
    private Date fecha_creacion;
    private Integer id_metodo_pago;
    private Integer id_usuario;

    public CarritoCompra(Integer id_carrito, Date fecha_creacion, Integer id_metodo_pago, Integer id_usuario) {
        this.id_carrito = id_carrito;
        this.fecha_creacion = fecha_creacion;
        this.id_metodo_pago = id_metodo_pago;
        this.id_usuario = id_usuario;
    }

    public CarritoCompra() {
    }

    public Integer getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Integer id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Integer getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(Integer id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
}
