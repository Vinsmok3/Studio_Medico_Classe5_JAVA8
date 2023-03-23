package it.studiomedico.entities;

import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public class Person {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @Column(name = "modify_on")
    private LocalDate modifyOn;

    @Column(name = "status")
    @Enumerated
    private RecordStatusENUM status;

    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(LocalDate modifyOn) {
        this.modifyOn = modifyOn;
    }

    public RecordStatusENUM getStatus() {
        return status;
    }

    public void setStatus(RecordStatusENUM status) {
        this.status = status;
    }
}
