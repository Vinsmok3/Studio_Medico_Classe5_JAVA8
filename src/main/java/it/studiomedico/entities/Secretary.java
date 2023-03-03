package it.studiomedico.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "Secretary")

public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSecretary")
    private long idSecretary;

    @Column(name="Name", nullable = false)
    private String Name;

    @Column(name="Surname", nullable = false)
    private String Surname;

    @Column(name="Email", nullable = false, unique = true)
    private String Email;

    @Column(name="Workplace", nullable = false)
    private String Workplace;

    @Column(name="Working_Days", nullable = false)
    private WorkingDaysENUM Working_Days;

    public long getIdSecretary() {
        return idSecretary;
    }

    public void setIdSecretary(long idSecretary) {
        this.idSecretary = idSecretary;
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

    public Secretary(){
    }

    public Secretary(String name, String surname, String email, String workplace, WorkingDaysENUM working_Days) {
        Name = name;
        Surname = surname;
        Email = email;
        Workplace = workplace;
        Working_Days = working_Days;
    }

    @OneToMany
    private List<Doctor> doctorList;
}
