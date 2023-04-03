package it.studiomedico.service;

import it.studiomedico.dto.PrenotationDTO;
import it.studiomedico.entities.Doctor;
import it.studiomedico.entities.Prenotation;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import it.studiomedico.repositories.DoctorRepository;
import it.studiomedico.repositories.PatientRepository;
import it.studiomedico.repositories.PrenotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    public ResponseEntity<Prenotation> createPrenotation(Prenotation prenotation, long doctorId, long patientId) {
        if (doctorRepository.existsById(doctorId)) {
            prenotation.setDoctor(doctorRepository.getReferenceById(doctorId));
        } else {
            return new ResponseEntity("doctor not found", HttpStatus.NOT_FOUND);
        }
        if (patientRepository.existsById(patientId)) {
            prenotation.setPatient(patientRepository.getReferenceById(patientId));
        } else {
            return new ResponseEntity("patient not found", HttpStatus.NOT_FOUND);
        }
        prenotation.setStatus(RecordStatusENUM.A);
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

