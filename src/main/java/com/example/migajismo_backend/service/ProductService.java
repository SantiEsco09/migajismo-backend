package com.example.migajismo_backend.service;

import com.example.migajismo_backend.model.Product;
import com.example.migajismo_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> listar() {
        return repo.findAll();
    }

    public Product guardar(Product product) {
        return repo.save(product);
    }

    public Product buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
