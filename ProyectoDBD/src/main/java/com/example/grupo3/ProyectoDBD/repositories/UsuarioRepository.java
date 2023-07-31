package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Usuario;

import java.util.List;

public interface UsuarioRepository {
    public Usuario create(Usuario usuario);

    public List<Usuario>getAll();

}
