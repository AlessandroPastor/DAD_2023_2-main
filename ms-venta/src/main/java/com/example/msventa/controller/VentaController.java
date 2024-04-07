package com.example.msventa.controller;

import com.example.msventa.Entity.Venta;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")

public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping()
    public ResponseEntity<List<Venta>> listar(){
        return ResponseEntity.ok(ventaService.listar());
    }

    @PostMapping
    public ResponseEntity<Venta>guardar(@RequestBody Venta venta){
        return ResponseEntity.ok(ventaService.guardar(venta));
    }

    @PutMapping
    public ResponseEntity<Venta>actualizar(@RequestBody Venta venta){
        return ResponseEntity.ok(ventaService.actualizar(venta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta>listaPorld(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(ventaService.listaPorld(id).get());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<List<Venta>>eliminar(@PathVariable(required = true) Integer id){
        ventaService.eliminar(id);
        return ResponseEntity.ok(ventaService.listar());
    }
}
