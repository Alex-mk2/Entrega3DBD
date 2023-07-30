package com.example.grupo3.ProyectoDBD.models;

public class Metodo_Pago {
    private Integer id_metodo_pago;

    private String tipo_pago;

    public Metodo_Pago(Integer id_metodo_pago, String tipo_pago) {
        this.id_metodo_pago = id_metodo_pago;
        this.tipo_pago = tipo_pago;
    }
    public Integer getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(Integer id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
}
