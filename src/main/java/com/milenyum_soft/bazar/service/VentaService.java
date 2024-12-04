package com.milenyum_soft.bazar.service;


import com.milenyum_soft.bazar.modelo.Producto;
import com.milenyum_soft.bazar.modelo.Venta;
import com.milenyum_soft.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public void createdVenta(Venta venta) {
       List<Producto> listProducto =venta.getListaProducto();
       double total = 0;
       for(Producto product : listProducto) {
        total += product.getCosto();

       }
       venta.setTotal(total);

        ventaRepository.save(venta);
    }

    @Override
    public Venta findById(Long id) {
        return ventaRepository.findById(id).get();
    }

    @Override
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    @Override
    public void deleteVenta(Long id) {
    ventaRepository.deleteById(id);
    }

    @Override
    public Venta editVenta(Venta venta) {

        Venta vent = this.findById(venta.getCodigo_venta());
        vent.setCodigo_venta(venta.getCodigo_venta());
        vent.setFecha_venta(venta.getFecha_venta());
        vent.setTotal(venta.getTotal());
        vent.setListaProducto(venta.getListaProducto());
        vent.setUnCliente(venta.getUnCliente());

        this.createdVenta(vent);


        return vent;
    }
}
