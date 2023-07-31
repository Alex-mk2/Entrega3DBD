package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Restriccion_Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Restriccion_UbicacionRepositoryImp implements Restriccion_UbicacionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Restriccion_Ubicacion create(Restriccion_Ubicacion restriccionUbicacion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Restriccion_Ubicacion (id_restriccion,id_ubicacion)" +
                    "VALUES (:id_restriccion,:id_ubicacion)";
            conn.createQuery(sql, true)
                    .addParameter("id_restriccion", restriccionUbicacion.getId_restriccion())
                    .addParameter("id_ubicacion", restriccionUbicacion.getId_ubicacion())
                    .executeUpdate();
            return restriccionUbicacion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Restriccion_Ubicacion> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Restriccion_Ubicacion")
                    .executeAndFetch(Restriccion_Ubicacion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Restriccion_Ubicacion> show(Integer id_restriccion, Integer id_ubicacion) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Restriccion_Ubicacion WHERE id_restriccion=:id_restriccion AND  id_ubicacion=:id_ubicacion")
                    .addParameter("id_restriccion", id_restriccion)
                    .addParameter("id_ubicacion", id_ubicacion)
                    .executeAndFetch(Restriccion_Ubicacion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Restriccion_Ubicacion restriccionUbicacion, Integer id_restriccion, Integer id_ubicacion) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Restriccion_Ubicacion " +
                            "SET id_restriccion=:nuevo_id_restriccion, id_libro=:nuevo_id_ubicacion " +
                            "WHERE id_restriccion=:id_restriccion AND id_ubicacion=:id_ubicacion")
                    .addParameter("id_restriccion", id_restriccion)
                    .addParameter("id_ubicacion", id_ubicacion)
                    .addParameter("nuevo_id_restriccion", restriccionUbicacion.getId_restriccion())
                    .addParameter("nuevo_id_ubicacion", restriccionUbicacion.getId_ubicacion())
                    .executeUpdate();
            return "Tupla Categoria_Libro actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: No se pudo actualizar Categoria_Libro";
        }
    }

    @Override
    public void delete(Integer id_restriccion, Integer id_ubicacion) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Restriccion_Ubicacion WHERE id_restriccion=:id_restriccion AND id_ubicacion=:id_ubicacion")
                    .addParameter("id_restriccion", id_restriccion)
                    .addParameter("id_ubicacion", id_ubicacion)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

