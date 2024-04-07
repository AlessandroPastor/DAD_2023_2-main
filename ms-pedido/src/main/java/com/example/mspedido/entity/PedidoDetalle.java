package com.example.mspedido.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class PedidoDetalle {
    @Id
    @GeneratedValue()
    private Integer id;
    private String fechaVenta;
    private String metodoPago;
    private String nombreCliente;
    private String direccionCliente;
    private String correoCliente;
    private String telefonoCliente;
    private String productoVendido;
    private double precioProducto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;
}
