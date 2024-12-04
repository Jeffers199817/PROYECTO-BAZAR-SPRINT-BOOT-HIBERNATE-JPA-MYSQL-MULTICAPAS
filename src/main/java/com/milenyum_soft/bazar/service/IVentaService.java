package com.milenyum_soft.bazar.service;

import com.milenyum_soft.bazar.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVentaService  {


    //CREAR VENTA
    public void createdVenta(Venta venta);
    //TRAER UNA VENTA
    public Venta findById(Long id);
    //TRAER TODAS LAS VENTAS
    public List<Venta> findAll();
    //ELIMINAR VENTA
    public void deleteVenta(Long id);
    //EDITAR VENTA
    public Venta editVenta(Venta venta);
}
