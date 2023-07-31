package com.example.grupo3.ProyectoDBD.services;
import com.example.grupo3.ProyectoDBD.models.Restriccion;
import com.example.grupo3.ProyectoDBD.repositories.RestriccionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class RestriccionService{

    private final com.example.grupo3.ProyectoDBD.repositories.RestriccionRepository restriccionRepository;

    RestriccionService(RestriccionRepository restriccionRepository) {
        this.restriccionRepository = restriccionRepository;
    }

    //Crear Restriccion//
    @PostMapping("/Restriccion/")
    @ResponseBody
    public Restriccion create(Restriccion Restriccion) {
        Restriccion newRestriccion = restriccionRepository.create(Restriccion);
        return newRestriccion;
    }
    //Mostrar todas las restricciones//
    @GetMapping("/Restricciones")
    public List<Restriccion> getAllReview(){
        return restriccionRepository.getAllRestiction();

    }
    //Mostrar una restriccion//
    @GetMapping("/Restriccion/{id_restriccion}")
    public List<Restriccion> Show(@PathVariable Integer id_restriccion){
        return restriccionRepository.Show(id_restriccion);
    }
    @PutMapping("/Restriccion/{id_restriccion}")
    @ResponseBody

    //Actualizar Restriccion//
    public String update(@RequestBody Restriccion Restriccion ,@PathVariable Integer id_restriccion){
        String newRestriccion = restriccionRepository.update(Restriccion, id_restriccion);
        return newRestriccion;
    }

    //Eliminar Restriccion//
    @DeleteMapping("/Restriccion/{id_restriccion}")
    public void delete(@PathVariable Integer id_restriccion){
        restriccionRepository.delete(id_restriccion);
    }
}
