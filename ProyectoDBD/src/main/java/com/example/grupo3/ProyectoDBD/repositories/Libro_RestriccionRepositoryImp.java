package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Libro_Restriccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Libro_RestriccionRepositoryImp implements Libro_RestriccionRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Libro_Restriccion create(Libro_Restriccion Libro_Restriccion){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Libro_Restriccion (id_libro, id_restriccion)"+
                    "VALUES (:id_libro, :id_restriccion)";
            conn.createQuery(sql, true)
                    .addParameter("id_libro", Libro_Restriccion.getId_libro())
                    .addParameter("id_restriccion", Libro_Restriccion.getId_restriccion())
                    .executeUpdate();
            return Libro_Restriccion;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Libro_Restriccion Libro_Restriccion, Integer id_libro){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Libro_Restriccion set id_libro=:id_libro,id_restriccion=:id_restriccion, WHERE id_libro=:id_libro";
            conn.createQuery(updateSql)
                    .addParameter("id_libro", id_libro)
                    .addParameter("id_restriccion",Libro_Restriccion.getId_restriccion())
                    .executeUpdate();
            return "Restriccion del libro actualizada";

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar la restriccion del libro";
        }
    }
    @Override
    public void delete(Integer id_libro){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Libro_Restriccion where id_libro =: id_libro")
                    .addParameter("id_libro", id_libro)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    @Override
    public List<Libro_Restriccion> Show(Integer id_libro){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Libro_Restriccion WHERE id_libro=:id_libro")
                    .addParameter("id_libro", id_libro)
                    .executeAndFetch(Libro_Restriccion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Libro_Restriccion> getAllRestictionBook(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Libro_Restriccion ORDER BY id_restriccion ASC")
                    .executeAndFetch(Libro_Restriccion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
