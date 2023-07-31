package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Metodo_Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class MetodoPagoRepositoryImp implements MetodoPagoRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Metodo_Pago create(Metodo_Pago MetodoPago) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO metodo_pago (id_metodo_pago, tipo_pago)" +
                    "VALUES (:id_metodo_pago, :tipo_pago)";
            conn.createQuery(sql, true)
                    .addParameter("id_metodo_pago", MetodoPago.getId_metodo_pago())
                    .addParameter("tipo_pago", MetodoPago.getTipo_pago())
                    .executeUpdate();
            return MetodoPago;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Metodo_Pago> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM metodo_pago ORDER BY tipo_pago ASC")
                    .executeAndFetch(Metodo_Pago.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Metodo_Pago> show(Integer id_metodo_pago) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM metodo_pago WHERE id_metodo_pago = :id_metodo_pago";
            List<Metodo_Pago> result = conn.createQuery(sql)
                    .addParameter("id_metodo_pago", id_metodo_pago)
                    .executeAndFetch(Metodo_Pago.class);
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Metodo_Pago metodoPago, Integer id_metodoPago) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE metodo_pago SET tipo_pago = :tipo_pago WHERE id_metodo_pago = :id_metodo_pago";
            conn.createQuery(sql)
                    .addParameter("tipo_pago", metodoPago.getTipo_pago())
                    .addParameter("id_metodo_pago", id_metodoPago)
                    .executeUpdate();
            return "Metodo de pago actualizado";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error al actualizar el registro";
        }
    }

    @Override
    public void delete(Integer id_metodoPago) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM metodo_pago WHERE id_metodo_pago = :id_metodo_pago";
            conn.createQuery(sql)
                    .addParameter("id_metodo_pago", id_metodoPago)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
