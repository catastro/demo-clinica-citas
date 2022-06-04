package com.bootcamp.clinica.citas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="receta")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(unique = true , nullable = false)
    private Long id;
    @Column(name = "fechahora")
    private Date datetime;
    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne()
    @JoinColumn(name = "paciente_id")
    private Patient patient;

    @ManyToOne()
    @JoinColumn(name = "cita_id")
    private Appointment appointment;

    @OneToMany( mappedBy = "prescription")
    private List<PrescriptionDetail> details;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPaciente() {
        return patient;
    }

    public void setPaciente(Patient patient) {
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public List<PrescriptionDetail> getDetails() {
        return details;
    }

    public void setDetails(List<PrescriptionDetail> details) {
        this.details = details;
    }


    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}
