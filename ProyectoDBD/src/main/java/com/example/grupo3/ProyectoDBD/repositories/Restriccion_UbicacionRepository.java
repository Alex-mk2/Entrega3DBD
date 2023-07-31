package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Restriccion_Ubicacion;

import java.util.List;

public interface Restriccion_UbicacionRepository {

    public Restriccion_Ubicacion create(Restriccion_Ubicacion restriccionUbicacion);

    public List<Restriccion_Ubicacion> getAll();

    public List<Restriccion_Ubicacion> show(Integer id_restriccion, Integer id_ubicacion);

    public String update(Restriccion_Ubicacion restriccionUbicacion, Integer id_restriccion, Integer id_ubicacion);

    public void delete(Integer id_restriccion, Integer id_ubicacion);
}
