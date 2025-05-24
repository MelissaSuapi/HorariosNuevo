package com.cesde.proyecto_integrador.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.proyecto_integrador.model.Profesores;
import com.cesde.proyecto_integrador.repository.ProfesoresRepository;

@Service
public class ProfesoresService {


@Autowired
    private ProfesoresRepository profesoresRepository;

    // Obtener todos los profesores
    public List<Profesores> getAllProfesores() {
        return profesoresRepository.findAll();
    }

    // Obtener un profesor por ID
    public Optional<Profesores> getProfesorById(Long id) {
        return profesoresRepository.findById(id);
    }

    // Crear un nuevo profesor
    public Profesores createProfesores(Profesores profesor) {
        return profesoresRepository.save(profesor);
    }

    // Actualizar un profesor
    public Profesores updateProfesores(Long id, Profesores profesoresDetails) {
        Optional<Profesores> profesores = profesoresRepository.findById(id);
        if (profesores.isPresent()) {
            Profesores existingProfesores = profesores.get();
            existingProfesores.setName(profesoresDetails.getName());
            existingProfesores.setEmail(profesoresDetails.getEmail());
            return profesoresRepository.save(existingProfesores);
        }
        return null;
    }

    // Eliminar un profesor
    public void deleteProfesor(Long id) {
        profesoresRepository.deleteById(id);
    }
}


