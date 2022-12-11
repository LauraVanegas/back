package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.exceptions.BadRequestException;
import com.example.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.example.proyectoIntegrador.model.Odontologo;
import com.example.proyectoIntegrador.model.Paciente;
import com.example.proyectoIntegrador.model.Turno;
import com.example.proyectoIntegrador.repository.OdontologoRepository;
import com.example.proyectoIntegrador.repository.PacienteRepository;
import com.example.proyectoIntegrador.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TurnoService {

    private final TurnoRepository turnoRepository;

    private final PacienteService pacienteService;

    private final OdontologoService odontologoService;


    public Turno save(Turno turno) throws BadRequestException {
        if (turno.getPaciente() != null && turno.getOdontologo() != null){
            pacienteService.save(turno.getPaciente());
            odontologoService.save(turno.getOdontologo());

            turnoRepository.save(turno);}
        else {
            throw new BadRequestException("No fue posible registrar el turno");
        }

        return turno;
    }

    public List<Turno> getAll() {
        return turnoRepository.findAll();
    }

    public Optional<Turno> get(int id){
        return turnoRepository.findById(id);
    }

    public Turno update(Turno turno){
        return turnoRepository.save(turno);
    }

    public void delete(int id) throws ResourceNotFoundException {
        Optional<Turno> traerTurno = get(id);
        if (traerTurno.isPresent())
        turnoRepository.deleteById(id);
        else {
            throw new ResourceNotFoundException("No existe el turno con el id: " +id+ "Ingrese un id valido");
        }
    }
}
