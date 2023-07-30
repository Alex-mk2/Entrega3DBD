package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Reseña;
import com.example.grupo3.ProyectoDBD.repositories.ReseñaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ReseñaService{
    private final com.example.grupo3.ProyectoDBD.repositories.ReseñaRepository reseñaRepository;
    ReseñaService(ReseñaRepository reseñaRepository) {
        this.reseñaRepository = reseñaRepository;
    }


    //Crear Reseña//
    @PostMapping("/Reseña/")
    @ResponseBody
    public Reseña create(Reseña Reseña){
        Reseña newReseña = reseñaRepository.create(Reseña);
        return newReseña;
    }

}
