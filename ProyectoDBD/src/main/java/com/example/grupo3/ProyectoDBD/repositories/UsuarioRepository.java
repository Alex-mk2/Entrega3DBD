package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Ubicacion;
import com.example.grupo3.ProyectoDBD.models.Usuario;

import java.util.List;

public interface UsuarioRepository {
    public Usuario create(Usuario usuario);

    public List<Usuario>getAll();

    public List<Usuario>show(Integer id_usuario);

    public Usuario update(Usuario usuario, Integer id_usuario,Integer id_ubicacion);

    public void delete(int id_usuario);

    // login
    public List<Usuario> login(String correo, String contrasena);
}
