package com.example.proyectoIntegrador.controller;

import com.example.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.example.proyectoIntegrador.model.Odontologo;
import com.example.proyectoIntegrador.service.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
@AllArgsConstructor
public class OdontologoController {

    private final OdontologoService odontologoService;

    @PostMapping("/save")
    public ResponseEntity<Odontologo> save(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok().body(odontologoService.save(odontologo));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Odontologo>> getAll(){

        return ResponseEntity.ok().body(odontologoService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Odontologo>> get(@PathVariable int id){
        return ResponseEntity.ok().body(odontologoService.get(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Odontologo> update(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok().body(odontologoService.update(odontologo));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
        odontologoService.delete(id);
        return ResponseEntity.ok("Se elimino el odontologo correctamente");
    }
}
