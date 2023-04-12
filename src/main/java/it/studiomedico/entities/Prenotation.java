package it.studiomedico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.studiomedico.entities.recordEnum.BookingENUM;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "prenotation")
public class Prenotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prenotation")
    private Long idPrenotation;

    @Column(name = "prenotation_date", nullable = false)
    private LocalDateTime date;

    @Column(name = "booking_status")
    private BookingENUM statusBooking;

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


    @ManyToOne
    @JoinColumn(name = "ext_id_patient", nullable = false)
    @JsonIgnore
    private Patient patient;


    @ManyToOne
    @JoinColumn(name = "ext_id_doctor", nullable = false)
    @JsonIgnore
    private Doctor doctor;


    public Prenotation(LocalDateTime date, BookingENUM statusBooking, String createdBy, String modifiedBy, LocalDate createdOn, LocalDate modifyOn, RecordStatusENUM status, Patient patient, Doctor doctor) {
        this.date = date;
        this.statusBooking = statusBooking;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdOn = createdOn;
        this.modifyOn = modifyOn;
        this.status = status;
        this.patient = patient;
        this.doctor = doctor;
    }
    public Prenotation(){}

    public Long getIdPrenotation() {
        return idPrenotation;
    }

    public void setIdPrenotation(Long idPrenotation) {
        this.idPrenotation = idPrenotation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BookingENUM getStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(BookingENUM statusBooking) {
        this.statusBooking = statusBooking;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
