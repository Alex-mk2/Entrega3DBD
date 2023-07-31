package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Restriccion_Ubicacion;
import com.example.grupo3.ProyectoDBD.repositories.Restriccion_UbicacionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Restriccion_UbicacionService {
    private final com.example.grupo3.ProyectoDBD.repositories.Restriccion_UbicacionRepository restriccionUbicacionRepository;

    public Restriccion_UbicacionService(Restriccion_UbicacionRepository restriccionUbicacionRepository) {
        this.restriccionUbicacionRepository = restriccionUbicacionRepository;
    }

    //create
    @PostMapping("/Restriccion_ubicacion")
    @ResponseBody
    public Restriccion_Ubicacion create(@RequestBody Restriccion_Ubicacion restriccionUbicacion) {
        return restriccionUbicacionRepository.create(restriccionUbicacion);
    }

    // get all
    @GetMapping("/restriccion_ubicacion")
    public List<Restriccion_Ubicacion> getAllRestricciones_Ubicaciones() {
        return restriccionUbicacionRepository.getAll();
    }

    //get one (by id)
    @GetMapping("/restriccion_Ubicacion/{id_restriccion}/{id_ubicacion}")
    public List<Restriccion_Ubicacion> getCarritoById(@PathVariable Integer id_restriccion, @PathVariable Integer id_ubicacion) {
        return restriccionUbicacionRepository.show(id_restriccion,id_ubicacion);
    }

    // update
    @PutMapping("/restriccion_ubicacion/{id_restriccion}/{id_ubicacion}")
    @ResponseBody
    public String updateCarrito(@RequestBody Restriccion_Ubicacion restriccionUbicacion, @PathVariable Integer id_restriccion,  @PathVariable Integer id_ubicacion) {
        return restriccionUbicacionRepository.update(restriccionUbicacion, id_restriccion, id_restriccion);
    }

    // delete
    @DeleteMapping("/restriccion_ubicacion/{id_restriccion}/{id_ubicacion}")
    public void borrar(@PathVariable Integer id_restriccion,  @PathVariable Integer id_ubicacion) {
        restriccionUbicacionRepository.delete(id_restriccion, id_ubicacion);
    }
}

