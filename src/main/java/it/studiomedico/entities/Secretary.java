package it.studiomedico.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "secretary")
public class Secretary extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secretary")
    private Long idSecretary;

    @Column(name = "workplace", nullable = false)
    private String workplace;

    @Column(name = "working_days", nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkingDaysENUM workingDays;


    @OneToMany(mappedBy = "secretary")
    private List<Doctor> doctorList;


    public Secretary(String name, String surname, String email, String workplace, WorkingDaysENUM workingDays) {
        super(name, surname, email);
        this.workplace = workplace;
        this.workingDays = workingDays;
    }

    public Secretary() {
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

    public Long getIdSecretary() {
        return idSecretary;
    }

    public void setIdSecretary(Long idSecretary) {
        this.idSecretary = idSecretary;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public WorkingDaysENUM getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(WorkingDaysENUM workingDays) {
        this.workingDays = workingDays;
    }
}
