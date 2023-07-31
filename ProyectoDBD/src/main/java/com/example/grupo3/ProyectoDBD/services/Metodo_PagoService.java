package com.example.grupo3.ProyectoDBD.services;
import com.example.grupo3.ProyectoDBD.models.Metodo_Pago;
import com.example.grupo3.ProyectoDBD.repositories.MetodoPagoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class Metodo_PagoService{
    private final com.example.grupo3.ProyectoDBD.repositories.MetodoPagoRepository metodoPagoRepository;

    Metodo_PagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }


    //Crear Metodo de pago//
    @PostMapping("/Metodo_Pago/")
    @ResponseBody
    public Metodo_Pago create(Metodo_Pago Metodo_Pago) {
        Metodo_Pago newMetodoPago = metodoPagoRepository.create(Metodo_Pago);
        return newMetodoPago;
    }
    //Mostrar todas los metodos de pago//
    @GetMapping("/Metodo de pago")
    public List<Metodo_Pago> getAll(){
        return metodoPagoRepository.getAll();

    }
    //Mostrar una metodo de pago//
    @GetMapping("/Metodo_Pago/{id_metodo_pago}")
    public List<Metodo_Pago> Show(@PathVariable Integer id_metodo_pago){
        return metodoPagoRepository.show(id_metodo_pago);
    }
    @PutMapping("/Metodo_Pago/{id_metodo_pago}")
    @ResponseBody

    //Actualizar Metodo pago//
    public String update(@RequestBody Metodo_Pago Metodo_Pago, @PathVariable Integer id_metodo_pago){
        String newMetodoPago = metodoPagoRepository.update(Metodo_Pago, id_metodo_pago);
        return newMetodoPago;
    }

    //Eliminar Metodo de pago//
    @DeleteMapping("/Metodo_Pago/{id_metodo_pago}")
    public void delete(@PathVariable Integer id_metodo_pago){
        metodoPagoRepository.delete(id_metodo_pago);
    }
}
