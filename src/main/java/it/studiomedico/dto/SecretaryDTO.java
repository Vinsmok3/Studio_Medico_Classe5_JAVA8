package it.studiomedico.dto;

import it.studiomedico.entities.WorkingDaysENUM;

public class SecretaryDTO extends UserDTO{
    private Long idSecretary;
    private String workplace;
    private WorkingDaysENUM workingDays;

    public SecretaryDTO(String name, String surname, String email, String workplace, WorkingDaysENUM workingDays) {
        super(name, surname, email);
        this.workplace = workplace;
        this.workingDays = workingDays;
    }

    public SecretaryDTO() {
        super();
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
