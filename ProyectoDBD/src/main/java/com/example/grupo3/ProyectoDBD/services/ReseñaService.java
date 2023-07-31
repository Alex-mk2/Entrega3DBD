package com.example.grupo3.ProyectoDBD.services;
import com.example.grupo3.ProyectoDBD.models.Reseña;
import com.example.grupo3.ProyectoDBD.repositories.ReseñaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class ReseñaService {
    private final com.example.grupo3.ProyectoDBD.repositories.ReseñaRepository reseñaRepository;

    ReseñaService(ReseñaRepository reseñaRepository) {
        this.reseñaRepository = reseñaRepository;
    }


    //Crear Reseña//
    @PostMapping("/Reseña/")
    @ResponseBody
    public Reseña create(Reseña Reseña) {
        Reseña newReseña = reseñaRepository.create(Reseña);
        return newReseña;
    }
    //Mostrar todas las reseñas//
    @GetMapping("/Reseña")
    public List<Reseña> getAllReview(){
        return reseñaRepository.getAllReview();

    }
    //Mostrar una reseña//
    @GetMapping("/Reseña/{id_usuario}")
    public List<Reseña> Show(@PathVariable Integer id_usuario){
        return reseñaRepository.Show(id_usuario);
    }
    @PutMapping("/Reseña/{id_usuario}")
    @ResponseBody

    //Actualizar Reseña//
    public String update(@RequestBody Reseña Reseña ,@PathVariable Integer id_usuario){
        String newReseña = reseñaRepository.update(Reseña, id_usuario);
        return newReseña;
    }

    //Eliminar Reseña//
    @DeleteMapping("/Reseña/{id_usuario}")
    public void delete(@PathVariable Integer id_usuario){
        reseñaRepository.delete(id_usuario);
    }
}
