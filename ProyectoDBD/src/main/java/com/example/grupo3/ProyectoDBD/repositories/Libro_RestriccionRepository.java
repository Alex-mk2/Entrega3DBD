package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Libro_Restriccion;

import java.util.List;

public interface Libro_RestriccionRepository {
    Libro_Restriccion create(Libro_Restriccion Libro_Restriccion);

    String update(Libro_Restriccion Libro_Restriccion, Integer id_libro);

    void delete(Integer id_libro);

    List<Libro_Restriccion> Show(Integer id_libro);

    List<Libro_Restriccion> getAllRestictionBook();
}
