package com.example.msventa.repository;

import com.example.msventa.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository <Venta, Integer> {
}
