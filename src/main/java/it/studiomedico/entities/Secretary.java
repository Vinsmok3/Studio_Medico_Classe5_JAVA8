package it.studiomedico.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Secretary")
public class Secretary extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSecretary;

    @Column(nullable = false)
    private String workplace;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkingDaysENUM workingDays;


    @OneToMany(mappedBy = "secretary")
    private List<Doctor> doctorList;


    public Secretary(String name, String surname, String email, String workplace, WorkingDaysENUM working_days) {
        super(name, surname, email);
        this.workplace = workplace;
        this.workingDays = working_days;
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

    public long getIdSecretary() {
        return idSecretary;
    }

    public void setIdSecretary(long idSecretary) {
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
