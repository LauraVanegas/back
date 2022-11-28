package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.model.Odontologo;
import com.example.proyectoIntegrador.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class OdontologoService {

    private final OdontologoRepository odontologoRepository;

    public Odontologo save(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public List<Odontologo> getAll() {
        return odontologoRepository.findAll();
    }

    public Optional<Odontologo> get(long id){
        return odontologoRepository.findById(id);
    }

    public Odontologo update(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public void delete(long id){
        odontologoRepository.deleteById(id);
    }
}