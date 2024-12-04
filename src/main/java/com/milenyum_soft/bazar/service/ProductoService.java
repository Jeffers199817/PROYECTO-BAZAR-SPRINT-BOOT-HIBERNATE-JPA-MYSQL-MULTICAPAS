package com.milenyum_soft.bazar.service;

import com.milenyum_soft.bazar.modelo.Producto;
import com.milenyum_soft.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public Producto getProducto(Long codigo) {

        return  productoRepository.findById(codigo).get();
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void createProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long codigo) {
            productoRepository.deleteById(codigo);
    }

    @Override
    public Producto updateProducto(Producto producto) {

            Producto produc = this.getProducto(producto.getCodigo_producto());
            produc.setNombre(producto.getNombre());
            produc.setMarca(producto.getMarca());
            produc.setCosto(producto.getCosto());
            produc.setCantidad_disponible(producto.getCantidad_disponible());

            this.createProducto(produc);

        return produc ;
    }
}
