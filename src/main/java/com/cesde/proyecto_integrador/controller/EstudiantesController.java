package com.cesde.proyecto_integrador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesde.proyecto_integrador.model.Estudiantes;
import com.cesde.proyecto_integrador.service.impl.EstudiantesService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudiantesController {
    
    @Autowired
    private EstudiantesService estudiantesService;

    @GetMapping
    public List<Estudiantes> getAllEstudiantes() {
        return estudiantesService.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public Optional<Estudiantes> getEstudianteById(@PathVariable Long id) {
        return estudiantesService.getEstudianteById(id);
    }

    @PostMapping
    public Estudiantes createEstudiante(@RequestBody Estudiantes estudiante) {
      return estudiantesService.createEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiantes updateEstudiante(@PathVariable Long id, @RequestBody Estudiantes estudianteDetails) {
        return estudiantesService.updateEstudiante(id, estudianteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEstudiante(@PathVariable Long id) {
        estudiantesService.deleteEstudiante(id);
    }

}
