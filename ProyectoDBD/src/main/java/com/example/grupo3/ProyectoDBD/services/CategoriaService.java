package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Categoria;
import com.example.grupo3.ProyectoDBD.repositories.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CategoriaService {
    private final com.example.grupo3.ProyectoDBD.repositories.CategoriaRepository categoriaRepository;

    CategoriaService(CategoriaRepository carritoCompraRepository) {
        this.categoriaRepository = carritoCompraRepository;
    }

    //create
    @PostMapping("/categoria")
    @ResponseBody
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaRepository.create(categoria);
    }

    // get all
    @GetMapping("/categoria")
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.getAll();
    }

    //get one (by id)
    @GetMapping("/categoria/{id_categoria}")
    public List<Categoria> getCategoriaById(@PathVariable Integer id_categoria) {
        return categoriaRepository.show(id_categoria);
    }

    // update
    @PutMapping("/categoria/{id_categoria}")
    @ResponseBody
    public String updateCarrito(@RequestBody Categoria categoria, @PathVariable Integer id_categoria) {
        return categoriaRepository.update(categoria, id_categoria);
    }

    // delete
    @DeleteMapping("/categoria/{id_categoria}")
    public void borrar(@PathVariable Integer id_categoria) {
        categoriaRepository.delete(id_categoria);
    }
}
