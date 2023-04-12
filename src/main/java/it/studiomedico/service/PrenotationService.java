package it.studiomedico.service;

import it.studiomedico.dto.PrenotationDTO;
import it.studiomedico.entities.Prenotation;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import it.studiomedico.repositories.DoctorRepository;
import it.studiomedico.repositories.PatientRepository;
import it.studiomedico.repositories.PrenotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrenotationService {
    @Autowired
    PrenotationRepository prenotationRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

    public ResponseEntity<Prenotation> createPrenotation(Prenotation prenotation, Long idDoctor, Long idPatient) {
        if (doctorRepository.existsById(idDoctor)) {
            prenotation.setDoctor(doctorRepository.getReferenceById(idDoctor));
        } else {
            return new ResponseEntity("doctor not found", HttpStatus.NOT_FOUND);
        }
        if (patientRepository.existsById(idPatient)) {
            prenotation.setPatient(patientRepository.getReferenceById(idPatient));
        } else {
            return new ResponseEntity("patient not found", HttpStatus.NOT_FOUND);
        }
        LocalDateTime startTime = prenotation.getDate();
        LocalDateTime endTime = startTime.plusMinutes(30);
        List<Prenotation> prenotations = prenotationRepository.findByDoctor_IdDoctorAndDateBetween(idDoctor, startTime, endTime);
        if (!prenotations.isEmpty()) {
            return new ResponseEntity("there is already a prenotation within 30 minutes", HttpStatus.CONFLICT);
        }
        prenotation.setStatus(RecordStatusENUM.A);
        prenotation.setCreatedOn(LocalDateTime.now(Clock.systemDefaultZone()));
        return ResponseEntity.ok(prenotationRepository.save(prenotation));
    }



    public ResponseEntity<Prenotation> updatePrenotation(long id, PrenotationDTO prenotationDto) {
        if (prenotationRepository.existsById(id)) {
            Prenotation prenotation = prenotationRepository.findById(id).get();
            if (prenotationDto.getDate() != null) {
                prenotation.setDate(prenotationDto.getDate());
            }
            if (prenotationDto.getBookingStatus() != null) {
                prenotation.setStatusBooking(prenotationDto.getBookingStatus());
            }
            if (prenotationDto.getDoctorId() != null) {
                prenotation.setDoctor(doctorRepository.getReferenceById(prenotationDto.getDoctorId()));
            }
            if (prenotationDto.getPatientId() != null) {
                prenotation.setPatient(patientRepository.getReferenceById(prenotationDto.getPatientId()));
            }
            prenotation.setModifyOn(LocalDateTime.now(Clock.systemDefaultZone()));
            Prenotation updatedPrenotation = prenotationRepository.saveAndFlush(prenotation);
            return ResponseEntity.ok(updatedPrenotation);
        }
        return new ResponseEntity("Prenotation with id " + id + " not found", HttpStatus.NOT_FOUND);
    }

    public List<Prenotation> getAllPrenotations(){
        List<Prenotation> allprenotations = new ArrayList<>();
        allprenotations.addAll(prenotationRepository.findAll());
        return allprenotations;
    }

    public ResponseEntity deleteAllPrenotations(){
        prenotationRepository.findAll().forEach(prenotation -> {
            prenotation.setStatus(RecordStatusENUM.D);
            prenotationRepository.saveAndFlush(prenotation);
        });
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

