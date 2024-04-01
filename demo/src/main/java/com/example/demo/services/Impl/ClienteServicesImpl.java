package com.example.demo.services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.services.ClienteServices;
import java.util.List;


/**
 * ClienteServicesImpl
 */
@Service
public class ClienteServicesImpl implements ClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }
    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> listaPorld(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }
    
}