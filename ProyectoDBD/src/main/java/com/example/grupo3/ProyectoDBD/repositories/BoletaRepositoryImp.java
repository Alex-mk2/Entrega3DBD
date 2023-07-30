package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Boleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class BoletaRepositoryImp implements BoletaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Boleta create(Boleta Boleta) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Boleta (id_boleta,fecha_pago,resumen_compra,total_pagado,id_carrito,id_usuario)" +
                    "VALUES (:id_boleta, :fecha_pago, :resumen_compra, :total_pagado, :id_carrito, :id_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("id_boleta", Boleta.getId_boleta())
                    .addParameter("fecha_pago", Boleta.getFecha_pago())
                    .addParameter("resumen_compra", Boleta.getResumen_compra())
                    .addParameter("total_pagado", Boleta.getTotal_pagado())
                    .addParameter("id_carrito", Boleta.getId_carrito())
                    .addParameter("id_usuario", Boleta.getId_usuario())
                    .executeUpdate();
                    return Boleta;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
