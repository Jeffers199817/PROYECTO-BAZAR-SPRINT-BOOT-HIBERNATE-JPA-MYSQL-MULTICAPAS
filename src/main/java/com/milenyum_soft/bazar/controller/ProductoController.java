package com.milenyum_soft.bazar.controller;


import com.milenyum_soft.bazar.modelo.Producto;
import com.milenyum_soft.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    //CREAR PRODUCTO

    @PostMapping("productos/crear")
    public String createdProduct(@RequestBody Producto producto){
        productoService.createProducto(producto);
        return "Producto creado, Exitosamente " + "Nombre del producto es: " + producto.getNombre();
    }

    @GetMapping("productos/{codigoProducto}")
    public Producto getProducto(@PathVariable Long codigoProducto){

        return productoService.getProducto(codigoProducto);

    }
}
