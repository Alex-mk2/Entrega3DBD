package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Boleta;
import com.example.grupo3.ProyectoDBD.repositories.BoletaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BoletaService {
    private final com.example.grupo3.ProyectoDBD.repositories.BoletaRepository boletaRepository;

    BoletaService(BoletaRepository boletaRepository) {
        this.boletaRepository = boletaRepository;
    }

    //create
    @PostMapping("/boleta")
    @ResponseBody
    public Boleta create(@RequestBody Boleta boleta) {
        return boletaRepository.create(boleta);
    }

    // get all
    @GetMapping("/boleta")
    public List<Boleta> getAllBoletas() {
        return boletaRepository.getAll();
    }

    //get one (by id)
    @GetMapping("/boleta/{id_boleta}")
    public List<Boleta> getBoletaById(@PathVariable Integer id_boleta) {
        return boletaRepository.show(id_boleta);
    }

    // update
    @PutMapping("/boleta/{id_boleta}")
    @ResponseBody
    public String updateBoleta(@RequestBody Boleta boleta, @PathVariable Integer id_boleta) {
        return boletaRepository.update(boleta, id_boleta);
    }

    // delete
    @DeleteMapping("/boleta/{id_boleta}")
    public void borrar(@PathVariable Integer id_boleta) {
        boletaRepository.delete(id_boleta);
    }

}
