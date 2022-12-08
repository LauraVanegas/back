package com.example.proyectoIntegrador.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController {
    @GetMapping("/")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("<h1>Bienvenido</h1>");
    }
}
