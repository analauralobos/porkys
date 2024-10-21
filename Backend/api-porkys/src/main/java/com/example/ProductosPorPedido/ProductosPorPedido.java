package com.example.ProductosPorPedido;

import lombok.Data;

@Data
public class ProductosPorPedido {
    private Integer id_Pedido;
    private Integer id_Producto;    
    private Integer cantidad_pedido;
    private float precio;    
    private String observacion;    
}
