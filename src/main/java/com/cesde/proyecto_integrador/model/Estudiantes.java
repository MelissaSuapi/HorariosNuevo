package com.cesde.proyecto_integrador.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference; 

@Data
@Entity
@Table(name = "estudiantes")


public class Estudiantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudiante;

    @Column(name = "nombre")
    private String nombre = "";

    @Column(name = "email")
    private String email;
    

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference(value = "estudiante-horario")
    private List<Horarios> horarios;
}
