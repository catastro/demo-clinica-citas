package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Paciente;

import java.util.List;

public interface PacienteService {

    List<Paciente> findByName(String nombre);
    List<Paciente> findAll();
    Paciente findById(Long id);
    Paciente save(Paciente Paciente);
    void delete(Long id);
    Paciente udapteDni(Long id, String dni);
}
