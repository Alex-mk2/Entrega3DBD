package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Reseña;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ReseñaRepositoryImp implements ReseñaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Reseña create(Reseña Reseña) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Reseña (id_usuario,id_libro, nota, descripcion, fecha)" +
                    "VALUES (:id_usuario, :id_libro, :nota, :descripcion, :fecha)";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", Reseña.getId_usuario())
                    .addParameter("id_libro", Reseña.getId_libro())
                    .addParameter("nota", Reseña.getNota())
                    .addParameter("descripcion", Reseña.getDescripcion())
                    .addParameter("fecha", Reseña.getFecha())
                    .executeUpdate();
            return (Reseña);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Reseña Reseña, Integer id_usuario){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Reseña set id_usuario=:id_usuario, id_libro=:id_libro, nota=:nota, descripcion=:descripcion, fecha=:fecha WHERE id_usuario=:id_usuario ";
            conn.createQuery(updateSql)
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_libro", Reseña.getId_libro())
                    .addParameter("nota", Reseña.getNota())
                    .addParameter("descripcion", Reseña.getDescripcion())
                    .addParameter("fecha", Reseña.getFecha())
                    .executeUpdate();
            return "Reseña actualizada";

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar la reseña";
        }
    }
    @Override
    public void delete(Integer id_usuario){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Reseña where id_usuario =: id_usuario")
                    .addParameter("id_usuario", id_usuario)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    @Override
    public List<Reseña> Show(Integer id_usuario){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Reseña WHERE id_usuario=:id_usuario")
                    .addParameter("id_usuario", id_usuario)
                    .executeAndFetch(Reseña.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Reseña> getAllReview(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Reseña ORDER BY nota ASC")
                    .executeAndFetch(Reseña.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
