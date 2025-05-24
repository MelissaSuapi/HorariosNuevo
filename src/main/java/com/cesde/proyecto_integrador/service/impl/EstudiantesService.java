package com.cesde.proyecto_integrador.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.proyecto_integrador.model.Estudiantes;
import com.cesde.proyecto_integrador.repository.EstudiantesRepository;

@Service
public class EstudiantesService {
   
    @Autowired
    private EstudiantesRepository estudiantesRepository;

    // Obtener todos los estudiantes
    public List<Estudiantes> getAllEstudiantes() {
        return estudiantesRepository.findAll();
    }

    // Obtener un estudiante por ID
    public Optional<Estudiantes> getEstudianteById(Long id) {
        return estudiantesRepository.findById(id);
    }

    // Crear un nuevo estudiante
    public Estudiantes createEstudiante(Estudiantes estudiante) {
        return estudiantesRepository.save(estudiante);
    }

    // Actualizar un estudiante
    public Estudiantes updateEstudiante(Long id, Estudiantes estudianteDetails) {
        Optional<Estudiantes> estudiante = estudiantesRepository.findById(id);
        if (estudiante.isPresent()) {
            Estudiantes existingEstudiante = estudiante.get();
            existingEstudiante.setNombre(estudianteDetails.getNombre());
            existingEstudiante.setEmail(estudianteDetails.getEmail());
            return estudiantesRepository.save(existingEstudiante);
        }
        return null;
    }

    // Eliminar un estudiante
    public void deleteEstudiante(Long id) {
        estudiantesRepository.deleteById(id);
    }
}


