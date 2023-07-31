package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Categoria_Libro;
import com.example.grupo3.ProyectoDBD.models.Libro_Carrito;
import com.example.grupo3.ProyectoDBD.repositories.Libro_CarritoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Libro_CarritoService {
    private final  com.example.grupo3.ProyectoDBD.repositories.Libro_CarritoRepository libroCarritoRepository;

    public Libro_CarritoService(Libro_CarritoRepository libroCarritoRepository) {
        this.libroCarritoRepository = libroCarritoRepository;
    }

    //create
    @PostMapping("/libro_carrito")
    @ResponseBody
    public Libro_Carrito create(@RequestBody Libro_Carrito libroCarrito) {
        return libroCarritoRepository.create(libroCarrito);
    }

    // get all
    @GetMapping("/libro_carrito")
    public List<Libro_Carrito> getAllLibros_Carritos() {
        return libroCarritoRepository.getAll();
    }

    //get one (by id)
    @GetMapping("/libro_carrito/{id_libro}/{id_carrito}")
    public List<Libro_Carrito> getCarritoById(@PathVariable Integer id_carrito, @PathVariable Integer id_libro) {
        return libroCarritoRepository.show(id_libro, id_carrito);
    }

    // update
    @PutMapping("/libro_carrito/{id_libro}/{id_carrito}")
    @ResponseBody
    public String updateCarrito(@RequestBody Libro_Carrito libroCarrito, @PathVariable Integer id_libro,  @PathVariable Integer id_carrito) {
        return libroCarritoRepository.update(libroCarrito, id_libro, id_carrito);
    }

    // delete
    @DeleteMapping("/categoria_libro/{id_libro}/{id_carrito}")
    public void borrar(@PathVariable Integer id_libro,  @PathVariable Integer id_carrito) {
        libroCarritoRepository.delete(id_libro, id_carrito);
    }
}
