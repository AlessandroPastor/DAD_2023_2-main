package com.example.mspedido.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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
}
