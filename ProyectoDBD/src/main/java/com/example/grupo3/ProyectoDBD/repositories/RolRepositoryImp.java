package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RolRepositoryImp implements RolRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Rol create(Rol Rol){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Rol (id_rol, nombre_rol, descripcion_rol, permisos)"+
                    "VALUES (:id_rol, :nombre_rol, :descripcion_rol, :permisos)";
            conn.createQuery(sql, true)
                    .addParameter("id_rol", Rol.getId_rol())
                    .addParameter("nombre_rol", Rol.getNombre_rol())
                    .addParameter("descripcion_rol", Rol.getDescripcion_rol())
                    .addParameter("permisos", Rol.getPermisos())
                    .executeUpdate();
            return Rol;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Rol Rol, Integer id_rol){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Rol set id_rol=:id_rol, nombre_rol=:nombre_rol, descripcion_rol=:descripcion_rol, permisos=:permisos WHERE id_rol=:id_rol";
            conn.createQuery(updateSql)
                    .addParameter("id_rol", id_rol)
                    .addParameter("nombre_rol",Rol.getNombre_rol())
                    .addParameter("descripcion_rol", Rol.getDescripcion_rol())
                    .addParameter("permisos", Rol.getPermisos())
                    .executeUpdate();
            return "Rol actualizado";

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar el rol";
        }
    }
    @Override
    public void delete(Integer id_rol){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Rol where id_rol =: id_rol")
                    .addParameter("id_rol", id_rol)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    @Override
    public List<Rol> Show(Integer id_rol){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Rol WHERE id_rol=:id_rol")
                    .addParameter("id_rol", id_rol)
                    .executeAndFetch(Rol.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Rol> getAllRol(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Rol ORDER BY permisos ASC")
                    .executeAndFetch(Rol.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
