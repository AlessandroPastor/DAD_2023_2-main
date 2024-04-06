package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String nombre;
        private String apellido;
        private String DNI;
        private String correo;
        private String telefono;
        private String producto;
            
}
