package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;
    public DoctorServiceImpl( DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    @Override
    public List<Doctor> findByName(String nombre) {
        return this.doctorRepository.find(nombre);
    }

    @Override
    public List<Doctor> findAll() {
        return this.doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        return  this.doctorRepository.findById(id).get();
    }

    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateEspecialidad(Long id, String especialidad) {
        var doctor = this.doctorRepository.findById(id).get();
        doctor.setEspecialidad(especialidad);
        return this.doctorRepository.save(doctor);
    }

    @Override
    public void delete(Long id) {
        this.doctorRepository.deleteById(id);
    }
}
