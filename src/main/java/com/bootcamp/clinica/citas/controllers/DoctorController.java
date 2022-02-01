package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("doctores")
public class DoctorController {

    private DoctorService doctorService;

    DoctorController(DoctorService doctorService){
        this.doctorService= doctorService;
    }

    @GetMapping
    public List<Doctor> findAll(){
        System.out.println("call findALl");
        return this.doctorService.findAll();
    }

//    @GetMapping("/find")
//    public List<Doctor> find(){
//        System.out.println("find");
//        return this.doctorService.findAll();
//    }

    @GetMapping("/{id}")
    public Doctor findById(@PathVariable("id") Long id){
        System.out.println("id = " + id);
        return this.doctorService.findById(id);
    }

//    @GetMapping("/{edad}/{nombre}")
//    public Doctor findById(@PathVariable("edad") Long edad,@PathVariable("nombre") Long nombre ){
//        System.out.println("id = " + id);
//        return this.doctorService.findById(id);
//    }


    @GetMapping("/buscar")
    public List<Doctor> findByName(@RequestParam("nombre") String nombre,
                                   @RequestParam("especialidad") String especialidad){
        System.out.println("nombre = " + nombre);
        System.out.println("especialidad = " + especialidad);
        return this.doctorService.findByName(nombre);
    }

    @PostMapping
    public Doctor save(@RequestBody Doctor doctor){
        return this.doctorService.save(doctor);
    }
//
//    @PutMapping
//    public Doctor update(@RequestBody Doctor doctor){
//        return this.doctorService.save(doctor);
//    }

    @PatchMapping("/especialidad/{id}/{especialidad}")
    public Doctor update(@PathVariable("id") Long id, @PathVariable("especialidad") String especialidad){
        System.out.println("especialidad = " + especialidad);
        return this.doctorService.updateEspecialidad(id, especialidad);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.doctorService.delete(id);
    }

}
