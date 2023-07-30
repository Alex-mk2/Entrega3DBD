package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Boleta;
import com.example.grupo3.ProyectoDBD.repositories.BoletaRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class BoletaService {
    private  final BoletaRepository boletaRepository;

    BoletaService(BoletaRepository boletaRepository){this.boletaRepository = boletaRepository;}

    //create
    @PostMapping("/boleta")
    @ResponseBody
    public Boleta create(@RequestBody Boleta boleta){
        return boletaRepository.create(boleta);
    }
}
