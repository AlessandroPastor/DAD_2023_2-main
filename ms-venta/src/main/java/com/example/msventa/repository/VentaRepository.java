package com.example.msventa.repository;

import com.example.msventa.Entity.Venta;
import com.example.msventa.Entity.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaRepository extends JpaRepository <Venta, Integer> {

}
