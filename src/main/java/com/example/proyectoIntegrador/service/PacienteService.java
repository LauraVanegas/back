package com.example.proyectoIntegrador.service;


import com.example.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.example.proyectoIntegrador.model.Paciente;
import com.example.proyectoIntegrador.model.Turno;
import com.example.proyectoIntegrador.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> getAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> get(long id){
        return pacienteRepository.findById(id);
    }

    public Paciente update(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public void delete(long id) throws ResourceNotFoundException {
        Optional<Paciente> traerPaciente = get(id);
        if (traerPaciente.isPresent())
            pacienteRepository.deleteById(id);
        else {
            throw new ResourceNotFoundException("No existe el paciente con el id: " +id+ "Ingrese un id valido");
        }
    }
}
