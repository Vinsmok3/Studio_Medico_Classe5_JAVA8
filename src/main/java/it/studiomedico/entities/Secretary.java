package it.studiomedico.entities;

import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "secretary")
public class Secretary extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secretary")
    private Long idSecretary;

    @Column(name = "workplace", nullable = false)
    private String workplace;

    @OneToMany(mappedBy = "secretary")
    private List<Doctor> doctorList;


    public Secretary(String name, String surname, String email, String workplace) {
        super(name, surname, email);
        this.workplace=workplace;
    }

    public Secretary() {
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

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
