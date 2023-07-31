package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Categoria_Libro;
import com.example.grupo3.ProyectoDBD.repositories.Categoria_LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Categoria_LibroService {
    private final com.example.grupo3.ProyectoDBD.repositories.Categoria_LibroRepository categoria_libroRepository;

    public Categoria_LibroService(Categoria_LibroRepository categoria_libroRepository) {
        this.categoria_libroRepository = categoria_libroRepository;
    }

    //create
    @PostMapping("/categoria_libro")
    @ResponseBody
    public Categoria_Libro create(@RequestBody Categoria_Libro categoriaLibro) {
        return categoria_libroRepository.create(categoriaLibro);
    }

    // get all
    @GetMapping("/categoria_libro")
    public List<Categoria_Libro> getAllCategorias_Libros() {
        return categoria_libroRepository.getAll();
    }

    //get one (by id)
    @GetMapping("/categoria_libro/{id_categoria}/{id_libro}")
    public List<Categoria_Libro> getCarritoById(@PathVariable Integer id_categoria, @PathVariable Integer id_libro) {
        return categoria_libroRepository.show(id_categoria,id_libro);
    }

    // update
    @PutMapping("/categoria_libro/{id_categoria}/{id_libro}")
    @ResponseBody
    public String updateCarrito(@RequestBody Categoria_Libro categoriaLibro, @PathVariable Integer id_categoria,  @PathVariable Integer id_libro) {
        return categoria_libroRepository.update(categoriaLibro, id_categoria, id_libro);
    }

    // delete
    @DeleteMapping("/categoria_libro/{id_categoria}/{id_libro}")
    public void borrar(@PathVariable Integer id_categoria,  @PathVariable Integer id_libro) {
        categoria_libroRepository.delete(id_categoria, id_libro);
    }
}
