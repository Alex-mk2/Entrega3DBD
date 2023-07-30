package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Boleta;

import java.util.List;

public interface BoletaRepository {
    Boleta create(Boleta boleta);

    List<Boleta> getAll();

    List<Boleta> show(Integer id_boleta);

    String update(Boleta boleta, Integer id_boleta);

    void delete(Integer id_boleta);
}
