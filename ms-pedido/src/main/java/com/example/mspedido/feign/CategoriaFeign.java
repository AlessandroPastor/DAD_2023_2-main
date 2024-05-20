package com.example.mspedido.feign;

import com.example.mspedido.dto.CategoriaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "ms-catalogo-service", path = "/categoria")
public interface CategoriaFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "categoriaListarPorIdCT", fallbackMethod = "fallBackCategoria")
    public ResponseEntity<CategoriaDto> listarPorId(@PathVariable(required = true) Integer id);
    default ResponseEntity<CategoriaDto>fallBackCategoria(Integer id, Exception e) {
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setId(9000000);
        return  ResponseEntity.ok(categoriaDto);
    }
}
