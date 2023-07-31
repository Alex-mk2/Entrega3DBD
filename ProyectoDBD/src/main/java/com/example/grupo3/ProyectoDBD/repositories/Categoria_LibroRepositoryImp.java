package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Boleta;
import com.example.grupo3.ProyectoDBD.models.Categoria;
import com.example.grupo3.ProyectoDBD.models.Categoria_Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Categoria_LibroRepositoryImp implements Categoria_LibroRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Categoria_Libro create(Categoria_Libro categoriaLibro) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Categoria_Libro (id_categoria,id_libro)" +
                    "VALUES (:id_categoria,:id_libro)";
            conn.createQuery(sql, true)
                    .addParameter("id_categoria", categoriaLibro.getId_categoria())
                    .addParameter("id_libro", categoriaLibro.getId_libro())
                    .executeUpdate();
            return categoriaLibro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Categoria_Libro> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Categoria_Libro")
                    .executeAndFetch(Categoria_Libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Categoria_Libro> show(Integer id_categoria, Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Categoria_Libro WHERE id_categoria=:id_categoria AND  id_libro=:id_libro")
                    .addParameter("id_categoria", id_categoria)
                    .addParameter("id_libro", id_libro)
                    .executeAndFetch(Categoria_Libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Categoria_Libro categoriaLibro, Integer id_categoria, Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Categoria_Libro " +
                            "SET id_categoria=:nuevo_id_categoria, id_libro=:nuevo_id_libro " +
                            "WHERE id_categoria=:id_categoria AND id_libro=:id_libro")
                    .addParameter("id_categoria", id_categoria)
                    .addParameter("id_libro", id_libro)
                    .addParameter("nuevo_id_categoria", categoriaLibro.getId_categoria())
                    .addParameter("nuevo_id_libro", categoriaLibro.getId_libro())
                    .executeUpdate();
            return "Tupla Categoria_Libro actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: No se pudo actualizar Categoria_Libro";
        }
    }

    @Override
    public void delete(Integer id_categoria, Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Categoria_Libro WHERE id_categoria=:id_categoria AND id_libro=:id_libro")
                    .addParameter("id_categoria", id_categoria)
                    .addParameter("id_libro", id_libro)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
