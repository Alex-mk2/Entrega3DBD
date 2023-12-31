package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Boleta;
import com.example.grupo3.ProyectoDBD.models.Ubicacion;
import com.example.grupo3.ProyectoDBD.models.Usuario;

import java.util.List;

public interface UbicacionRepository {
    public Ubicacion create(Ubicacion ubicacion);
    public List<Ubicacion>getAll();

    public Ubicacion update(Ubicacion ubicacion, Integer id_boleta);
}