package com.example.msventa.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fechaVenta;
    private int cantidadProductos;
    private String metodoPago;
    private String nombreCliente;
    private String direccionCliente;
    private String correoCliente;
    private String telefonoCliente;
    private String productoVendido;
    private double precioProducto;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;


}
