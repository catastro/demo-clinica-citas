package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Appointment;
import com.bootcamp.clinica.citas.entities.Prescription;
import com.bootcamp.clinica.citas.entities.PrescriptionDetail;
import com.bootcamp.clinica.citas.repositories.AppointmentRepository;
import com.bootcamp.clinica.citas.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentSeviceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PrescriptionRepository recetaRepository;

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepository.findAll();
    }

    @Override
    public Appointment save(Appointment cita) {
        cita.setStatus("programado");
        return this.appointmentRepository.save(cita);
    }

    @Override
    public Appointment findById(Long id) {
        return this.appointmentRepository.findById(id).get();
    }

    @Override
    public Appointment updateToAttendant(Long id, String diagnostico) {
        var cita= this.appointmentRepository.findById(id).get();

        cita.setStatus("atendido");
        cita.setDiagnosis(diagnostico);

        this.appointmentRepository.save(cita);

        System.out.println("cita = " + cita);

        var receta = new Prescription();
        receta.setDoctor(cita.getDoctor());
        receta.setDatetime(cita.getDatetime());
        receta.setPaciente(cita.getPaciente());
//        receta.setAppointment(cita);

        List<PrescriptionDetail> detalles = new ArrayList<>();
        var recetaDetalle= new PrescriptionDetail();
        recetaDetalle.setProducto("Amoxicilina");
        recetaDetalle.setCantidad(10);
        recetaDetalle.setIndicaciones("1 cada 8 horas");
        recetaDetalle.setId(0L);
        detalles.add(recetaDetalle);

        receta.setDetails(detalles);

        this.recetaRepository.save(receta);


        return cita;
    }
}
