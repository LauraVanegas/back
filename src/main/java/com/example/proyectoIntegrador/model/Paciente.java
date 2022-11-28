package com.example.proyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Pacientes")
@AllArgsConstructor
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private final String nombre;
    private final String apellido;
    private final String domicilio;
    private final int DNI;
    private final String fechaALta;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnoSet;

}
