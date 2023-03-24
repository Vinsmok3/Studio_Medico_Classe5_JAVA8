package it.studiomedico.service;

import it.studiomedico.entities.Doctor;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import it.studiomedico.repositories.DoctorRepository;
import it.studiomedico.repositories.PatientRepository;
import it.studiomedico.repositories.PrenotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PrenotationService {
    @Autowired
    PrenotationRepository prenotationRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    RecordStatusENUM recordStatusENUM;

    public ResponseEntity deleteById(Long id) {
        if (doctorRepository.existsById(id)) {
            Doctor doctor = doctorRepository.findById(id).get();
            doctor.setStatus(recordStatusENUM.D);
            doctorRepository.saveAndFlush(doctor);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("no doctor exist with id " + id, HttpStatus.NOT_FOUND);
        }
    }
}

