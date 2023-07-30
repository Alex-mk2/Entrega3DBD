package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.CarritoCompra;

import java.util.List;

public interface CarritoCompraRepository {
    CarritoCompra create(CarritoCompra carritoCompra);

    List<CarritoCompra> getAll();

    List<CarritoCompra> show(Integer id_carrito);

    String update(CarritoCompra carritoCompra, Integer id_carrito);

    void delete(Integer id_carrito);
}
