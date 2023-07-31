package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Usuario;
import com.example.grupo3.ProyectoDBD.models.Libro;
import com.example.grupo3.ProyectoDBD.models.Usuario_Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Usuario_LibroRepositoryImp implements Usuario_LibroRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Usuario_Libro create(Usuario_Libro usuarioLibro) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Usuario_Libro(id_usuario,id_libro)" +
                    "VALUES (:id_usuario,:id_libro)";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", usuarioLibro.getId_usuario())
                    .addParameter("id_libro", usuarioLibro.getId_libro())
                    .executeUpdate();
            return usuarioLibro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario_Libro> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Usuario_Libro")
                    .executeAndFetch(Usuario_Libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario_Libro> show(Integer id_usuario, Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Usuario_Libro WHERE id_usuario=:id_usuario AND  id_libro=:id_libro")
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_libro", id_libro)
                    .executeAndFetch(Usuario_Libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Usuario_Libro usuarioLibro, Integer id_usuario, Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Usuario_Libro " +
                            "SET id_usuario=:nuevo_id_usuario, id_libro=:nuevo_id_libro " +
                            "WHERE id_usuario=:id_usuario AND id_libro=:id_libro")
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_libro", id_libro)
                    .addParameter("nuevo_id_usuario", usuarioLibro.getId_usuario())
                    .addParameter("nuevo_id_libro", usuarioLibro.getId_libro())
                    .executeUpdate();
            return "Tupla Categoria_Libro actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: No se pudo actualizar Categoria_Libro";
        }
    }

    @Override
    public void delete(Integer id_usuario, Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Usuario_Libro WHERE id_usuario=:id_usuario AND id_libro=:id_libro")
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_libro", id_libro)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

