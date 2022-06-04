package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Patient;
import com.bootcamp.clinica.citas.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findByName(String nombre) {
        return this.patientRepository.find(nombre);
    }

    @Override
    public List<Patient> findAll() {
        return this.patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return this.patientRepository.findById(id).get();
    }

    @Override
    public Patient save(Patient doctor) {
        return this.patientRepository.save(doctor);
    }

    @Override
    public void delete(Long id) {
        this.patientRepository.deleteById(id);
    }
}
