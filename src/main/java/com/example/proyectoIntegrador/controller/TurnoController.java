package com.example.proyectoIntegrador.controller;

import com.example.proyectoIntegrador.exceptions.BadRequestException;
import com.example.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.example.proyectoIntegrador.model.Odontologo;
import com.example.proyectoIntegrador.model.Paciente;
import com.example.proyectoIntegrador.model.Turno;
import com.example.proyectoIntegrador.service.OdontologoService;
import com.example.proyectoIntegrador.service.PacienteService;
import com.example.proyectoIntegrador.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
@AllArgsConstructor
public class TurnoController {

    private final TurnoService turnoService;

    private final OdontologoService odontologoService;

    private final PacienteService pacienteService;

    @PostMapping("/save")
    public ResponseEntity<Turno> save(@RequestBody Turno turno) throws BadRequestException {
        ResponseEntity<Turno> respuesta;

        Optional<Paciente> paciente = pacienteService.get(turno.getPaciente().getId());
        Optional<Odontologo> odontologo = odontologoService.get(turno.getOdontologo().getId());
        if (paciente.isPresent()&&odontologo.isPresent()){
            respuesta = ResponseEntity.ok().body(turnoService.save(turno));
        }
        else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Turno>> getAll(){
        return ResponseEntity.ok().body(turnoService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Turno>> get(@PathVariable int id){
        return ResponseEntity.ok().body(turnoService.get(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Turno> update(@RequestBody Turno turno){
        return ResponseEntity.ok().body(turnoService.update(turno));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
        turnoService.delete(id);
        return ResponseEntity.ok("se elimino el turno correctamente");
    }
}
