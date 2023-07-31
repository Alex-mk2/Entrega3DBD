package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Boleta;
import com.example.grupo3.ProyectoDBD.models.Ubicacion;
import com.example.grupo3.ProyectoDBD.repositories.UbicacionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
public class UbicacionService {
    private final com.example.grupo3.ProyectoDBD.repositories.UbicacionRepository ubicacionRepository;

    UbicacionService(UbicacionRepository ubicacionRepository){
        this.ubicacionRepository = ubicacionRepository;}

    @PostMapping("/ubicacion")
    @ResponseBody
    public Ubicacion crear(@RequestBody Ubicacion usuario){
        Ubicacion resultado = ubicacionRepository.create(usuario);
        return resultado;
    }

    @GetMapping("/ubicacion")
    public List<Ubicacion> getAllUsuarios(){
        return ubicacionRepository.getAll();
    }
    @PutMapping("/ubicacion/{id_ubicacion}")
    @ResponseBody
    public Ubicacion updateUbicacion(@RequestBody Ubicacion ubicacion, @PathVariable Integer id_ubicacion) {
        return ubicacionRepository.update(ubicacion, id_ubicacion);
    }
}
