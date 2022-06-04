package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findByName(String nombre);
    List<Patient> findAll();
    Patient findById(Long id);
    Patient save(Patient doctor);
    void delete(Long id);
}
