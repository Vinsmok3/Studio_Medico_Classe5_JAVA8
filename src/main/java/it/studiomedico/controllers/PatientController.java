package it.studiomedico.controllers;

import it.studiomedico.entities.Doctor;
import it.studiomedico.entities.Patient;
import it.studiomedico.repositories.PatientRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    //Creating patient
    @PostMapping("/createPatient")
    public Patient create(@RequestBody Patient patient){
        return patientRepository.saveAndFlush(patient);
    }

    //Reading all patients
    @GetMapping("/getAll")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    // Reading a patient
    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable long id){
        return patientRepository.existsById(id)
                ? patientRepository.getById(id)
                : new Patient();
    }

    // Delete a patient
    @DeleteMapping("/{id}")
    public void deleteSingle(@PathVariable long id, HttpServletResponse response){
        if (patientRepository.existsById(id))
            patientRepository.deleteById(id);
        else
            response.setStatus(409);
    }

    // Delete all patients
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        patientRepository.deleteAll();
    }
}










