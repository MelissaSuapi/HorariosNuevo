package com.cesde.proyecto_integrador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cesde.proyecto_integrador.model.Clases;
import com.cesde.proyecto_integrador.service.impl.ClasesService;

@RestController
@RequestMapping("/api/clases")
public class ClasesController {

    @Autowired
    private ClasesService clasesService;

    // Obtener todas las clases
    @GetMapping
    public List<Clases> getAllClases() {
        return clasesService.getAllClases();
    }

    // Obtener clase por ID
    @GetMapping("/{id}")
    public Optional<Clases> getClaseById(@PathVariable Long id) {
        return clasesService.getClaseById(id);
    }

    // Crear una nueva clase
    @PostMapping
    public Clases createClase(@RequestBody Clases clase) {
        return clasesService.createClase(clase);
    }

    // Actualizar una clase existente
    @PutMapping("/{id}")
    public Clases updateClase(@PathVariable Long id, @RequestBody Clases claseDetails) {
        return clasesService.updateClase(id, claseDetails);
    }

    // Eliminar una clase
    @DeleteMapping("/{id}")
    public void deleteClase(@PathVariable Long id) {
        clasesService.deleteClases(id);
    }
}
