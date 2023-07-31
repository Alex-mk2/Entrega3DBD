package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Boleta;
import com.example.grupo3.ProyectoDBD.models.Ubicacion;
import com.example.grupo3.ProyectoDBD.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class UbicacionRepositoryImp implements UbicacionRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Ubicacion create(Ubicacion ubicacion) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Ubicacion (id_ubicacion, pais, ciudad)" +
                    "VALUES (:id_ubicacion,:pais,:ciudad)";
            conn.createQuery(sql, true)
                    .addParameter("id_ubicacion", ubicacion.getId_ubicacion())
                    .addParameter("pais", ubicacion.getPais())
                    .addParameter("ciudad", ubicacion.getCiudad())
                    .executeUpdate();
            return ubicacion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ubicacion> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Ubicacion order by id_ubicacion ASC")
                    .executeAndFetch(Ubicacion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Ubicacion update(Ubicacion ubicacion, Integer id_ubicacion) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Ubicacion " +
                            "SET ciudad=:ciudad, pais=:pais " +
                            "WHERE id_ubicacion=:id_ubicacion")
                    .addParameter("id_ubicacion", id_ubicacion)
                    .addParameter("pais", ubicacion.getPais())
                    .addParameter("ciudad", ubicacion.getCiudad())
                    .executeUpdate();
            return ubicacion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
