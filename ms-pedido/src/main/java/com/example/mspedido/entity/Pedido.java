package com.example.mspedido.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoDetalle> pedidoDetalles;

    @ManyToOne
    @JoinColumn(name = "pedidodetalle_id")
    private PedidoDetalle pedidoDetalle;
}
