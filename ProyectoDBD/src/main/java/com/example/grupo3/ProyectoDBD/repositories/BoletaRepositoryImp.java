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
    public Boleta create(Boleta newBoleta) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Boleta (id_boleta,fecha_pago,resumen_compra,total_pagado,id_carro,id_usuario)" +
                    "VALUES (:id_boleta, :fecha_pago, :resumen_compra, :total_pagado, :id_carro, ;id_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("id_boleta", newBoleta.getId_boleta())
                    .addParameter("fecha_pago", newBoleta.getFecha_pago())
                    .addParameter("resumen_compra", newBoleta.getResumen_compra())
                    .addParameter("total_pagado", newBoleta.getTotal_pagado())
                    .addParameter("id_carro", newBoleta.getId_carro())
                    .addParameter("id_usuario", newBoleta.getId_usuario())
                    .executeUpdate();
            return newBoleta;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


}
