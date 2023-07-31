package com.example.grupo3.ProyectoDBD.services;
import com.example.grupo3.ProyectoDBD.models.Rol;
import com.example.grupo3.ProyectoDBD.repositories.RolRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class RolService{
    private final com.example.grupo3.ProyectoDBD.repositories.RolRepository rolRepository;

    RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    //Crear Rol//
    @PostMapping("/rol")
    @ResponseBody
    public Rol create(Rol Rol) {
        Rol newRol = rolRepository.create(Rol);
        return newRol;
    }
    //Mostrar todos los roles//
    @GetMapping("/rol")
    public List<Rol> getAllRol(){
        return rolRepository.getAllRol();

    }
    //Mostrar un rol//
    @GetMapping("/rol/{id_rol}")
    public List<Rol> Show(@PathVariable int id_rol){
        return rolRepository.Show(id_rol);
    }

    //Actualizar Rol//
    @PutMapping("/rol/{id_rol}")
    @ResponseBody
    public String update(@RequestBody Rol Rol ,@PathVariable int id_rol){
        String newRol = rolRepository.update(Rol, id_rol);
        return newRol;
    }

    //Eliminar Rol//
    @DeleteMapping("/rol/{id_rol}")
    public void borrar(@PathVariable Integer id_rol){
        rolRepository.delete(id_rol);
    }
}
