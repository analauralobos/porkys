package com.example.Compra;

import lombok.Data;

@Data
public class Compra {
    private Integer id_Compra;
    private Integer id_Proveedor;
    private Integer id_MateriaPrima;
    private String fecha_compra;
    private Integer cantidad_compra;
    private Double precio_compra;
}






