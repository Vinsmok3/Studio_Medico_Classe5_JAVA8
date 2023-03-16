package it.studiomedico.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="prenotation")
public class Prenotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prenotation")
    private Long idPrenotation;

    @Column(name = "prenotation_date", nullable = false)
    private LocalDateTime date;

    @Column(name = "status")
    private StatusENUM status;


    @ManyToOne
    @JoinColumn(name = "ext_id_patient", nullable = false)
    private Patient patient;


    @ManyToOne
    @JoinColumn(name = "ext_id_doctor", nullable = false)
    private Doctor doctor;

    public Prenotation(LocalDateTime date, StatusENUM status, Patient patient, Doctor doctor) {
        this.date = date;
        this.status = status;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Prenotation(){}

    public Long getIdPrenotation() {
        return idPrenotation;
    }

    public void setIdPrenotation(Long idPrenotation) {
        this.idPrenotation = idPrenotation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public StatusENUM getStatus() {
        return status;
    }

    public void setStatus(StatusENUM status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
