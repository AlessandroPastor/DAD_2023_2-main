package com.example.msventa.service;

import com.example.msventa.Entity.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaService {
    List<Venta> listar();
    Venta guardar(Venta venta);
    Venta actualizar(Venta venta);
    Optional<Venta> listaPorld(Integer id);
    void eliminar(Integer id);
}
