package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Usuario_Libro;
import com.example.grupo3.ProyectoDBD.models.Usuario_Rol;

import java.util.List;

public interface Usuario_RolRepository {

    public Usuario_Rol create(Usuario_Rol usuarioRol);

    public List<Usuario_Rol> getAll();

    public List<Usuario_Rol> show(Integer id_usuario, Integer id_rol);

    public String update(Usuario_Rol usuarioRol, Integer id_usuario, Integer id_rol);

    public void delete(Integer id_usuario, Integer id_rol);
}
