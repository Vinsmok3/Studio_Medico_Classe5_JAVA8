package it.studiomedico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long idDoctor;
    @Column(name = "workplace", nullable = false)
    private String workplace;
    @Column(name = "specialization", nullable = false)
    private String specialization;


    @ManyToOne
    @JoinColumn(name = "id_secretary")
    @JsonIgnore
    private Secretary secretary;

    @OneToMany(mappedBy = "doctor")
    private List<Prenotation> prenotationList;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patientList;

    public Doctor() {
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    public List<Prenotation> getPrenotationList() {
        return prenotationList;
    }

    public void setPrenotationList(List<Prenotation> prenotationList) {
        this.prenotationList = prenotationList;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
