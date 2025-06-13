package com.cesde.proyecto_integrador.repository;

import com.cesde.proyecto_integrador.model.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesoresRepository extends JpaRepository<Profesores, Long> {
    Optional<Profesores> findByEmail(String email);
}
