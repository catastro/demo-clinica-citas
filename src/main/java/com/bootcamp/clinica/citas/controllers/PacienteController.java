package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.entities.Paciente;
import com.bootcamp.clinica.citas.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findByIdResponse(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<Paciente>(pacienteService.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity("404", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/buscar")
    public List<Paciente> findByName(@RequestParam("nombre") String nombre){
        return this.pacienteService.findByName(nombre);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Paciente paciente){
        this.pacienteService.save(paciente);
        return new ResponseEntity<String>("Se registro con exito al paciente "+paciente.getNombre(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.pacienteService.delete(id);
    }

    @PatchMapping("/dni/{id}/{dni}")
    public Paciente update(@PathVariable("id") Long id, @PathVariable("dni") String dni){
        return this.pacienteService.udapteDni(id, dni);
    }
}
