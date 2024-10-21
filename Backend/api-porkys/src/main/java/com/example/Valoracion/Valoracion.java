package com.example.Valoracion;

import lombok.Data;

@Data
public class Valoracion {
    private Integer id_Cliente;
    private Integer id_Producto;
    private String fecha_valoracion;
    private Integer cant_estrellas;
    private String comentario;
}