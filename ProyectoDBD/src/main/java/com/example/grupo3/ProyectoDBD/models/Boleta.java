package com.example.grupo3.ProyectoDBD.models;

import java.util.Date;

public class Boleta {

    private Integer id_boleta;

    private Date fecha_pago;

    private String resumen_compra;

    private Integer total_pagado;

    private Integer id_carro;

    private Integer id_usuario;

    // Constructor
    public Boleta(Integer id_boleta, Date fecha_pago, String resumen_compra, Integer total_pagado, Integer id_carro, Integer id_usuario) {
        this.id_boleta = id_boleta;
        this.fecha_pago = fecha_pago;
        this.resumen_compra = resumen_compra;
        this.total_pagado = total_pagado;
        this.id_carro = id_carro;
        this.id_usuario = id_usuario;
    }

    public Boleta() {
    }

    //Getters
    public Integer getId_boleta() {
        return id_boleta;
    }

    //Setters
    public void setId_boleta(Integer id_boleta) {
        this.id_boleta = id_boleta;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getResumen_compra() {
        return resumen_compra;
    }

    public void setResumen_compra(String resumen_compra) {
        this.resumen_compra = resumen_compra;
    }

    public Integer getTotal_pagado() {
        return total_pagado;
    }

    public void setTotal_pagado(Integer total_pagado) {
        this.total_pagado = total_pagado;
    }

    public Integer getId_carro() {
        return id_carro;
    }

    public void setId_carro(Integer id_carro) {
        this.id_carro = id_carro;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
}
