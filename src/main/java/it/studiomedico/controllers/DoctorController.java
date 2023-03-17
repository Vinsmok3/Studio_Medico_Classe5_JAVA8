package it.studiomedico.controllers;

import it.studiomedico.dto.DoctorDTO;
import it.studiomedico.entities.Doctor;
import it.studiomedico.service.DoctorService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    //Create
    @PostMapping("/create")
    public DoctorDTO create(@RequestBody DoctorDTO doctor){
        return doctorService.postDoctor(doctor);
    }

    // Read All
    @GetMapping("/alldoctor")
    public List<DoctorDTO> getAllDoctors(){
        return doctorService.getAllDoctor();
    }


    // Read One
    @GetMapping("/{id}")
    public DoctorDTO getDoctor(@PathVariable("id") long id){
        return doctorService.getDoctor(id);
    }

    // UpdateWorkplace
   /* @PutMapping("/{id}")
    public DoctorDTO updateDoctorWorkplace(@PathVariable long id, @RequestParam String Workplace){
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
  }*/

    // Delete a specific Doctor
    @DeleteMapping("/{id}")
    public void deleteSingle(@PathVariable("id") long id){
            doctorService.deleteDoctor(id);
    }

    // Delete all
    @DeleteMapping("")
    public void deleteAll(){
        doctorService.deleteAllDoctor();
    }
}
