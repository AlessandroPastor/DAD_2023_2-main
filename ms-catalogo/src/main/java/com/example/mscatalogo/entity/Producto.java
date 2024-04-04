package com.example.mscatalogo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String numero;
    private String codigo;
    private String detalle;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
