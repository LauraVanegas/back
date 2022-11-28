package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.model.Turno;
import com.example.proyectoIntegrador.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TurnoService {

    private final TurnoRepository turnoRepository;

    public Turno save(Turno turno){
        return turnoRepository.save(turno);
    }

    public List<Turno> getAll() {
        return turnoRepository.findAll();
    }

    public Optional<Turno> get(long id){
        return turnoRepository.findById(id);
    }

    public Turno update(Turno turno){
        return turnoRepository.save(turno);
    }

    public void delete(long id){
        turnoRepository.deleteById(id);
    }
}
