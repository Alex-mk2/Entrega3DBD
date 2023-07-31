package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Categoria_Libro;
import com.example.grupo3.ProyectoDBD.models.Usuario_Libro;

import java.util.List;

public interface Usuario_LibroRepository {

    public Usuario_Libro create(Usuario_Libro usuarioLibro);

    public List<Usuario_Libro> getAll();

    public List<Usuario_Libro> show(Integer id_usuario, Integer id_libro);

    public String update(Usuario_Libro usuarioLibro, Integer id_usuario, Integer id_libro);

    public void delete(Integer id_usuario, Integer id_libro);
}
