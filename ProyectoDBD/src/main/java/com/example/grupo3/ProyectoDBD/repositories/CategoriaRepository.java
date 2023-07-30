package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Categoria;

import java.util.List;

public interface CategoriaRepository {
    Categoria create(Categoria categoria);

    List<Categoria> getAll();

    List<Categoria> show(Integer id_categoria);

    String update(Categoria categoria, Integer id_categoria);

    void delete(Integer id_categoria);
}
