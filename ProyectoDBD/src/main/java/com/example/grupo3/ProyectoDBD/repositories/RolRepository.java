package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Rol;

import java.util.List;

public interface RolRepository {
    Rol create(Rol Rol);

    String update(Rol Rol, Integer id_rol);

    void delete(Integer id_rol);

    List<Rol> Show(Integer id_rol);

    List<Rol> getAllRol();
}
