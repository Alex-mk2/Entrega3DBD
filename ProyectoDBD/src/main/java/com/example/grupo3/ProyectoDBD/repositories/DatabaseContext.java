package com.example.grupo3.ProyectoDBD.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {
<<<<<<< HEAD
    @Value("jdbc:postgresql://localhost:5432/sistema_libro_spring")
    private String dbUrl;

    @Value("postgres")
    private String dbUser;

    @Value("Moises17g")
=======
    @Value("${jdbc:postgresql://localhost:5432/DEBEDE}")
    private String dbUrl;

    @Value("${database.user}")
    private String dbUser;

    @Value("${database.password}")
>>>>>>> 64a479c2a1ab1f7b6caf1379155992b3afadf65d
    private String dbPass;

    @Bean
    public Sql2o sql2o(){
        return new Sql2o(dbUrl,dbUser,dbPass);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 64a479c2a1ab1f7b6caf1379155992b3afadf65d
