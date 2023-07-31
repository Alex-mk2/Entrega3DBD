package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Metodo_Pago;

import java.util.List;

public interface MetodoPagoRepository {

    public Metodo_Pago create(Metodo_Pago MetodoPago);

    public List<Metodo_Pago> getAll();

    public List<Metodo_Pago> show(Integer id_metodo_pago);

    public String update(Metodo_Pago MetodoPago, Integer id_metodo_pago);

    public void delete(Integer id_metodo_pago);
}