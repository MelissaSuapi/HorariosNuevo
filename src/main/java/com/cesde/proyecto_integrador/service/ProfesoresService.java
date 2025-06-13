package com.cesde.proyecto_integrador.service;

import com.cesde.proyecto_integrador.model.Profesores;
import com.cesde.proyecto_integrador.repository.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesoresService {

    @Autowired
    private ProfesoresRepository repository;

    public List<Profesores> findAll() {
        return repository.findAll();
    }

    public Optional<Profesores> findById(Long id) {
        return repository.findById(id);
    }

    public Profesores save(Profesores profesor) {
        return repository.save(profesor);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<Profesores> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}

