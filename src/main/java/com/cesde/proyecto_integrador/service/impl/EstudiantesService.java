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

    public List<Estudiantes> getAllEstudiantes() {
        return estudiantesRepository.findAll();
    }

    public Optional<Estudiantes> getEstudianteById(Long id) {
        return estudiantesRepository.findById(id);
    }

    public Estudiantes createEstudiante(Estudiantes estudiante) {
        // Guardar contraseña tal cual sin encriptar
        return estudiantesRepository.save(estudiante);
    }

    public Estudiantes updateEstudiante(Long id, Estudiantes estudianteDetails) {
        Optional<Estudiantes> estudianteOptional = estudiantesRepository.findById(id);
        if (estudianteOptional.isPresent()) {
            Estudiantes existingEstudiante = estudianteOptional.get();
            existingEstudiante.setNombre(estudianteDetails.getNombre());
            existingEstudiante.setEmail(estudianteDetails.getEmail());

            if (estudianteDetails.getPassword() != null && !estudianteDetails.getPassword().isBlank()) {
                existingEstudiante.setPassword(estudianteDetails.getPassword());
            }

            return estudiantesRepository.save(existingEstudiante);
        }
        return null;
    }

    public void deleteEstudiante(Long id) {
        estudiantesRepository.deleteById(id);
    }

    // 🔐 LOGIN sin encriptación
    public Estudiantes login(String email, String password) {
        Optional<Estudiantes> estudianteOptional = estudiantesRepository.findByEmail(email);

        if (estudianteOptional.isPresent()) {
            Estudiantes estudiante = estudianteOptional.get();
            if (password.equals(estudiante.getPassword())) {
                return estudiante;
            }
        }
        return null;
    }
}
