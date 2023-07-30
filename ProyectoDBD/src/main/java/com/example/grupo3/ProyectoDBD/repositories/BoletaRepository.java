package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Boleta;

import java.util.List;

public interface BoletaRepository {

    public Boleta create(Boleta boleta);

    public List<Boleta> getAll();

    public List<Boleta> show(Integer id_boleta);

    public String update(Boleta boleta, Integer id_boleta);

    public void delete(Integer id_boleta);
}
