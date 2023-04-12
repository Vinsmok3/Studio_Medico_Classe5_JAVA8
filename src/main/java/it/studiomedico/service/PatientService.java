package it.studiomedico.service;


import it.studiomedico.dto.PatientDTO;
import it.studiomedico.entities.Patient;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import it.studiomedico.repositories.DoctorRepository;
import it.studiomedico.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public ResponseEntity<Patient> createPatient(Patient patient){
        patient.setStatus(RecordStatusENUM.A);
        patient.setCreatedOn(LocalDateTime.now(Clock.systemDefaultZone()));
        patientRepository.save(patient);
        return ResponseEntity.status(201).body(patient);
    }

    public ResponseEntity<Optional<Patient>> getPatient (Long id) {
        if (patientRepository.existsById(id)) {
            Optional<Patient> patient = patientRepository.findById(id);
            return ResponseEntity.ok().body(patient);
        }
        return new ResponseEntity("no patient exists whith id: " + id, HttpStatus.NOT_FOUND);
    }

    public List<Patient> getAllPatients(){
        List<Patient> allPatients = new ArrayList<>();
        allPatients.addAll(patientRepository.findAll());
        return allPatients;
    }

    public ResponseEntity<Patient> updatePatient(Long id, PatientDTO patientDTO) {
        Optional<Patient> patientUpdate = patientRepository.findById(id);
        if (patientUpdate.isPresent()) {
            Patient patient = patientUpdate.get();
            patient.setName(patientDTO.getName());
            patient.setSurname(patientDTO.getSurname());
            patient.setEmail(patientDTO.getEmail());
            patient.setPhoneNumber(patientDTO.getPhoneNumber());
            patient.setFiscalCode(patientDTO.getFiscalCode());
            patient.setGender(patientDTO.getGender());
            patient.setModifyOn(LocalDateTime.now(Clock.systemDefaultZone()));
            patientRepository.saveAndFlush(patient);
            return ResponseEntity.ok().body(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity deletePatient (Long id) {
        if (patientRepository.existsById(id)) {
            Patient patient = patientRepository.findById(id).get();
            patient.setStatus(RecordStatusENUM.D);
            patientRepository.saveAndFlush(patient);
            return new ResponseEntity("successfully deleted", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("no patient with the id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity deleteAllPatients() {
        patientRepository.findAll().forEach(patient -> {
            patient.setStatus(RecordStatusENUM.D);
            patientRepository.saveAndFlush(patient);
        });
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Patient> assignDoctor(Long patientId, Long doctorId) {
        if (patientRepository.existsById(patientId) && doctorRepository.existsById(doctorId)) {
            Patient patient = patientRepository.findById(patientId).get();
            patient.setDoctor(doctorRepository.findById(doctorId).get());
            Patient updatedPatient = patientRepository.saveAndFlush(patient);
            return ResponseEntity.ok(updatedPatient);
        }
        return new ResponseEntity("no patient found with id:" + patientId, HttpStatus.NOT_FOUND);
    }


}
