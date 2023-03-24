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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PrenotationService {
    @Autowired
    PrenotationRepository prenotationRepository;
    @Autowired
    DoctorRepository doctorRepository;


    public ResponseEntity deleteById(@PathVariable Long id) {
        if (doctorRepository.existsById(id)) {
            Doctor doctor = doctorRepository.findById(id).get();
            doctor.setStatus(RecordStatusENUM.D);
            doctorRepository.saveAndFlush(doctor);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("no doctor exist with id " + id, HttpStatus.NOT_FOUND);
        }
    }
}

