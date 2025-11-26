package com.example.migajismo_backend.controller;

import com.example.migajismo_backend.model.Employee;
import com.example.migajismo_backend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;   // 👈 FALTABA ESTE IMPORT

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final EmployeeService service;

    public AuthController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Employee loginRequest) {

        Employee e = service.login(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );

        if (e == null) {
            return ResponseEntity.status(401)
                    .body("{\"ok\": false}");
        }

        return ResponseEntity.ok(e);
    }
}
