package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Boleta;
import com.example.grupo3.ProyectoDBD.models.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class LibroRepositoryImp implements LibroRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Libro create(Libro libro) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Libro (id_libro, autor, titulo, precio, stock, visitas, favoritos, id_usuario)" +
                    "VALUES (:id_libro, :autor, :titulo, :precio, :stock, :visitas, :favoritos, :id_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("id_libro", libro.getId_libro())
                    .addParameter("autor", libro.getAutor())
                    .addParameter("titulo", libro.getTitulo())
                    .addParameter("precio", libro.getPrecio())
                    .addParameter("stock", libro.getStock())
                    .addParameter("visitas", libro.getVisitas())
                    .addParameter("favoritos", libro.getFavoritos())
                    .addParameter("id_usuario", libro.getId_usuario())
                    .executeUpdate();
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Libro> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Libro ORDER BY titulo ASC")
                    .executeAndFetch(Libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Libro> show(Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Libro WHERE id_libro = :id_libro")
                    .addParameter("id_libro", id_libro)
                    .executeAndFetch(Libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Libro libro, Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Libro " +
                            "SET autor=:autor, titulo=:titulo, precio=:precio, stock=:stock, visitas=:visitas, favoritos=:favoritos, id_usuario=:id_usuario " +
                            "WHERE id_libro=:id_libro")
                    .addParameter("id_libro", id_libro)
                    .addParameter("autor", libro.getAutor())
                    .addParameter("titulo", libro.getTitulo())
                    .addParameter("precio", libro.getPrecio())
                    .addParameter("stock", libro.getStock())
                    .addParameter("visitas", libro.getVisitas())
                    .addParameter("favoritos", libro.getFavoritos())
                    .addParameter("id_usuario", libro.getId_usuario())
                    .executeUpdate();
            return "Libro actualizado";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: No se pudo actualizar el libro";
        }
    }

    @Override
    public void delete(Integer id_libro) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Libro WHERE id_libro = :id_libro")
                    .addParameter("id_libro", id_libro)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}