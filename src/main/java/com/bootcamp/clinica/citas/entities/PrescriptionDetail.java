package com.bootcamp.clinica.citas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity()
@Table(name ="recetadetalle")
public class PrescriptionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(unique = true , nullable = false)
    private Long id;
    private String producto;
    private Integer cantidad;
    private String indicaciones;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id", name = "receta_id")
    private Prescription prescription;

    public PrescriptionDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public Prescription getReceta() {
        return prescription;
    }

    public void setReceta(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "RecetaDetalle{" +
                "id=" + id +
                ", producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                ", indicaciones='" + indicaciones + '\'' +
                '}';
    }

}
