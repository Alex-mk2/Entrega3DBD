package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Libro;
import com.example.grupo3.ProyectoDBD.models.Lista_Favoritos;

import java.util.List;

public interface Lista_FavoritosRepository {
    public Lista_Favoritos create(Lista_Favoritos listaFavoritos);

    public List<Lista_Favoritos> getAll();

    public List<Lista_Favoritos> show(Integer id_usuario, Integer id_libro);

    public String update(Lista_Favoritos listaFavoritos, Integer id_usuario, Integer id_libro);

    public void delete(Integer id_usuario, Integer id_libro);

    // RANKING FAVORITOS
    public List<Libro>rankingFavoritos();
}
