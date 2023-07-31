package com.example.grupo3.ProyectoDBD.models;

public class Libro_Carrito {
    private Integer id_libro;
    private Integer id_carrito;

    public Libro_Carrito(Integer id_libro, Integer id_carrito) {
        this.id_libro = id_libro;
        this.id_carrito = id_carrito;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public Integer getId_carrito() {
        return id_carrito;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public void setId_carrito(Integer id_carrito) {
        this.id_carrito = id_carrito;
    }
}
