package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Usuario;
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
}
