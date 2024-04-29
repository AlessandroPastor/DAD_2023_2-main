package com.example.mspedido.service.impl;

import com.example.mspedido.dto.ClienteDto;
import com.example.mspedido.dto.ProductoDto;
import com.example.mspedido.entity.Pedido;
import com.example.mspedido.entity.PedidoDetalle;
import com.example.mspedido.feign.ClienteFeign;
import com.example.mspedido.feign.ProductoFeign;
import com.example.mspedido.repository.PedidoRepository;
import com.example.mspedido.service.ClienteNotFoundException;
import com.example.mspedido.service.PedidoService;
import com.example.mspedido.service.ProductoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteFeign clienteFeign;
    @Autowired
    private ProductoFeign productoFeign;

    @Override
    public List<Pedido> listar(){
        return pedidoRepository.findAll();
    }
    @Override
    public Pedido guardar(Pedido pedido) {
        if (pedido.getClienteId() == null) {
            throw new ClienteNotFoundException("El cliente es obligatorio para guardar un pedido");
        }

        // Guardar el pedido en la base de datos
        return pedidoRepository.save(pedido);

    }
    @Override
    public Pedido actualizar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    @Override
    public Optional<Pedido> listarPorId(Integer id){
        Optional<Pedido> pedido= pedidoRepository.findById(id);
        ClienteDto clienteDto = clienteFeign.listarPorld(pedido.get().getClienteId()).getBody();
        /*for (PedidoDetalle pedidoDetalle : pedido.get().getDetalle()){
            pedidoDetalle.setProductoDto(productoFeign.buscarlistarPorld(pedidoDetalle.getProductoId()).getBody());
        }*/
        List<PedidoDetalle> pedidoDetalles = pedido.get().getDetalle().stream().map(pedidoDetalle -> {
            pedidoDetalle.setProductoDto(productoFeign.listarPorId(pedidoDetalle.getProductoId()).getBody());
            return pedidoDetalle;
        }).toList();
        /*--Captura Cliente-*/
        pedido.get().setClienteDto(clienteDto);
        pedido.get().setDetalle(pedidoDetalles);
        return pedidoRepository.findById(id);
    }
    @Override
    public Pedido crearPedido(Pedido pedido) {
        // Verificar si el cliente asociado existe
        ClienteDto clienteDto = clienteFeign.listarPorld(pedido.getClienteId()).getBody();
        if (clienteDto == null) {
            throw new ClienteNotFoundException("El cliente asociado al pedido no existe");
        }

        // Verificar si los productos asociados existen
        for (PedidoDetalle detalle : pedido.getDetalle()) {
            ProductoDto productoDto = productoFeign.listarPorId(detalle.getProductoId()).getBody();
            if (productoDto == null) {
                throw new ProductoNotFoundException("El producto del detalle de pedido no existe");
            }
        }

        // Si todos los clientes y productos existen, guardar el pedido
        return pedidoRepository.save(pedido);
    }
    @Override
    public void eliminarPorId(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
