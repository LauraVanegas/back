package com.example.proyectoIntegrador.repository;

import com.example.proyectoIntegrador.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository <Odontologo, Integer>{
}
