package com.example.msventa.service;

import com.example.msventa.Entity.Venta;
import com.example.msventa.Entity.VentaDetalle;

import java.util.List;
import java.util.Optional;

public interface VentaDetalleService {

    List<VentaDetalle> listar();
    VentaDetalle guardar(VentaDetalle ventaDetalle);
    VentaDetalle actualizar(VentaDetalle ventaDetalle);
    Optional<VentaDetalle> listaPorld(Integer id);
    void eliminar(Integer id);
}
