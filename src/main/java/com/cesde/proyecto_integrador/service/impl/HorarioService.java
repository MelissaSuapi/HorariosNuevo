package com.cesde.proyecto_integrador.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cesde.proyecto_integrador.model.Horarios;
import com.cesde.proyecto_integrador.repository.HorarioRepository;
@Service
public class HorarioService {
     
    @Autowired
    private HorarioRepository horarioRepository;

    // Obtener todos los horarios
    public List<Horarios> getAllHorarios() {
        return horarioRepository.findAll();
    }

    // Obtener un horario por ID
    public Optional<Horarios> getHorarioById(Long id) {
        return horarioRepository.findById(id);
    }

    // Crear un nuevo horario
    public Horarios createHorario(Horarios horario) {
        return horarioRepository.save(horario);
    }

    // Eliminar un horario
    public void deleteHorario(Long id) {
        horarioRepository.deleteById(id);
    }

    public Horarios updateHorario(Long id, Horarios horarioDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateHorario'");
    }



}
