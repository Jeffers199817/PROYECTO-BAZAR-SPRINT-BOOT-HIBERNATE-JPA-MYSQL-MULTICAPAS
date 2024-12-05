package com.milenyum_soft.bazar.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClienteProductoVentaDTO {

    private Long codigo_venta;
    private Double total;
    private int cantidadDeProductos;
    private String nombreCliente;
    private String apellidoCliente;

}
