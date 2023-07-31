package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Sesion;

import java.util.list;

public interface SesionRepository {

    Sesion create(Sesion sesion);

    List<Sesion> getAll;

    List<Sesion> show(integer id_sesion);

    String update(Sesion sesion, int id_sesion);

    void delete(Integer id_sesion);
}