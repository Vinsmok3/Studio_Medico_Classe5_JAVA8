package it.studiomedico.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Doctor")
public class Doctor {
    @Id
    @Column(name="idDoctor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctor;
    @Column(name="Name", nullable = false)
    private String Name;
    @Column(name="Surname", nullable = false)
    private String Surname;
    @Column(name="Email", nullable = false, unique = true)
    private String Email;
    @Column(name="Workplace", nullable = false)
    private String Workplace;
    @Column(name="Working_Days", nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkingDaysENUM Working_Days;
    @Column(name="Specialization", nullable = false)
    private String Specialization;

    @ManyToOne
    @JoinColumn(name = "idSecretary")
    private Secretary secretary;

    @OneToMany
    private List<Prenotation> prenotationList;

    @OneToMany
    private List<Patient> patientList;

    public Doctor() {
    }

    public Doctor(String name, String surname, String email, String workplace, WorkingDaysENUM working_Days, String specialization) {
        Name = name;
        Surname = surname;
        Email = email;
        Workplace = workplace;
        Working_Days = working_Days;
        Specialization = specialization;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWorkplace() {
        return Workplace;
    }

    public void setWorkplace(String workplace) {
        Workplace = workplace;
    }

    public WorkingDaysENUM getWorking_Days() {
        return Working_Days;
    }

    public void setWorking_Days(WorkingDaysENUM working_Days) {
        Working_Days = working_Days;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }
}
