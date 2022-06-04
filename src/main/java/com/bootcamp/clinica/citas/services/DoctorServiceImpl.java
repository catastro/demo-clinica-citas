package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.exception.NotFoundException;
import com.bootcamp.clinica.citas.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Doctor updateEspecialidad(Long id, String specialty) {
        Optional<Doctor> doctor = this.doctorRepository.findById(id);

        if (doctor.isPresent()){
            var doctorGet = doctor.get();
            doctorGet.setSpecialty(specialty);
            return this.doctorRepository.save(doctorGet);
        } else {
            throw new NotFoundException("Doctor no existe");
        }

    }

    @Override
    public void delete(Long id) {
        this.doctorRepository.deleteById(id);
    }
}
