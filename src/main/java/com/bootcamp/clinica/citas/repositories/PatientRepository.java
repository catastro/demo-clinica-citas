package com.bootcamp.clinica.citas.repositories;

import com.bootcamp.clinica.citas.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE UPPER(name) LIKE CONCAT('%',UPPER(:#{#name}),'%')  ")
    List<Patient> find(String name);
}
