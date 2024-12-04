package com.milenyum_soft.bazar.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double costo;
    private double cantidad_disponible;

    @ManyToOne
    @JoinColumn(name="codigoVenta" , referencedColumnName = "codigo_venta")
    private Venta unaVenta;



}
