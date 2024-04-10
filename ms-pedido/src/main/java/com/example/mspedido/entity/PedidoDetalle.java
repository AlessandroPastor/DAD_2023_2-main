package com.example.mspedido.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class PedidoDetalle {
    @Id
    @GeneratedValue()
    private Integer id;
    private Double cantidad;
    private Double precio;
    private Integer productoId;
    public PedidoDetalle() {
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pedido pedido;
}
