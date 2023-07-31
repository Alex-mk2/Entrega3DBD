package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Categoria_Libro;
import com.example.grupo3.ProyectoDBD.models.Libro;

import java.util.List;

public interface LibroRepository {
    public Libro create(Libro libro);

    public List<Libro> getAll();

    public List<Libro> show(Integer id_libro);

    public String update(Libro libro, Integer id_libro);

    public void delete(Integer id_libro);

    public List<Libro> rankingVisitas();

    public List<Libro> rankingFavoritos();
}
