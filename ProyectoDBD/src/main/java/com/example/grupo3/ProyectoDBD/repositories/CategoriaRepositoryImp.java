package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CategoriaRepositoryImp implements CategoriaRepository {
    @Autowired
    Sql2o sql2o;

    @Override
    public Categoria create(Categoria categoria) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Categoria (id_categoria,nombre_categoria,descripcion_categoria)" +
                    "VALUES (:id_categoria, :nombre_categoria, :descripcion_categoria)";
            conn.createQuery(sql, true)
                    .addParameter("id_categoria", categoria.getId_categoria())
                    .addParameter("nombre_categoria", categoria.getNombre_categoria())
                    .addParameter("descripcion_categoria", categoria.getDescripcion_categoria())
                    .executeUpdate();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Categoria> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Categoria ORDER BY nombre_categoria ASC")
                    .executeAndFetch(Categoria.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Categoria> show(Integer id_categoria) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Categoria WHERE id_categoria = :id_categoria")
                    .addParameter("id_categoria", id_categoria)
                    .executeAndFetch(Categoria.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Categoria categoria, Integer id_categoria) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Categoria " +
                            "SET nombre_categoria=:nombre_categoria, descripcion_categoria=:descripcion_categoria " +
                            "WHERE id_categoria=:id_categoria")
                    .addParameter("id_categoria", id_categoria)
                    .addParameter("nombre_categoria", categoria.getNombre_categoria())
                    .addParameter("descripcion_categoria", categoria.getDescripcion_categoria())
                    .executeUpdate();
            return "Categoria actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: No se pudo actualizar la categoria";
        }
    }

    @Override
    public void delete(Integer id_categoria) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Categoria WHERE id_categoria = :id_categoria")
                    .addParameter("id_categoria", id_categoria)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
