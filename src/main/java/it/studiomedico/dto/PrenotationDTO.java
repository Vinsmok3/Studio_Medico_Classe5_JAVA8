package it.studiomedico.dto;

import it.studiomedico.entities.recordEnum.BookingENUM;

import java.time.LocalDateTime;

public class PrenotationDTO {
    private Long idPrenotation;
    private LocalDateTime date;
    private BookingENUM status;
    private PatientDTO patientDTO;
    private DoctorDTO doctorDTO;

    public PrenotationDTO(LocalDateTime date, BookingENUM status, PatientDTO patientDTO, DoctorDTO doctorDTO) {
        this.date = date;
        this.status = status;
        this.patientDTO = patientDTO;
        this.doctorDTO = doctorDTO;
    }
    public PrenotationDTO(){}


    public Long getIdPrenotation() {
        return idPrenotation;
    }

    public void setIdPrenotation(long idPrenotation) {
        this.idPrenotation = idPrenotation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BookingENUM getStatus() {
        return status;
    }

    public void setStatus(BookingENUM status) {
        this.status = status;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }
}
