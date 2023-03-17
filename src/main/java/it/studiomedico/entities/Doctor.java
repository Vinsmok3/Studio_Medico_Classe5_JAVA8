package it.studiomedico.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long idDoctor;
    @Column(name = "workplace", nullable = false)
    private String workplace;
    @Column(name = "working_days", nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkingDaysENUM workingdays;
    @Column(name = "specialization", nullable = false)
    private String specialization;


    @ManyToOne
    @JoinColumn(name = "id_secretary")
    private Secretary secretary;

    @OneToMany(mappedBy = "doctor")
    private List<Prenotation> prenotationList;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patientList;


    public Doctor(String name, String surname, String email, String workplace, WorkingDaysENUM workingdays, String specialization) {
        super(name, surname, email);
        this.workplace = workplace;
        this.workingdays = workingdays;
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

    public String getSurname() {
        return super.getSurname(surname);
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

    public WorkingDaysENUM getWorkingdays() {
        return workingdays;
    }

    public void setWorkingdays(WorkingDaysENUM workingdays) {
        this.workingdays = workingdays;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
