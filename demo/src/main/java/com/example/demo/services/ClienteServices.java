package com.example.demo.services;

import java.util.Optional;
import java.util.List;


import com.example.demo.entity.Cliente;

public interface ClienteServices {

    
    List<Cliente>listar();
    Cliente guardar(Cliente categoria);
    Cliente actualizar(Cliente categoria);
    Optional<Cliente>listaPorld(Integer id);
    void eliminar(Integer id);
}
