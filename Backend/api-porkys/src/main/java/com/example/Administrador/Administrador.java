package com.example.Administrador;

import lombok.Data;

@Data
public class Administrador {    
    private Long id_administrador; 
    private String nombre;
    private String apellido;
    private String email;   
    private String password;    
    private String rol;
}
