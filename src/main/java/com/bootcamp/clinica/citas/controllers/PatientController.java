package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.entities.Patient;
import com.bootcamp.clinica.citas.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> findAll(){
        System.out.println("call findALl");
        return this.patientService.findAll();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable("id") Long id){
        System.out.println("id = " + id);
        return this.patientService.findById(id);
    }

    @GetMapping("/find")
    public List<Patient> findByName(@RequestParam("name") String nombre){
        return this.patientService.findByName(nombre);
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient){
        return this.patientService.save(patient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.patientService.delete(id);
    }

}
