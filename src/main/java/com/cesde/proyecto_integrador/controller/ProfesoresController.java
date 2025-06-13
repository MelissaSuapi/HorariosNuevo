package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.model.Profesores;
import com.cesde.proyecto_integrador.service.ProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class ProfesoresController {

    @Autowired
    private ProfesoresService service;

    @GetMapping
    public List<Profesores> getAllProfesores() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Profesores> getProfesorById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Profesores createProfesor(@RequestBody Profesores profesor) {
        return service.save(profesor);
    }

    @PutMapping("/{id}")
    public Profesores updateProfesor(@PathVariable Long id, @RequestBody Profesores profesor) {
        Optional<Profesores> existing = service.findById(id);
        if (existing.isPresent()) {
            profesor.setId_profesores(id);
            return service.save(profesor);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProfesor(@PathVariable Long id) {
        service.deleteById(id);
    }
}
