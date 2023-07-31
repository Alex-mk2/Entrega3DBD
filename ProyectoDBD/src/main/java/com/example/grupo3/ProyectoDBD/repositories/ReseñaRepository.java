package com.example.grupo3.ProyectoDBD.repositories;

import com.example.grupo3.ProyectoDBD.models.Resena;

import java.util.List;

public interface ReseñaRepository{

    /**
     * Inserta una reseña en la tabla reseña
     * al ser atributos obligatorios (menos id), si son nulos se lanzara una excepcion si no encuentra el id
     * o fallo de la conexion
     *
     * @param Resena objeto de la clase Reseña que contiene atributos definidos en la estructura insertar Reseña, provenientes del MR
     * @return su retorno es una reseña creada, caso contrario nulo si falla la operacion
     * @throws Exception si uno de los atributos es nulo o esta vacio.
     */

    Resena create(Resena Resena);

    /**
     * Inserta datos en una clase Reseña en la tabla Reseña.
     * al ser atributos obligatorios (menos id), si son nulos se lanzara una excepcion si no encuentra el id
     * o fallo de la conexion
     *
     * @param Resena     objeto de la clase Reseña que tiene los atributos correspondientes a insertar en una Reseña.
     * @param id_usuario string alfanumerico correspondiente al id de la Reseña  a la cual se desea insertar datos.
     * @return retorna un string que indica el exito de la actualización de los datos del id_usuario.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el id del usuario.
     */

    String update(Resena Resena, Integer id_usuario);


    void delete(Integer id_usuario, Integer id_libro);

    List<Resena> Show(Integer id_usuario);

    List<Resena> getAllReview();
}
