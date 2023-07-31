package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Libro;
import com.example.grupo3.ProyectoDBD.repositories.LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class LibroService {
    private final com.example.grupo3.ProyectoDBD.repositories.LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    //create
    @PostMapping("/libro")
    @ResponseBody
    public Libro create(@RequestBody Libro libro) {
        return libroRepository.create(libro);
    }

    // get all
    @GetMapping("/libro")
    public List<Libro> getAllLibros() {
        return libroRepository.getAll();
    }

    //get one (by id)
    @GetMapping("/libro/{id_libro}")
    public List<Libro> getLibroById(@PathVariable Integer id_libro) {
        return libroRepository.show(id_libro);
    }

    // update
    @PutMapping("/libro/{id_libro}")
    @ResponseBody
    public String updateLibro(@RequestBody Libro libro, @PathVariable Integer id_libro) {
        return libroRepository.update(libro, id_libro);
    }

    // delete
    @DeleteMapping("/libro/{id_libro}")
    public void borrar(@PathVariable Integer id_libro) {
        libroRepository.delete(id_libro);
    }
}
