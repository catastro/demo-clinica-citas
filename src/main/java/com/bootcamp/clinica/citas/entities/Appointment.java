package com.bootcamp.clinica.citas.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="cita")
public class Appointment {
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

    @Column(name = "estado")
    private String status;
    @Column(name = "diagnostico")
    private String diagnosis;

//    @OneToMany( mappedBy = "appointment")
//    private List<Prescription> prescriptions;

    public String getStatus() {
        return status;
    }

    public void setStatus(String estado) {
        this.status = estado;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnostico) {
        this.diagnosis = diagnostico;
    }


    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

//    public List<Prescription> getPrescriptions() {
//        return prescriptions;
//    }
//
//    public void setPrescriptions(List<Prescription> prescriptions) {
//        this.prescriptions = prescriptions;
//    }
}
