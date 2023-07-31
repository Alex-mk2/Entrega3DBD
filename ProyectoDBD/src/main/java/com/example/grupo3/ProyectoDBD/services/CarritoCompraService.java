package com.example.grupo3.ProyectoDBD.services;

import com.example.grupo3.ProyectoDBD.models.CarritoCompra;
import com.example.grupo3.ProyectoDBD.repositories.CarritoCompraRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CarritoCompraService {
    private final com.example.grupo3.ProyectoDBD.repositories.CarritoCompraRepository carritoCompraRepository;

    CarritoCompraService(CarritoCompraRepository carritoCompraRepository) {
        this.carritoCompraRepository = carritoCompraRepository;
    }

    //create
    @PostMapping("/carrito")
    @ResponseBody
    public CarritoCompra create(@RequestBody CarritoCompra carritoCompra) {
        return carritoCompraRepository.create(carritoCompra);
    }

    // get all
    @GetMapping("/carrito")
    public List<CarritoCompra> getAllCarritos() {
        return carritoCompraRepository.getAll();
    }

    //get one (by id)
    @GetMapping("/carrito/{id_carrito}")
    public List<CarritoCompra> getCarritoById(@PathVariable Integer id_carrito) {
        return carritoCompraRepository.show(id_carrito);
    }

    // update
    @PutMapping("/carrito/{id_carrito}")
    @ResponseBody
    public String updateCarrito(@RequestBody CarritoCompra carritoCompra, @PathVariable Integer id_carrito) {
        return carritoCompraRepository.update(carritoCompra, id_carrito);
    }

    // delete
    @DeleteMapping("/carrito/{id_carrito}")
    public void borrar(@PathVariable Integer id_carrito) {
        carritoCompraRepository.delete(id_carrito);
    }
}
