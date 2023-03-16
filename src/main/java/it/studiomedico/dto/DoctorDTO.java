package it.studiomedico.dto;

import it.studiomedico.entities.WorkingDaysENUM;


public class DoctorDTO extends UserDTO{
    private Long idDoctor;
    private String workplace;
    private WorkingDaysENUM workingdays;
    private String specialization;

    public DoctorDTO(String name, String surname, String email, String workplace, WorkingDaysENUM workingdays, String specialization) {
        super(name, surname, email);
        this.workplace = workplace;
        this.workingdays = workingdays;
        this.specialization = specialization;
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

    public WorkingDaysENUM getWorkingdays() {
        return workingdays;
    }

    public void setWorkingdays(WorkingDaysENUM workingdays) {
        this.workingdays = workingdays;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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
