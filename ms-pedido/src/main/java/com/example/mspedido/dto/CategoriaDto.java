package com.example.mspedido.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CategoriaDto {
    private Integer id;
    private String nombre;
}
