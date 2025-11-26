package com.example.migajismo_backend.repository;

import com.example.migajismo_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
