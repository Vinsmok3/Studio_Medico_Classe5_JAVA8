package it.studiomedico.dto;

import it.studiomedico.entities.recordEnum.RecordStatusENUM;

import java.time.LocalDate;

public class DoctorDTO extends UserDTO{
    private Long idDoctor;
    private String workplace;
    private String specialization;


    public DoctorDTO(String name, String surname, String email, String createdBy, String modifiedBy, LocalDate createdOn, LocalDate modifyOn, RecordStatusENUM status,String workplace, String specialization) {
        super(name, surname, email, createdBy, modifiedBy, createdOn, modifyOn, status);
        this.workplace=workplace;
        this.specialization=specialization;

    }

    public DoctorDTO() {
        super();
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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
