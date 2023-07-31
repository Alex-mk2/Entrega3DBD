package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Ubicacion;
import com.example.grupo3.ProyectoDBD.models.Usuario;
import com.example.grupo3.ProyectoDBD.models.Usuario_Rol;
import com.example.grupo3.ProyectoDBD.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
public class UsuarioService {
    private final com.example.grupo3.ProyectoDBD.repositories.UsuarioRepository usuarioRepository;

    UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;}

    @PostMapping("/usuario")
    @ResponseBody
    public Usuario crear(@RequestBody Usuario usuario){
        Usuario resultado = usuarioRepository.create(usuario);
        return resultado;
    }

    @GetMapping("/usuario")
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.getAll();
    }

    @GetMapping("/usuario/{id_usuario}")
    public List<Usuario> getCarritoById(@PathVariable Integer id_usuario) {
        return usuarioRepository.show(id_usuario);
    }

    @PutMapping("/usuario/{id_usuario}/{id_ubicacion}")
    @ResponseBody
    public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable Integer id_usuario,@PathVariable Integer id_ubicacion) {
        return usuarioRepository.update(usuario, id_usuario, id_ubicacion);
    }

    @GetMapping("/usuario/{id_usuario}")
    public List<Usuario> login(@PathVariable String correo, @PathVariable String contrasena) {
        return usuarioRepository.login(correo, contrasena);
    }
}
