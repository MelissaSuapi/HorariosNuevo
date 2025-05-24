package com.cesde.proyecto_integrador.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cesde.proyecto_integrador.model.Profesores;
import com.cesde.proyecto_integrador.service.impl.ProfesoresService;

@RestController
@RequestMapping("/api/profesores")
public class ProfesoresController {

    @Autowired
    private ProfesoresService profesoresService;

    @GetMapping
    public List<Profesores> getAllProfesores() {
        return profesoresService.getAllProfesores();
    }

    @GetMapping("/{id}")
    public Optional<Profesores> getProfesorById(@PathVariable Long id) {
        return profesoresService.getProfesorById(id);
    }

    @PostMapping
    public Profesores createProfesor(@RequestBody Profesores profesor) {
        return profesoresService.createProfesores(profesor);
    }

    @PutMapping("/{id}")
    public Profesores updateProfesor(@PathVariable Long id, @RequestBody Profesores profesorDetails) {
        return profesoresService.updateProfesores(id, profesorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProfesor(@PathVariable Long id) {
        profesoresService.deleteProfesor(id);
    }
}
