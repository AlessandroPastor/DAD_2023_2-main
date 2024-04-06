package com.example.msventa.service.impl;

import com.example.msventa.Entity.Venta;
import com.example.msventa.Entity.VentaDetalle;
import com.example.msventa.repository.VentaDetalleRepository;
import com.example.msventa.repository.VentaRepository;
import com.example.msventa.service.VentaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class VentaDetalleServiceImpl implements VentaDetalleService {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;
    @Override
    public List<VentaDetalle> listar() {
        return  ventaDetalleRepository.findAll();
    }

    @Override
    public VentaDetalle guardar(VentaDetalle ventaDetalle) {
        return ventaDetalleRepository.save(ventaDetalle);
    }

    @Override
    public VentaDetalle actualizar(VentaDetalle ventaDetalle) {
        return ventaDetalleRepository.save(ventaDetalle);
    }

    @Override
    public Optional<VentaDetalle> listaPorld(Integer id) {
        return ventaDetalleRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        ventaDetalleRepository.deleteById(id);

    }
}
