package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Categoria_Libro;
import com.example.grupo3.ProyectoDBD.models.Libro_Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Libro_CarritoRepositoryImp implements Libro_CarritoRepository{
    @Autowired
    private Sql2o sql2o;


    @Override
    public Libro_Carrito create(Libro_Carrito libroCarrito) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Libro_Carrito (id_libro, id_carrito)" +
                    "VALUES (:id_libro, :id_carrito)";
            conn.createQuery(sql, true)
                    .addParameter("id_libro", libroCarrito.getId_libro())
                    .addParameter("id_carrito", libroCarrito.getId_carrito())
                    .executeUpdate();
            return libroCarrito;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Libro_Carrito> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Libro_Carrito")
                    .executeAndFetch(Libro_Carrito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Libro_Carrito> show(Integer id_libro, Integer id_carrito) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Libro_Carrito WHERE id_carrito=:id_carrito AND  id_libro=:id_libro")
                    .addParameter("id_carrito", id_carrito)
                    .addParameter("id_libro", id_libro)
                    .executeAndFetch(Libro_Carrito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Libro_Carrito libroCarrito, Integer id_libro, Integer id_carrito) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Libro_Carrito " +
                            "SET id_carrito=:nuevo_id_carrito, id_libro=:nuevo_id_libro " +
                            "WHERE id_carrito=:id_categoria AND id_libro=:id_libro")
                    .addParameter("id_carrito", id_carrito)
                    .addParameter("id_libro", id_libro)
                    .addParameter("nuevo_id_carrito", libroCarrito.getId_carrito())
                    .addParameter("nuevo_id_libro", libroCarrito.getId_libro())
                    .executeUpdate();
            return "Tupla Libro_Carrito actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: No se pudo actualizar Libro_Carrito";
        }
    }

    @Override
    public void delete(Integer id_libro, Integer id_carrito) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Libro_Carrito WHERE id_carrito=:id_categoria AND id_libro=:id_libro")
                    .addParameter("id_carrito", id_carrito)
                    .addParameter("id_libro", id_libro)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
