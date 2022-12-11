package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.model.Odontologo;
import com.example.proyectoIntegrador.model.Paciente;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@AllArgsConstructor
@SpringBootTest
public class PacienteServiceTest {

    private final PacienteService pacienteService;


    @Test
    public void testSavePaciente (){
        Paciente paciente = new Paciente();
        paciente.setNombre("mar");
        paciente.setApellido("cruz");
        paciente.setDomicilio("calle vacia con 53");
        paciente.setDNI(123456);
        paciente.setFechaALta(LocalDate.of(2022,12,8));
        pacienteService.save(paciente);

        Optional<Paciente> paciente1 = pacienteService.get(1);

        assertTrue(paciente1 != null);
    }
}
