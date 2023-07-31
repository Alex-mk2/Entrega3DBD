package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Restriccion;

import java.util.List;

public interface RestriccionRepository {
    Restriccion create(Restriccion Restriccion);

    String update(Restriccion Restriccion, Integer id_restriccion);

    void delete(Integer id_restriccion);

    List<Restriccion> Show(Integer id_restriccion);

    List<Restriccion> getAllRestiction();
}
