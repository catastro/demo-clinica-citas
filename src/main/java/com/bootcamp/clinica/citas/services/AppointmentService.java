package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();
    Appointment save(Appointment cita);

    Appointment findById(Long id);

    Appointment updateToAttendant(Long id, String diagnostico);
}
