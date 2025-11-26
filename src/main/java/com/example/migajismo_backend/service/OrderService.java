package com.example.migajismo_backend.service;

import com.example.migajismo_backend.model.Order;
import com.example.migajismo_backend.model.OrderItem;
import com.example.migajismo_backend.repository.OrderRepository;
import com.example.migajismo_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    // ---------------------------------------------------------
    // CREAR PEDIDO
    // ---------------------------------------------------------
    public Order crearPedido(Order order) {

        order.setFecha(LocalDateTime.now());
        order.setEstado("Pendiente");

        double total = 0;

        for (OrderItem item : order.getItems()) {
            // subtotal ya viene del front
            item.setOrder(order);
        }

        order.setTotal(total);

        return orderRepo.save(order);
    }

    // ---------------------------------------------------------
    // LISTAR TODOS LOS PEDIDOS
    // ---------------------------------------------------------
    public List<Order> listarTodos() {
        return orderRepo.findAll();
    }

    // ---------------------------------------------------------
    // LISTAR POR TELÉFONO
    // ---------------------------------------------------------
    public List<Order> listarPorTelefono(String telefono) {
        return orderRepo.findByClienteTelefono(telefono);
    }

    // ---------------------------------------------------------
    // LISTAR POR ESTADO
    // ---------------------------------------------------------
    public List<Order> listarPorEstado(String estado) {
        return orderRepo.findByEstado(estado);
    }

    // ---------------------------------------------------------
    // CAMBIAR ESTADO
    // ---------------------------------------------------------
    public Order cambiarEstado(Long id, String nuevoEstado) {
        var pedido = orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        pedido.setEstado(nuevoEstado);
        return orderRepo.save(pedido);
    }
}
