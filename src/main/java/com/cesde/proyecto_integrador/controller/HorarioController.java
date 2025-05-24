package com.cesde.proyecto_integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cesde.proyecto_integrador.model.Horarios;
import com.cesde.proyecto_integrador.service.impl.HorarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    // Obtener todos los horarios
    @GetMapping
    public List<Horarios> getAllHorarios() {
        return horarioService.getAllHorarios();
    }

    // Obtener horario por ID
    @GetMapping("/{id}")
    public Optional<Horarios> getHorarioById(@PathVariable Long id) {
        return horarioService.getHorarioById(id);
    }

    // Crear un nuevo horario
    @PostMapping
    public Horarios createHorario(@RequestBody Horarios horarios) {
        return horarioService.createHorario(horarios);
    }

    // Actualizar un horario existente
    @PutMapping("/{id}")
    public Horarios updateHorario(@PathVariable Long id, @RequestBody Horarios horarioDetails) {
        return horarioService.updateHorario(id, horarioDetails);
    }

    // Eliminar un horario
    @DeleteMapping("/{id}")
    public void deleteHorario(@PathVariable Long id) {
        horarioService.deleteHorario(id);
    }
}
