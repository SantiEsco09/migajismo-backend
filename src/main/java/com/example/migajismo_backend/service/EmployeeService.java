package com.example.migajismo_backend.service;

import com.example.migajismo_backend.model.Employee;
import com.example.migajismo_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee login(String username, String password) {
        return repo.findByUsername(username)
                .filter(emp -> emp.getPassword().equals(password))
                .orElse(null);
    }
}
