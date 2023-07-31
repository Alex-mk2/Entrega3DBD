package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Categoria_Libro;

import java.util.List;

public interface Categoria_LibroRepository {

    public Categoria_Libro create(Categoria_Libro categoriaLibro);

    public List<Categoria_Libro> getAll();

    public List<Categoria_Libro> show(Integer id_categoria, Integer id_libro);

    public String update(Categoria_Libro categoriaLibro, Integer id_categoria, Integer id_libro);

    public void delete(Integer id_categoria, Integer id_libro);
}
