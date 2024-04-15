package com.example.mspedido.controller;

import com.example.mspedido.entity.Pedido;
import com.example.mspedido.entity.PedidoDetalle;
import com.example.mspedido.repository.PedidoDetalleRepository;
import com.example.mspedido.repository.PedidoRepository;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @GetMapping()
    public ResponseEntity<List<Pedido>> list(){
        return ResponseEntity.ok().body(pedidoService.listar());
    }
    @PostMapping()
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
        if (pedido.getClienteId() == null) {
            return ResponseEntity.badRequest().build();
        }
        // Llamar al servicio para guardar el pedido
        Pedido nuevoPedido = pedidoService.guardar(pedido);

        // Devolver el pedido guardado en la respuesta
        return ResponseEntity.ok(pedidoService.guardar(pedido));
    }
    @PutMapping()
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido){
        return ResponseEntity.ok(pedidoService.actualizar(pedido));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(pedidoService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){ pedidoService.eliminarPorId(id);
        return "Eliminado Correctamente :3";
    }


}
