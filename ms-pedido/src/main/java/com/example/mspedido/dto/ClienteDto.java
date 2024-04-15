package com.example.mspedido.dto;

import lombok.Data;

@Data

public class ClienteDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String DNI;
    private String correo;
    private String telefono;
    private String producto;
}
