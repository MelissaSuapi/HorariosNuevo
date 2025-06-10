package com.cesde.proyecto_integrador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cesde.proyecto_integrador.model.Estudiantes;
import com.cesde.proyecto_integrador.service.impl.EstudiantesService;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudiantesController {

    @Autowired
    private EstudiantesService estudiantesService;

    // DTO para login
    public static class LoginRequest {
        public String email;
        public String password;
    }

    // DTO para respuesta segura
    public static class EstudianteDTO {
        public Long id;
        public String nombre;
        public String email;

        public EstudianteDTO(Estudiantes estudiante) {
            this.id = estudiante.getId_estudiante();
            this.nombre = estudiante.getNombre();
            this.email = estudiante.getEmail();
        }
    }

    @GetMapping
    public List<Estudiantes> getAllEstudiantes() {
        return estudiantesService.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiantes> getEstudianteById(@PathVariable Long id) {
        Optional<Estudiantes> estudiante = estudiantesService.getEstudianteById(id);
        return estudiante.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> createEstudiante(@RequestBody Estudiantes estudiante) {
        Estudiantes creado = estudiantesService.createEstudiante(estudiante);
        return ResponseEntity.ok(new EstudianteDTO(creado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> updateEstudiante(@PathVariable Long id, @RequestBody Estudiantes estudianteDetails) {
        Estudiantes actualizado = estudiantesService.updateEstudiante(id, estudianteDetails);
        if (actualizado != null) {
            return ResponseEntity.ok(new EstudianteDTO(actualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        estudiantesService.deleteEstudiante(id);
        return ResponseEntity.noContent().build();
    }

    // 🔐 LOGIN
    @PostMapping("/login")
    public ResponseEntity<EstudianteDTO> login(@RequestBody LoginRequest request) {
        Estudiantes estudiante = estudiantesService.login(request.email, request.password);
        if (estudiante != null) {
            return ResponseEntity.ok(new EstudianteDTO(estudiante));
        } else {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }
}
