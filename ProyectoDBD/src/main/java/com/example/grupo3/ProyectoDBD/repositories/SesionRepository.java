
package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Sesion;
import java.util.List;

public interface SesionRepository {

    Sesion create(Sesion sesion);

    List<Sesion> getAll();

    List<Sesion> show(int id_sesion);

    String update(Sesion sesion, int id_sesion);

    void delete(int id_sesion);
}
