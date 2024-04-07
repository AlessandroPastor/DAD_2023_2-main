package com.example.mscatalogo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Producto> productos;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;


}
