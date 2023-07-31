package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Libro_Carrito;

import java.util.List;

public interface Libro_CarritoRepository {
    public Libro_Carrito create(Libro_Carrito libroCarrito);

    public List<Libro_Carrito> getAll();

    public List<Libro_Carrito> show(Integer id_libro, Integer id_carrito);

    public String update(Libro_Carrito libroCarrito, Integer id_libro, Integer id_carrito);

    public void delete(Integer id_libro, Integer id_carrito);
}
