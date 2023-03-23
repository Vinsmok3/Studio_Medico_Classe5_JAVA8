package it.studiomedico.dto;

import it.studiomedico.entities.recordEnum.GenderENUM;

public class PatientDTO extends UserDTO{
    private Long idPatient;
    private String phoneNumber;
    private String fiscalCode;
    private GenderENUM gender;

    public PatientDTO(String name, String surname, String email, String phonenumber, String fiscalCode, GenderENUM gender) {
        super(name, surname, email);
        this.phoneNumber = phonenumber;
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
}
