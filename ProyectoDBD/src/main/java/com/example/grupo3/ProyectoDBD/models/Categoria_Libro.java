package com.example.grupo3.ProyectoDBD.models;

public class Categoria_Libro {
    private Integer id_categoria;
    private Integer id_libro;

    public Categoria_Libro(Integer id_categoria, Integer id_libro) {
        this.id_categoria = id_categoria;
        this.id_libro = id_libro;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }
}
