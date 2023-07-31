package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Libro;
import com.example.grupo3.ProyectoDBD.models.Libro_Carrito;
import com.example.grupo3.ProyectoDBD.models.Lista_Favoritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Lista_FavoritosRespositoryImp implements Lista_FavoritosRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Lista_Favoritos create(Lista_Favoritos listaFavoritos) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Lista_Favoritos (id_usuario, id_libro)" +
                    "VALUES (:id_usuario, :id_libro)";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", listaFavoritos.getId_usuario())
                    .addParameter("id_libro", listaFavoritos.getId_libro())
                    .executeUpdate();
            return listaFavoritos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Lista_Favoritos> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Lista_Favoritos")
                    .executeAndFetch(Lista_Favoritos.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Lista_Favoritos> show(Integer id_usuario, Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Lista_Favoritos WHERE id_usuario=:id_usuario AND  id_libro=:id_libro")
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_libro", id_libro)
                    .executeAndFetch(Lista_Favoritos.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Lista_Favoritos listaFavoritos, Integer id_usuario, Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Lista_Favoritos " +
                            "SET id_usuario=:nuevo_id_usuario, id_libro=:nuevo_id_libro " +
                            "WHERE id_usuario=:id_usuario AND id_libro=:id_libro")
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_libro", id_libro)
                    .addParameter("nuevo_id_usuario", listaFavoritos.getId_usuario())
                    .addParameter("nuevo_id_libro", listaFavoritos.getId_libro())
                    .executeUpdate();
            return "Tupla Lista_Favoritos actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: No se pudo actualizar Lista_Favoritos";
        }
    }

    @Override
    public void delete(Integer id_usuario, Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Lista_Favoritos WHERE id_usuario=:id_usuario AND id_libro=:id_libro")
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_libro", id_libro)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
