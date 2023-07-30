package com.example.grupo3.ProyectoDBD.repositories;
import com.example.grupo3.ProyectoDBD.models.Reseña;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class ReseñaRepositoryImp implements ReseñaRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Reseña create(Reseña Reseña){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Reseña (id_usuario,id_libro, nota, descripcion, fecha)" +
                    "VALUES (:id_usuario, :id_libro, :nota, :descripcion, :fecha)";
            conn.createQuery(sql, true)
                            .addParameter("id_usuario", Reseña.getId_usuario())
                            .addParameter("id_libro", Reseña.getId_libro())
                            .addParameter("nota", Reseña.getNota())
                            .addParameter("descripcion", Reseña.getDescripcion())
                            .addParameter("fecha", Reseña.getFecha())
                            .executeUpdate();
            return(Reseña);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Reseña Reseña, Integer id_usuario) {
        return null;
    }
}
