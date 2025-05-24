package com.cesde.proyecto_integrador.model;
import java.util.List; 




import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clases")

public class Clases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_clases;

    @Column(name = "nombre")
    private String name = "";

    @Column(name = "dia")
    private String dia;

    @Column(name = "hora_inicio")
    private String hora_inicio;

    @Column(name = "hora_fin")
    private String hora_fin;

    @OneToMany(mappedBy = "clases")
    private List<Horarios> horarios;


    
}
