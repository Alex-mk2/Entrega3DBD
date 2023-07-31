package com.example.grupo3.ProyectoDBD.services;
import com.example.grupo3.ProyectoDBD.models.Libro_Restriccion;
import com.example.grupo3.ProyectoDBD.repositories.Libro_RestriccionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class Libro_RestriccionService{
    private final com.example.grupo3.ProyectoDBD.repositories.Libro_RestriccionRepository libro_restriccionRepository;


    Libro_RestriccionService(Libro_RestriccionRepository libroRestriccionRepository) {
        libro_restriccionRepository = libroRestriccionRepository;
    }

    //Crear Restriccion Libro//
    @PostMapping("/Libro_Restriccion/")
    @ResponseBody
    public Libro_Restriccion create(Libro_Restriccion Libro_Restriccion) {
        Libro_Restriccion newLibro_Restriccion = libro_restriccionRepository.create(Libro_Restriccion);
        return newLibro_Restriccion;
    }
    //Mostrar todas las restricciones de los libros//
    @GetMapping("/Restricciones_Libros")
    public List<Libro_Restriccion> getAllRestictionBook(){
        return libro_restriccionRepository.getAllRestictionBook();

    }
    //Mostrar una restriccion de un libro//
    @GetMapping("/Restriccion/{id_libro}")
    public List<Libro_Restriccion> Show(@PathVariable Integer id_libro){
        return libro_restriccionRepository.Show(id_libro);
    }
    @PutMapping("/Restriccion_libro/{id_libro}")
    @ResponseBody

    //Actualizar Restriccion de un libro//
    public String update(@RequestBody Libro_Restriccion Libro_Restriccion ,@PathVariable Integer id_libro){
        String newRestriccionLibro = libro_restriccionRepository.update(Libro_Restriccion, id_libro);
        return newRestriccionLibro;
    }

    //Eliminar Restriccion de un libro//
    @DeleteMapping("/Restriccion_libro/{id_libro}")
    public void delete(@PathVariable Integer id_libro){
        libro_restriccionRepository.delete(id_libro);
    }
}

