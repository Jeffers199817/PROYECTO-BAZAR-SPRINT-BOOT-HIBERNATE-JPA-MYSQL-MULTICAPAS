package com.milenyum_soft.bazar.service;

import com.milenyum_soft.bazar.modelo.Producto;

import java.util.List;

public interface IProductoService {

    //TRAER
    public Producto getProducto(Long codigo);
    public List<Producto> getProductos();

    //CREAR
    public void createProducto(Producto producto);

    //ELIMINAR
    public void deleteProducto(Long codigo);

    //Editar
    public Producto updateProducto(Producto producto);
}
