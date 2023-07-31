package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Ubicacion;
import com.example.grupo3.ProyectoDBD.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Usuario create(Usuario usuario) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Usuario (id_usuario,nombre, correo, contrasena, telefono, fecha_nacimiento, id_ubicacion)" +
                    "VALUES (:id_usuario,:nombre,:correo,:contrasena,:telefono, :fecha_necimiento, :id_ubicacion)";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", usuario.getId_usuario())
                    .addParameter("nombre", usuario.getNombre())
                    .addParameter("correo", usuario.getCorreo())
                    .addParameter("contrasena", usuario.getContrasena())
                    .addParameter("telefono", usuario.getTelefono())
                    .addParameter("fecha_nacimiento", usuario.getFecha_nacimiento())
                    .addParameter("id_ubicacion", usuario.getId_ubicacion())
                    .executeUpdate();
            return usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Usuario order by id_usuario ASC")
                    .executeAndFetch(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /*
    "INSERT INTO Usuario (id_usuario,nombre, correo, contrasena, telefono, fecha_nacimiento, id_ubicacion)" +
                    "VALUES (:id_usuario,:nombre,:correo,:contrasena,:telefono, :fecha_necimiento, :id_ubicacion)";
    */
    @Override
    public Usuario update(Usuario usuario, Integer id_usuario,Integer id_ubicacion) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Usuario " +
                            "SET nombre=:nombre, correo=:correo, contrasena=:contrasena, telefono=:telefono, fecha_nacimiento=:fecha_nacimiento, id_ubicacion=:id_ubicacion " +
                            "WHERE id_usuario=:id_usuario")
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("nombre", usuario.getNombre())
                    .addParameter("correo", usuario.getCorreo())
                    .addParameter("contrasena", usuario.getContrasena())
                    .addParameter("telefono", usuario.getTelefono())
                    .addParameter("fecha_nacimiento", usuario.getFecha_nacimiento())
                    .addParameter("id_ubicacion", id_ubicacion)
                    .executeUpdate();
            return usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

