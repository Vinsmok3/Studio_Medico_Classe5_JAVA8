package it.studiomedico.dto;

import it.studiomedico.entities.recordEnum.RecordStatusENUM;

import java.time.LocalDate;

public class SecretaryDTO extends UserDTO {
    private Long idSecretary;
    private String workplace;

    public SecretaryDTO() {
    }

    public SecretaryDTO(String name, String surname, String email, String createdBy, String modifiedBy, LocalDate createdOn, LocalDate modifyOn, RecordStatusENUM status, String phoneNumber, String workplace) {
        super(name, surname, email, createdBy, modifiedBy, createdOn, modifyOn, status, phoneNumber);
        this.workplace = workplace;
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
}
