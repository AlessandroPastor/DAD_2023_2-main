package com.example.msventa.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registroventa;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
}
