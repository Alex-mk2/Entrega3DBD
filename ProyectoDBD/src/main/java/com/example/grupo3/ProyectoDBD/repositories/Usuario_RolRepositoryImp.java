package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Usuario;
import com.example.grupo3.ProyectoDBD.models.Libro;
import com.example.grupo3.ProyectoDBD.models.Usuario_Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Usuario_RolRepositoryImp implements Usuario_RolRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Usuario_Rol create(Usuario_Rol usuarioRol) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Usuario_Rol(id_usuario,id_rol)" +
                    "VALUES (:id_usuario,:id_libro)";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", usuarioRol.getId_usuario())
                    .addParameter("id_rol", usuarioRol.getId_rol())
                    .executeUpdate();
            return usuarioRol;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario_Rol> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Usuario_Rol")
                    .executeAndFetch(Usuario_Rol.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario_Rol> show(Integer id_usuario, Integer id_rol) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Usuario_Rol WHERE id_usuario=:id_usuario AND  id_rol=:id_rol")
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_rol", id_rol)
                    .executeAndFetch(Usuario_Rol.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Usuario_Rol usuarioRol, Integer id_usuario, Integer id_rol) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Usuario_Rol " +
                            "SET id_usuario=:nuevo_id_usuario, id_rol=:nuevo_id_rol " +
                            "WHERE id_usuario=:id_usuario AND id_rol=:id_rol")
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_rol", id_rol)
                    .addParameter("nuevo_id_usuario", usuarioRol.getId_usuario())
                    .addParameter("nuevo_id_rol", usuarioRol.getId_rol())
                    .executeUpdate();
            return "Tupla Categoria_Libro actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: No se pudo actualizar Categoria_Libro";
        }
    }

    @Override
    public void delete(Integer id_usuario, Integer id_rol) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Usuario_Rol WHERE id_usuario=:id_usuario AND id_rol=:id_rol")
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_rol", id_rol)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


