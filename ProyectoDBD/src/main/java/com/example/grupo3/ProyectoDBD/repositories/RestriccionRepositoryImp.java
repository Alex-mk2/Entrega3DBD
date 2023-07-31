package com.example.grupo3.ProyectoDBD.repositories;
import com.example.grupo3.ProyectoDBD.models.Restriccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class RestriccionRepositoryImp implements RestriccionRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Restriccion create(Restriccion Restriccion){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Restriccion (id_restriccion, edad_minima)"+
                    "VALUES (:id_restriccion, :edad_minima)";
            conn.createQuery(sql, true)
                    .addParameter("id_restriccion", Restriccion.getId_restriccion())
                    .addParameter("edad_minima", Restriccion.getEdad_minima())
                    .executeUpdate();
            return Restriccion;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Restriccion Restriccion, Integer id_restriccion){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Restriccion set id_restriccion=:id_restriccion, edad_minima=:edad_minima,WHERE id_restriccion=:id_restriccion";
            conn.createQuery(updateSql)
                    .addParameter("id_restriccion", id_restriccion)
                    .addParameter("edad_minima",Restriccion.getEdad_minima())
                    .executeUpdate();
            return "Restriccion actualizada";

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar la restriccion";
        }
    }
    @Override
    public void delete(Integer id_restriccion){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Restriccion where id_restriccion =: id_restriccion")
                    .addParameter("id_restriccion", id_restriccion)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    @Override
    public List<Restriccion> Show(Integer id_restriccion){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Restriccion WHERE id_restriccion=:id_restriccion")
                    .addParameter("id_restriccion", id_restriccion)
                    .executeAndFetch(Restriccion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Restriccion> getAllRestiction(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Restriccion ORDER BY edad_minima ASC")
                    .executeAndFetch(Restriccion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
