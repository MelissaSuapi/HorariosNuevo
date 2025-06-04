package com.cesde.proyecto_integrador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Horarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_horario;

    // Relación con la entidad Clases
    @ManyToOne
    @JoinColumn(name = "id_clases", referencedColumnName = "id_clases")
    @JsonBackReference(value = "clase-horario")
    private Clases clases;

    // Relación con la entidad Profesores
    @ManyToOne
    @JoinColumn(name = "id_profesores", referencedColumnName = "id_profesores")
    @JsonBackReference(value = "profesor-horario")
    private Profesores profesor;

    // Relación con la entidad Estudiantes
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    @JsonBackReference(value = "estudiante-horario")
    private Estudiantes estudiante;

    private String dia;
    private String horaInicio;
    private String horaFin;
}