package it.studiomedico.controllers;

import it.studiomedico.dto.PatientDTO;
import it.studiomedico.entities.Patient;
import it.studiomedico.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    //Creating a patient
    @PostMapping("/create")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
       return patientService.createPatient(patient);
    }

    //Reading a patient
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patient>> getPatient(@PathVariable Long id){
        return patientService.getPatient(id);
    }

    //Reading all patients
    @GetMapping("/readAll")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    //Update a patient
    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO){
        return patientService.updatePatient(id, patientDTO);
    }

    //Delete a patient
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id){
        return patientService.deletePatient(id);
    }

    //Delete all patients
    @DeleteMapping("/deleteAll")
    public void deleteAllPatients(){
        patientService.deleteAllPatients();
    }




}










