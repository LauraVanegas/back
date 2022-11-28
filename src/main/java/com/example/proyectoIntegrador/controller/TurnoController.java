package com.example.proyectoIntegrador.controller;

import com.example.proyectoIntegrador.model.Turno;
import com.example.proyectoIntegrador.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Turnos")
@AllArgsConstructor
public class TurnoController {

    private final TurnoService turnoService;

    @PostMapping("/save")
    public ResponseEntity<Turno> save(@RequestBody Turno turno){
        return ResponseEntity.ok().body(turnoService.save(turno));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Turno>> getAll(){
        return ResponseEntity.ok().body(turnoService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Turno>> get(@PathVariable long id){
        return ResponseEntity.ok().body(turnoService.get(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Turno> update(@RequestBody Turno turno){
        return ResponseEntity.ok().body(turnoService.update(turno));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        turnoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
