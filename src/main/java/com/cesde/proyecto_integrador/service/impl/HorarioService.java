package com.cesde.proyecto_integrador.service.impl;

import com.cesde.proyecto_integrador.dto.HorariosDTO;
import com.cesde.proyecto_integrador.model.*;
import com.cesde.proyecto_integrador.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private ClasesRepository clasesRepository;

    @Autowired
    private ProfesoresRepository profesoresRepository;

    @Autowired
    private EstudiantesRepository estudiantesRepository;

    public List<Horarios> getAllHorarios() {
        return horarioRepository.findAll();
    }

    public Optional<Horarios> getHorarioById(Long id) {
        return horarioRepository.findById(id);
    }

    // NUEVO: crear desde el DTO
    public Horarios createHorario(HorariosDTO dto) {
        Clases clase = clasesRepository.findById(dto.getIdClases())
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        Profesores profesor = profesoresRepository.findById(dto.getIdProfesor())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Estudiantes estudiante = estudiantesRepository.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Horarios horario = new Horarios();
        horario.setDia(dto.getDia());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());
        horario.setClases(clase);
        horario.setProfesor(profesor);
        horario.setEstudiante(estudiante);

        return horarioRepository.save(horario);
    }

    public void deleteHorario(Long id) {
        horarioRepository.deleteById(id);
    }

    public Horarios updateHorario(Long id, Horarios horarioDetails) {
        throw new UnsupportedOperationException("Unimplemented method 'updateHorario'");
    }
}
