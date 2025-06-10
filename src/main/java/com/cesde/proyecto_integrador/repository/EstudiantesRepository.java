package com.cesde.proyecto_integrador.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cesde.proyecto_integrador.model.Estudiantes;

public interface EstudiantesRepository extends JpaRepository<Estudiantes, Long> {
    Optional<Estudiantes> findByEmail(String email);
}
