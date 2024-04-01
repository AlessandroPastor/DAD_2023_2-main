package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.services.ClienteServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/cliente")

public class ClienteController {
        @Autowired
    private ClienteServices clienteServices;

    @GetMapping()
    public ResponseEntity<List<Cliente>>listar(){
        return ResponseEntity.ok(clienteServices.listar());
    }

    @PostMapping
    public ResponseEntity<Cliente>guardar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteServices.guardar(cliente));
    }

    @PutMapping
    public ResponseEntity<Cliente>actualizar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteServices.actualizar(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente>listaPorld(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(clienteServices.listaPorld(id).get());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<List<Cliente>>eliminar(@PathVariable(required = true) Integer id){
        clienteServices.eliminar(id);
        return ResponseEntity.ok(clienteServices.listar());
    }

}
