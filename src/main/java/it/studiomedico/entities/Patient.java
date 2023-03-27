package it.studiomedico.entities;


import it.studiomedico.entities.recordEnum.GenderENUM;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient extends Person {

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


    public Patient(String name, String surname, String email, String fiscalCode, String phoneNumber, GenderENUM gender) {
        super(name, surname, email);
        this.fiscalCode=fiscalCode;
        this.phoneNumber=phoneNumber;
        this.gender=gender;
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

    @Override
    public String getCreatedBy() {
        return super.getCreatedBy();
    }

    @Override
    public void setCreatedBy(String createdBy) {
        super.setCreatedBy(createdBy);
    }

    @Override
    public String getModifiedBy() {
        return super.getModifiedBy();
    }

    @Override
    public void setModifiedBy(String modifiedBy) {
        super.setModifiedBy(modifiedBy);
    }

    @Override
    public LocalDate getCreatedOn() {
        return super.getCreatedOn();
    }

    @Override
    public void setCreatedOn(LocalDate createdOn) {
        super.setCreatedOn(createdOn);
    }

    @Override
    public LocalDate getModifyOn() {
        return super.getModifyOn();
    }

    @Override
    public void setModifyOn(LocalDate modifyOn) {
        super.setModifyOn(modifyOn);
    }

    @Override
    public RecordStatusENUM getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(RecordStatusENUM status) {
        super.setStatus(status);
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Prenotation> getPrenotationList() {
        return prenotationList;
    }

    public void setPrenotationList(List<Prenotation> prenotationList) {
        this.prenotationList = prenotationList;
    }
}


