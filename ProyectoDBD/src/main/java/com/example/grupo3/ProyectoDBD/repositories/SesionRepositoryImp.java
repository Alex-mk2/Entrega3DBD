
package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Sesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class SesionRepositoryImp implements SesionRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Sesion create(Sesion Sesion) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Sesion (id_sesion,id_usuario,inicio_sesion,fin_sesion)" +
                    "VALUES (:id_sesion,:id_usuario,:inicio_sesion,:fin_sesion)";
            conn.createQuery(sql, true)
                    .addParameter("id_sesion", Sesion.getId_sesion())
                    .addParameter("id_usuario", Sesion.getId_usuario())
                    .addParameter("inicio_sesion", Sesion.getInicio_sesion())
                    .addParameter("fin_sesion", Sesion.getFin_sesion())
                    .executeUpdate();
            return Sesion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Sesion Sesion, int id_sesion){
        try(Connection conn = sql2o.open()){
            String update = "UPDATE Sesion set id_sesion=:id_sesion, id_usuario=:id_usuario, inicio_sesion=:inicio_sesion, fin_sesion=:fin_sesion WHERE id_sesion:=id_sesion";
            conn.createQuery(update)
                    .addParameter("id_sesion",id_sesion)
                    .addParameter("id_usuario",Sesion.getId_usuario())
                    .addParameter("inicio_sesion",Sesion.getInicio_sesion())
                    .addParameter("fin_sesion",Sesion.getFin_sesion())
                    .executeUpdate();
            return "Sesion actualizada";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar la sesion";
        }
    }

    @Override
    public List<Sesion> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Sesion order by id_sesion ASC")
                    .executeAndFetch(Sesion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Sesion> show(int id_sesion){
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Sesion WHERE id_sesion:=id_sesion")
                    .addParameter("id_sesion", id_sesion)
                    .executeAndFetch(Sesion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id_sesion){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Sesion WHERE id_sesion=:id_sesion")
                    .addParameter("id_sesion",id_sesion)
                    .executeAndFetch(Sesion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

