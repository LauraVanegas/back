package com.example.proyectoIntegrador.controller;


import com.example.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.example.proyectoIntegrador.model.Paciente;
import com.example.proyectoIntegrador.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@AllArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;


    @PostMapping("/save")
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente){
        return ResponseEntity.ok().body(pacienteService.save(paciente));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Paciente>> getAll(){
        return ResponseEntity.ok().body(pacienteService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Paciente>> get(@PathVariable int id){
        return ResponseEntity.ok().body(pacienteService.get(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente){
        return ResponseEntity.ok().body(pacienteService.update(paciente));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
        pacienteService.delete(id);
        return ResponseEntity.ok("se elimino el paciente correctamente");
    }
}
