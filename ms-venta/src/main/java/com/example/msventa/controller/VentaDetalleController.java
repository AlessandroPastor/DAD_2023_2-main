package com.example.msventa.controller;


import com.example.msventa.Entity.Venta;
import com.example.msventa.Entity.VentaDetalle;
import com.example.msventa.service.VentaDetalleService;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventadetalle")
public class VentaDetalleController {
    @Autowired
    private VentaDetalleService ventaDetalleService;

    @GetMapping()
    public ResponseEntity<List<VentaDetalle>> listar(){
        return ResponseEntity.ok(ventaDetalleService.listar());
    }

    @PostMapping
    public ResponseEntity<VentaDetalle>guardar(@RequestBody VentaDetalle ventaDetalle){
        return ResponseEntity.ok(ventaDetalleService.guardar(ventaDetalle));
    }

    @PutMapping
    public ResponseEntity<VentaDetalle>actualizar(@RequestBody VentaDetalle ventaDetalle){
        return ResponseEntity.ok(ventaDetalleService.actualizar(ventaDetalle));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDetalle>listaPorld(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(ventaDetalleService.listaPorld(id).get());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<List<VentaDetalle>>eliminar(@PathVariable(required = true) Integer id){
        ventaDetalleService.eliminar(id);
        return ResponseEntity.ok(ventaDetalleService.listar());
    }
}
