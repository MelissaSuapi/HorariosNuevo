package com.cesde.proyecto_integrador.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference; 

@Data
@Entity
@Table(name = "profesores")

public class Profesores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profesores;

    @Column(name = "nombre")
    private String name = "";

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "profesor")
    @JsonManagedReference(value = "profesor-horario")
    private List<Horarios> horarios;


}
