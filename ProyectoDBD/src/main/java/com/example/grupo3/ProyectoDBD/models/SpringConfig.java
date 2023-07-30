package com.example.grupo3.ProyectoDBD.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class SpringConfig {

    @Bean
    public Sql2o sql2o() {
        // Reemplaza los valores de URL, usuario y contraseña con los de tu base de datos
        return new Sql2o("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
    }
}
