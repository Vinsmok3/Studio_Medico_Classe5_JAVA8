package it.studiomedico.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patient")
public class Patient extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    @Column(name = "phoneNumber", nullable = false)
    private String phonenumber;

    @Column(name = "fiscal_Code", nullable = false)
    private String fiscalCode;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderENUM gender;


    @ManyToOne
    @JoinColumn(name = "idDoctor")
    private Doctor doctor;
    @OneToMany(mappedBy = "patient")
    private List<Prenotation> prenotationList;


    public Patient(String name, String surname, String email, String phonenumber, String fiscalCode, GenderENUM gender) {
        super(name, surname, email);
        this.phonenumber = phonenumber;
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

    public long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(long idPatient) {
        this.idPatient = idPatient;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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


