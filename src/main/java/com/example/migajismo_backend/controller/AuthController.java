package com.example.migajismo_backend.controller;

import com.example.migajismo_backend.model.Employee;
import com.example.migajismo_backend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final EmployeeService service;

    public AuthController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public Employee login(@RequestBody Employee loginRequest) {
        return service.login(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
