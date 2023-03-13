package it.studiomedico.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Doctor")
public class Doctor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDoctor;
    @Column(nullable = false)
    private String workplace;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkingDaysENUM working_days;
    @Column(nullable = false)
    private String specialization;

    @ManyToOne
    @JoinColumn(name = "idSecretary")
    private Secretary secretary;

    @OneToMany
    private List<Prenotation> prenotationList;

    @OneToMany
    private List<Patient> patientList;

    public Doctor(String name, String surname, String email, String workplace, WorkingDaysENUM working_Days, String specialization) {
        super(name, surname, email);
        this.workplace = workplace;
        this.working_days = working_Days;
        this.specialization = specialization;
    }

    public Doctor() {
        super();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
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

    public WorkingDaysENUM getWorking_days() {
        return working_days;
    }

    public void setWorking_days(WorkingDaysENUM working_days) {
        this.working_days = working_days;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
