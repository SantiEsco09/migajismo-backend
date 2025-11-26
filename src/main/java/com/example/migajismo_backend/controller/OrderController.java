package com.example.migajismo_backend.controller;

import com.example.migajismo_backend.model.Order;
import com.example.migajismo_backend.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order crearPedido(@RequestBody Order order) {
        return service.crearPedido(order);
    }

    @GetMapping
    public List<Order> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/estado/{estado}")
    public List<Order> pedidosPorEstado(@PathVariable String estado) {
        return service.listarPorEstado(estado);
    }

    @PatchMapping("/{id}/estado/{nuevoEstado}")
    public Order cambiarEstado(
            @PathVariable Long id,
            @PathVariable String nuevoEstado
    ) {
        return service.cambiarEstado(id, nuevoEstado);
    }
}
