package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Usuario_Libro;
import com.example.grupo3.ProyectoDBD.models.Usuario_Rol;
import com.example.grupo3.ProyectoDBD.repositories.Usuario_RolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Usuario_RolService {
    private final com.example.grupo3.ProyectoDBD.repositories.Usuario_RolRepository usuarioRolpository;

    public Usuario_RolService(Usuario_RolRepository usuarioRolpository) {
        this.usuarioRolpository = usuarioRolpository;
    }

    //create
    @PostMapping("/Usuario_Rol")
    @ResponseBody
    public Usuario_Rol create(@RequestBody Usuario_Rol usuarioRol) {
        return usuarioRolpository.create(usuarioRol);
    }

    // get all
    @GetMapping("/usuario_rol")
    public List<Usuario_Rol> getAllUsuarios_Roles() {
        return usuarioRolpository.getAll();
    }

    //get one (by id)
    @GetMapping("/usuario_rol/{id_usuario}/{id_rol}")
    public List<Usuario_Rol> getCarritoById(@PathVariable Integer id_usuario, @PathVariable Integer id_rol) {
        return usuarioRolpository.show(id_usuario,id_rol);
    }

    // update
    @PutMapping("/usuario_rol/{id_usuario}/{id_rol}")
    @ResponseBody
    public String updateUsuarioLibro(@RequestBody Usuario_Rol usuarioRol, @PathVariable Integer id_usuario,  @PathVariable Integer id_rol) {
        return usuarioRolpository.update(usuarioRol, id_usuario, id_rol);
    }

    // delete
    @DeleteMapping("/usuario_rol/{id_usuario}/{id_rol}")
    public void borrar(@PathVariable Integer id_usuario,  @PathVariable Integer id_rol) {
        usuarioRolpository.delete(id_usuario, id_rol);
    }
}


