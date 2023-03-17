package it.studiomedico.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patient")
public class Patient extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Long idPatient;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "fiscal_code", nullable = false)
    private String fiscalCode;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderENUM gender;


    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;
    @OneToMany(mappedBy = "patient")
    private List<Prenotation> prenotationList;


    public Patient(String name, String surname, String email, String phoneNumber, String fiscalCode, GenderENUM gender) {
        super(name, surname, email);
        this.phoneNumber = phoneNumber;
        this.fiscalCode = fiscalCode;
        this.gender = gender;
    }

    public Patient() {
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
    public String getSurname(String surname) {
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

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public GenderENUM getGender() {
        return gender;
    }

    public void setGender(GenderENUM gender) {
        this.gender = gender;
    }


}


