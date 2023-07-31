package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Usuario_Libro;
import com.example.grupo3.ProyectoDBD.repositories.Usuario_LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Usuario_LibroService {
    private final com.example.grupo3.ProyectoDBD.repositories.Usuario_LibroRepository usuarioLibroRepository;

    public Usuario_LibroService(Usuario_LibroRepository usuarioLibroRepository) {
        this.usuarioLibroRepository = usuarioLibroRepository;
    }

    //create
    @PostMapping("/Usuario_libro")
    @ResponseBody
    public Usuario_Libro create(@RequestBody Usuario_Libro usuarioLibro) {
        return usuarioLibroRepository.create(usuarioLibro);
    }

    // get all
    @GetMapping("/usuario_libro")
    public List<Usuario_Libro> getAllUsuarios_Libros() {
        return usuarioLibroRepository.getAll();
    }

    //get one (by id)
    @GetMapping("/usuario_libro/{id_usuario}/{id_libro}")
    public List<Usuario_Libro> getCarritoById(@PathVariable Integer id_usuario, @PathVariable Integer id_libro) {
        return usuarioLibroRepository.show(id_usuario,id_libro);
    }

    // update
    @PutMapping("/usuario_libro/{id_usuario}/{id_libro}")
    @ResponseBody
    public String updateUsuarioLibro(@RequestBody Usuario_Libro usuarioLibro, @PathVariable Integer id_usuario,  @PathVariable Integer id_libro) {
        return usuarioLibroRepository.update(usuarioLibro, id_usuario, id_libro);
    }

    // delete
    @DeleteMapping("/usuario_libro/{id_usuario}/{id_libro}")
    public void borrar(@PathVariable Integer id_usuario,  @PathVariable Integer id_libro) {
        usuarioLibroRepository.delete(id_usuario, id_libro);
    }
}

