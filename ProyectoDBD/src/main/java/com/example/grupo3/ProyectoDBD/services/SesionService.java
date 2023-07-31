package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Rol;
import com.example.grupo3.ProyectoDBD.models.Sesion;
import com.example.grupo3.ProyectoDBD.repositories.RolRepository;
import com.example.grupo3.ProyectoDBD.repositories.SesionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SesionService {
    private final com.example.grupo3.ProyectoDBD.repositories.SesionRepository sesionRepository;

    SesionService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    //Crear
    @PostMapping("/sesion")
    @ResponseBody
    public Sesion create(Sesion sesion) {
        return sesionRepository.create(sesion);
    }
    //All sesions
    @GetMapping("/sesion")
    public List<Sesion> getAllSesions(){
        return sesionRepository.getAll();

    }
   // get by id
    @GetMapping("/sesion/{id_sesion}")
    public List<Sesion> Show(@PathVariable Integer id_sesion){
        return sesionRepository.show(id_sesion);
    }

    // update
    @PutMapping("/sesion/{id_sesion}")
    @ResponseBody
    public String update(@RequestBody Sesion sesion ,@PathVariable Integer id_sesion){
        return sesionRepository.update(sesion, id_sesion);
    }

    //Eliminar
    @DeleteMapping("/sesion/{id_sesion}")
    public void delete(@PathVariable Integer id_sesion){
        sesionRepository.delete(id_sesion);
    }
}
