package com.cesde.proyecto_integrador.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private int cantidad;

    

    




}
