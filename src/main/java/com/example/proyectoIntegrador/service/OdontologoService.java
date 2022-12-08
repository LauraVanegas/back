package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.exceptions.ResourceNotFoundException;
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

    public void delete(long id) throws ResourceNotFoundException {
        Optional<Odontologo> traerOdontologo = get(id);
        if (traerOdontologo.isPresent())
            odontologoRepository.deleteById(id);
        else {
            throw new ResourceNotFoundException("No existe el odontologo con el id: " +id+ "Ingrese un id valido");
        }
    }
}