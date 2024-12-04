package com.milenyum_soft.bazar.controller;


import com.milenyum_soft.bazar.modelo.Producto;
import com.milenyum_soft.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //LISTAR PRODUCTOS

    @GetMapping("productos")
    public List<Producto> productos(){
        return productoService.getProductos();
    }

    //TRAER PRODCUTO
    @GetMapping("productos/{codigoProducto}")
    public Producto getProducto(@PathVariable Long codigoProducto){

        return productoService.getProducto(codigoProducto);

    }

    //ELIMINAR PRODUCTO
    @DeleteMapping("productos/eliminar/{codigoProducto}")
    public String eliminarProducto(@PathVariable Long codigoProducto){
          String nombreProducto=  productoService.getProducto(codigoProducto).getNombre();
            productoService.deleteProducto(codigoProducto);
        return "Producto: " + nombreProducto + " eliminado correctamente.";
    }

    //EDITAR PRODUCTO
    @PutMapping("productos/editar/{codigo_producto}")
    public String editProducto(@PathVariable Long codigo_producto,@RequestBody Producto producto){
        Producto productoAntiguo = productoService.getProducto(producto.getCodigo_producto());
        String nombreAntiguo = productoAntiguo.getNombre();
        System.out.println(productoAntiguo.toString());


        Producto producEdti = productoService.updateProducto(producto);
        System.out.println(producEdti.toString());
        return "Producto Antiguo: " +  nombreAntiguo +  "  Producto Editado : " + producEdti.toString() ;
        }


}
