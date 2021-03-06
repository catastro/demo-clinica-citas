package com.bootcamp.clinica.citas.entities;

import javax.persistence.*;

@Entity
@Table(name ="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(unique = true , nullable = false)
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "numerocolegiatura")
    private String tuitionNumber ;
    private String dni;
    @Column(name = "edad")
    private Integer age;
    @Column(name = "especialidad")
    private String specialty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTuitionNumber() {
        return tuitionNumber;
    }

    public void setTuitionNumber(String tuitionNumber) {
        this.tuitionNumber = tuitionNumber;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tuitionNumber='" + tuitionNumber + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
