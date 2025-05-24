package com.cesde.proyecto_integrador.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.proyecto_integrador.model.Clases;
import com.cesde.proyecto_integrador.repository.ClasesRepository;

@Service
public class ClasesService {
    @Autowired
    private ClasesRepository clasesRepository;

    // Obtener todas las clases
    public List<Clases> getAllClases() {
        return clasesRepository.findAll();
    }

    // Obtener una clase por ID
    public Optional<Clases> getClaseById(Long id) {
        return clasesRepository.findById(id);
    }

    // Crear una nueva clase
    public Clases createClase(Clases clases) {
        return clasesRepository.save(clases);
    }

    // Actualizar una clase
    public Clases updateClase(Long id, Clases clasesDetails) {
        Optional<Clases> clases = clasesRepository.findById(id);
        if (clases.isPresent()) {
            Clases existingClases = clases.get();
            existingClases.setName(clasesDetails.getName());
            existingClases.setDia(clasesDetails.getDia());
            existingClases.setHora_fin(clasesDetails.getHora_fin());
            existingClases.setHora_fin(clasesDetails.getHora_fin());
            return clasesRepository.save(existingClases);
        }
        return null;
    }

    // Eliminar una clase
    public void deleteClases(Long id) {
        clasesRepository.deleteById(id);
    }

}
