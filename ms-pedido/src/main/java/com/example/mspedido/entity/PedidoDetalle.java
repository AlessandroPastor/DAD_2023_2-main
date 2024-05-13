package com.example.mspedido.entity;


import com.example.mspedido.dto.CategoriaDto;
import com.example.mspedido.dto.ProductoDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class PedidoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double cantidad;
    private Double precio;
    private Integer productoId;
    public PedidoDetalle() {
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }

    @Transient
    private ProductoDto productoDto;
}
