package com.example.proyectoIntegrador.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Odontologos")
@Getter
@Setter
public final class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombre;
    private String apellido;
    private int matricula;

    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnoSet;

}
