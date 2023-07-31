package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Resena;
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
    public Resena create(Resena Resena) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Resena (id_usuario,id_libro, nota, descripcion, fecha)" +
                    "VALUES (:id_usuario, :id_libro, :nota, :descripcion, :fecha)";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", Resena.getId_usuario())
                    .addParameter("id_libro", Resena.getId_libro())
                    .addParameter("nota", Resena.getNota())
                    .addParameter("descripcion", Resena.getDescripcion())
                    .addParameter("fecha", Resena.getFecha())
                    .executeUpdate();
            return (Resena);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Resena Resena, Integer id_usuario){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Resena set id_usuario=:id_usuario, id_libro=:id_libro, nota=:nota, descripcion=:descripcion, fecha=:fecha WHERE id_usuario=:id_usuario ";
            conn.createQuery(updateSql)
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_libro", Resena.getId_libro())
                    .addParameter("nota", Resena.getNota())
                    .addParameter("descripcion", Resena.getDescripcion())
                    .addParameter("fecha", Resena.getFecha())
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
            conn.createQuery("DELETE from Resena where id_usuario =: id_usuario")
                    .addParameter("id_usuario", id_usuario)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    @Override
    public List<Resena> Show(Integer id_usuario){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Resena WHERE id_usuario=:id_usuario")
                    .addParameter("id_usuario", id_usuario)
                    .executeAndFetch(Resena.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Resena> getAllReview(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Resena ORDER BY nota ASC")
                    .executeAndFetch(Resena.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
