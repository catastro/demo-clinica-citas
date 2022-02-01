package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Paciente;
import com.bootcamp.clinica.citas.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private PacienteRepository repository;

    @Override
    public List<Paciente> findByName(String nombre) {
        return repository.findByName(nombre);
    }

    @Override
    public List<Paciente> findAll() {
        return repository.findAll();
    }

    @Override
    public Paciente findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Paciente save(Paciente paciente) {
        return repository.save(paciente);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Paciente udapteDni(Long id, String dni) {
        var paciente = this.repository.findById(id).get();
        paciente.setDni(dni);
        return this.repository.save(paciente);
    }
}
