package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.model.Odontologo;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@AllArgsConstructor
@SpringBootTest
class OdontologoServiceTest {

    private OdontologoService odontologoService;

    @Test
    public void testSaveOdontologo (){
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("mery");
        odontologo.setApellido("gonzalez");
        odontologo.setMatricula(32156);
        odontologoService.save(odontologo);

        Optional<Odontologo> odontologoUno = odontologoService.get(1L);

        assertTrue(odontologoUno != null);
    }
}