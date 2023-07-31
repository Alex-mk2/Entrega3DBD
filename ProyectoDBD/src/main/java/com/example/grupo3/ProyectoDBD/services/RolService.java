package com.example.grupo3.ProyectoDBD.services;
import com.example.grupo3.ProyectoDBD.models.Rol;
import com.example.grupo3.ProyectoDBD.repositories.RolRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class RolService{
    private final com.example.grupo3.ProyectoDBD.repositories.RolRepository rolRepository;

    RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    //Crear Rol//
    @PostMapping("/Rol/")
    @ResponseBody
    public Rol create(Rol Rol) {
        Rol newRol = rolRepository.create(Rol);
        return newRol;
    }
    //Mostrar todos los roles//
    @GetMapping("/Rol")
    public List<Rol> getAllRol(){
        return rolRepository.getAllRol();

    }
    //Mostrar un rol//
    @GetMapping("/Rol/{id_rol}")
    public List<Rol> Show(@PathVariable Integer id_rol){
        return rolRepository.Show(id_rol);
    }
    @PutMapping("/Rol/{id_rol}")
    @ResponseBody

    //Actualizar Rol//
    public String update(@RequestBody Rol Rol ,@PathVariable Integer id_rol){
        String newRol = rolRepository.update(Rol, id_rol);
        return newRol;
    }

    //Eliminar Restriccion//
    @DeleteMapping("/Reseña/{id_restriccion}")
    public void delete(@PathVariable Integer id_restriccion){
        rolRepository.delete(id_restriccion);
    }
}
