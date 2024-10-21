package com.example.Pedido;
import lombok.Data;

@Data
public class Pedido {
    private Integer id_Pedido;
    private Integer id_Cliente;
    private String fecha_pedido;  
    private String fecha_entrega;
    private String lugar_entrega;
    private Integer id_Estado;
    private Integer id_TipoPago;    
}