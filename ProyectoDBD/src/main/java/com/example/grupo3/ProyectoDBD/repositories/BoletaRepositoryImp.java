package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Boleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class BoletaRepositoryImp implements BoletaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Boleta create(Boleta boleta) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Boleta (id_boleta,fecha_pago,resumen_compra,total_pagado,id_carrito,id_usuario)" +
                    "VALUES (:id_boleta, :fecha_pago, :resumen_compra, :total_pagado, :id_carrito, :id_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("id_boleta", boleta.getId_boleta())
                    .addParameter("fecha_pago", boleta.getFecha_pago())
                    .addParameter("resumen_compra", boleta.getResumen_compra())
                    .addParameter("total_pagado", boleta.getTotal_pagado())
                    .addParameter("id_carrito", boleta.getId_carrito())
                    .addParameter("id_usuario", boleta.getId_usuario())
                    .executeUpdate();
            return boleta;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Boleta> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Boleta ORDER BY fecha_pago ASC")
                    .executeAndFetch(Boleta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Boleta> show(Integer id_boleta) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Boleta WHERE id_boleta = :id_boleta")
                    .addParameter("id_boleta", id_boleta)
                    .executeAndFetch(Boleta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Boleta boleta, Integer id_boleta) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Boleta " +
                            "SET fecha_pago=:fecha_pago, resumen_compra=:resumen_compra, total_pagado=:total_pagado, id_carrito=:id_carrito, id_usuario=:id_usuario " +
                            "WHERE id_boleta=:id_boleta")
                    .addParameter("id_boleta", id_boleta)
                    .addParameter("fecha_pago", boleta.getFecha_pago())
                    .addParameter("resumen_compra", boleta.getResumen_compra())
                    .addParameter("total_pagado", boleta.getTotal_pagado())
                    .addParameter("id_carrito", boleta.getId_carrito())
                    .addParameter("id_usuario", boleta.getId_usuario())
                    .executeUpdate();
            return "Boleta actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: No se pudo actualizar la boleta";
        }
    }

    @Override
    public void delete(Integer id_boleta) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Boleta WHERE id_boleta = :id_boleta")
                    .addParameter("id_boleta", id_boleta)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
