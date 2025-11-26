package com.example.migajismo_backend.repository;

import com.example.migajismo_backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByClienteCorreo(String correo);

    List<Order> findByEstado(String estado);
}
