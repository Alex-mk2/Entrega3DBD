package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.Lista_Favoritos;
import com.example.grupo3.ProyectoDBD.repositories.Lista_FavoritosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Lista_FavoritosService {
    private final  com.example.grupo3.ProyectoDBD.repositories.Lista_FavoritosRepository listaFavoritosRepository;

    public Lista_FavoritosService(Lista_FavoritosRepository listaFavoritosRepository) {
        this.listaFavoritosRepository = listaFavoritosRepository;
    }


    //create
    @PostMapping("/lista_favoritos")
    @ResponseBody
    public Lista_Favoritos create(@RequestBody Lista_Favoritos listaFavoritos) {
        return listaFavoritosRepository.create(listaFavoritos);
    }

    // get all
    @GetMapping("/lista_favoritos")
    public List<Lista_Favoritos> getAllLista_Favoritos() {
        return listaFavoritosRepository.getAll();
    }

    //get one (by id)
    @GetMapping("/lista_favoritos/{id_usuario}/{id_libro}/")
    public List<Lista_Favoritos> getLista_FavoritosById(@PathVariable Integer id_usuario, @PathVariable Integer id_libro) {
        return listaFavoritosRepository.show(id_usuario, id_libro);
    }

    // update
    @PutMapping("/lista_favoritos/{id_usuario}/{id_libro}")
    @ResponseBody
    public String updateCarrito(@RequestBody Lista_Favoritos listaFavoritos, @PathVariable Integer id_usuario,  @PathVariable Integer id_libro) {
        return listaFavoritosRepository.update(listaFavoritos, id_usuario, id_libro);
    }

    // delete
    @DeleteMapping("/lista_favoritos/{id_usuario}/{id_libro}")
    public void borrar(@PathVariable Integer id_usuario,  @PathVariable Integer id_libro) {
        listaFavoritosRepository.delete(id_usuario, id_libro);
    }
}
