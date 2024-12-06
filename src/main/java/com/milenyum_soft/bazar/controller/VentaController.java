package com.milenyum_soft.bazar.controller;

import com.milenyum_soft.bazar.modelo.Cliente;
import com.milenyum_soft.bazar.modelo.Producto;
import com.milenyum_soft.bazar.modelo.Venta;
import com.milenyum_soft.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    //CREAR
    @PostMapping("ventas/crear")
    public String crearVenta(@RequestBody Venta venta) {
        ventaService.createdVenta(venta);
    return "Venta creado exitosamete";
    }

    //LISTAR VENTAS COMPLETAS

    @GetMapping("ventas")
    public List<Venta> findAll(){
       return ventaService.findAll();

    }

    //LISTAR VENTA
    @GetMapping("ventas/{codigo_venta}")
    public Venta findById(@PathVariable Long codigo_venta ){
        return ventaService.findById(codigo_venta);

    }

    //ELIMINAR VENTA
    @DeleteMapping("venta/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable  Long codigo_venta){
        ventaService.deleteVenta(codigo_venta);
        return "Venta eliminada exitosamete";

    }

    //EDIATR VENTA

    @PutMapping("venta/editar/{codigo_venta}")
    public String editVenta(@PathVariable Long codigo_venta,@RequestBody Venta venta){
        Venta vent = ventaService.findById(codigo_venta);
       Long id =   vent.getCodigo_venta();
       LocalDate fecha = vent.getFecha_venta();
       double total =   vent.getTotal();
       List<Producto> listaVenta = vent.getListaProducto();
       Cliente unclient=  vent.getUnCliente();

       ventaService.editVenta(venta);

       return   "Edición exitosamete" + vent.toString();

    }

    //OBTENER LISTA DE PRODUCTOS DE UNA DETERMINADA VENTA
    @GetMapping("ventas/productos/{codigo_venta}")
    public List<Producto> findByProducto(@PathVariable Long codigo_venta ){

        Venta vent  = ventaService.findById(codigo_venta);
        List<Producto> listaDeProductos= vent.getListaProducto();
        return listaDeProductos;
    }

    // SUMATORIA DEL MONTO CANTIDAD TOTAL DE VENTAS DE UN DETERMINADO DIA

    @GetMapping("ventas/fecha/{fecha_venta}")
    public String getAllVentas(@PathVariable String fecha_venta ){
       List<Venta> listaVentas=  ventaService.findAll();
       double sumatoriaMonto =0;
       int ventasTotales=0;
       LocalDate fechaVentaParam = LocalDate.parse(fecha_venta);

       for(Venta venta: listaVentas){
       if(venta.getFecha_venta().equals(fechaVentaParam)){

          sumatoriaMonto+= venta.getTotal();
          ventasTotales++;


       }
       }
    return "Sumatoria del monto es : " + sumatoriaMonto + "Ventas totales es: " + ventasTotales;

    }


    @GetMapping("ventas/mayor_venta")
    public String getMayorVenta(){
       return "La venta con el monto más alto es: " + ventaService.findVentaById().toString();

    }

    @GetMapping("ventas/menor_venta")
    public String getMenorVenta(){
        return  "La venta con el monto menor es" + ventaService.menorVentaById().toString();
    }
}

