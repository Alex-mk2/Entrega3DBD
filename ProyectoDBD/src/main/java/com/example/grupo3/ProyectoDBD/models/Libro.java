package com.example.grupo3.ProyectoDBD.models;

public class Libro {
    private Integer id_libro;

    private String autor;

    private String titulo;

    private Integer precio;

    private Integer stock;

    private Integer visitas;

    private Integer favoritos;

    private Integer id_usuario;

    public Libro(Integer id_libro, String autor, String titulo, Integer precio, Integer stock, Integer visitas, Integer favoritos, Integer id_usuario) {
        this.id_libro = id_libro;
        this.autor = autor;
        this.titulo = titulo;
        this.precio = precio;
        this.stock = stock;
        this.visitas = visitas;
        this.favoritos = favoritos;
        this.id_usuario = id_usuario;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    public Integer getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Integer favoritos) {
        this.favoritos = favoritos;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
}



