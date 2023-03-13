package it.studiomedico.controllers;

import it.studiomedico.entities.Doctor;
import it.studiomedico.repositories.DoctorRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    //Create
    @PostMapping("/create")
    public Doctor create(@RequestBody Doctor doctor){
        return doctorRepository.saveAndFlush(doctor);
    }

    // Read All
    @GetMapping("/alldoctor")
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }


    // Read One
    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable long id){
        return doctorRepository.existsById(id)
                ? doctorRepository.getById(id)
                : new Doctor();
    }

    // UpdateWorkplace
    @PutMapping("/{id}")
    public Doctor updateDoctorWorkplace(@PathVariable long id, @RequestParam String Workplace){
        Doctor doctor;
        if (doctorRepository.existsById(id)){
            doctor = doctorRepository.getById(id);
            doctor.setWorkplace(Workplace);
            doctor = doctorRepository.saveAndFlush(doctor);
        }else{
            doctor = new Doctor();
        }
        return doctor;
    }

    // UpdateSpecialization
    @PutMapping("/{id}")
    public Doctor updateDoctorSpecialization(@PathVariable long id, @RequestParam String Specialization){
        Doctor doctor;
        if (doctorRepository.existsById(id)){
            doctor = doctorRepository.getById(id);
            doctor.setSpecialization(Specialization);
            doctor = doctorRepository.saveAndFlush(doctor);
        }else{
            doctor = new Doctor();
        }
        return doctor;
    }

    // Delete a specific Doctor
    @DeleteMapping("/{id}")
    public void deleteSingle(@PathVariable long id, HttpServletResponse response){
        if (doctorRepository.existsById(id))
            doctorRepository.deleteById(id);
        else
            response.setStatus(409);
    }

    // Delete all
    @DeleteMapping("")
    public void deleteAll(){
        doctorRepository.deleteAll();
    }
}
