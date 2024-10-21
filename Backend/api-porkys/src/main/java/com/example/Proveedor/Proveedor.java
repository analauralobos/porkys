package com.example.Proveedor;

import lombok.Data;

@Data
public class Proveedor {
    private Integer id_Proveedor;
    private String CUIT;
    private String Nombre_Prov;
    private String Direccion_Prov;
    private String email_Prov;        
    private String Telefono_Prov; 
}
