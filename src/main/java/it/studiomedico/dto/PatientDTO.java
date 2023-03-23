package it.studiomedico.dto;

import it.studiomedico.entities.recordEnum.GenderENUM;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;

import java.time.LocalDate;

public class PatientDTO extends UserDTO{
    private Long idPatient;
    private String phoneNumber;
    private String fiscalCode;
    private GenderENUM gender;

    public PatientDTO(String name, String surname, String email, String createdBy, String modifiedBy, LocalDate createdOn, LocalDate modifyOn, RecordStatusENUM status,String phoneNumber, String fiscalCode, GenderENUM gender) {
        super(name, surname, email, createdBy, modifiedBy, createdOn, modifyOn,status);
        this.phoneNumber = phoneNumber;
        this.fiscalCode = fiscalCode;
        this.gender = gender;
    }

    public PatientDTO() {
        super();
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

    @Override
    public RecordStatusENUM getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(RecordStatusENUM status) {
        super.setStatus(status);
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
}
