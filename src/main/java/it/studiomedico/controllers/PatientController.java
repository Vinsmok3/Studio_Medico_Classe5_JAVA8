package it.studiomedico.controllers;

import it.studiomedico.dto.PatientDTO;
import it.studiomedico.entities.Patient;
import it.studiomedico.service.PatientService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    //Creating patient
    @PostMapping("/createPatient")
    public PatientDTO create(@RequestBody PatientDTO patient){
       return patientService.postPatient(patient);
    }

    //Reading all patients
    @GetMapping("/getAll")
    public List<Patient> getAllPatients(){
        return patientService.allPatients();
    }

    // Reading a patient
    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable ("id") long id){
        return patientService.getPatient(id);
    }

    // Delete a patient
    @DeleteMapping("/{id}")
    public void deleteSingle(@PathVariable("id") long id, HttpServletResponse response){
        patientService.deletePatient(id);
    }

    // Delete all patients
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        patientService.deleteAllPatient();
    }
}










