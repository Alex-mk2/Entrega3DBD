package com.example.grupo3.ProyectoDBD.services;
import com.example.grupo3.ProyectoDBD.models.Resena;
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
    @PostMapping("/reseña")
    @ResponseBody
    public Resena create(Resena Resena) {
        Resena newResena = reseñaRepository.create(Resena);
        return newResena;
    }
    //Mostrar todas las reseñas//
    @GetMapping("/reseña")
    public List<Resena> getAllReview(){
        return reseñaRepository.getAllReview();

    }
    //Mostrar una reseña//
    @GetMapping("/reseña/{id_usuario}")
    public List<Resena> Show(@PathVariable Integer id_usuario){
        return reseñaRepository.Show(id_usuario);
    }
    @PutMapping("/reseña/{id_usuario}")
    @ResponseBody

    //Actualizar Reseña//
    public String update(@RequestBody Resena Resena, @PathVariable Integer id_usuario){
        String newReseña = reseñaRepository.update(Resena, id_usuario);
        return newReseña;
    }

    //Eliminar Reseña//
    @DeleteMapping("/reseña/{id_usuario}")
    public void delete(@PathVariable Integer id_usuario){
        reseñaRepository.delete(id_usuario);
    }
}
