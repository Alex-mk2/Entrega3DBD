package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.CarritoCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CarritoCompraRepositoryImp implements CarritoCompraRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public CarritoCompra create(CarritoCompra carritoCompra) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO CarritoCompra (id_carrito, fecha_creacion, id_metodo_pago, id_usuario)" +
                    "VALUES (:id_carrito, :fecha_creacion, :id_metodo_pago, :id_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("id_carrito", carritoCompra.getId_carrito())
                    .addParameter("fecha_creacion", carritoCompra.getFecha_creacion())
                    .addParameter("id_metodo_pago", carritoCompra.getId_metodo_pago())
                    .addParameter("id_usuario", carritoCompra.getId_usuario())
                    .executeUpdate();
            return carritoCompra;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<CarritoCompra> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELEC * FROM CarritoCompra ORDER BY fecha_creacion ASC")
                    .executeAndFetch(CarritoCompra.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<CarritoCompra> show(Integer id_carrito) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM CarritoCompra WHERE id_carrito = :id_carrito")
                    .addParameter("id_carrito", id_carrito)
                    .executeAndFetch(CarritoCompra.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(CarritoCompra carritoCompra, Integer id_carrito) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE CarritoCompra " +
                            "SET fecha_creacion=:fecha_creacion, id_metodo_pago=:id_metodo_pago, id_usuario=:id_usuario " +
                            "WHERE id_carrito=:id_carrito")
                    .addParameter("id_carrito", id_carrito)
                    .addParameter("fecha_creacion", carritoCompra.getFecha_creacion())
                    .addParameter("id_metodo_pago", carritoCompra.getId_metodo_pago())
                    .addParameter("id_usuario", carritoCompra.getId_usuario())
                    .executeUpdate();
            return "Carrito actualizado";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: No se pudo actualizar el carrito";
        }
    }

    @Override
    public void delete(Integer id_carrito) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM CarritoCompra WHERE id_carrito = :id_carrito")
                    .addParameter("id_carrito", id_carrito)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
