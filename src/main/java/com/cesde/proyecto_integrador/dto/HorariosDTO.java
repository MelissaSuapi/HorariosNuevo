package com.cesde.proyecto_integrador.dto;

import lombok.Data;

@Data
public class HorariosDTO {
    private String dia;
    private String horaInicio;
    private String horaFin;
    private Long idClases;
    private Long idProfesor;
    private Long idEstudiante;
}
