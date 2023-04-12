package it.studiomedico.controllers;

import it.studiomedico.dto.DoctorDTO;
import it.studiomedico.entities.Doctor;
import it.studiomedico.service.DoctorService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    //Create
    @PostMapping("/create")
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor){
        return doctorService.createDoctor(doctor);
    }

    // Read All
    @GetMapping("/alldoctor")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }


    // Read One
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Doctor>> getDoctor(@PathVariable Long id){
        return doctorService.getDoctor(id);
    }
    //Update One
    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO){
        return doctorService.updateDoctor(id,doctorDTO);
    }
    // Delete a specific Doctor
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSingle(@PathVariable Long id){
            return doctorService.deleteDoctor(id);
    }

    // Delete all
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        doctorService.deleteAllDoctor();
    }

    //Assign a Secretary
    @PatchMapping("/secretary")
    public ResponseEntity<Doctor> assignSecretary(@RequestParam Long idDoctor, @RequestParam Long idSecretary) {
        return doctorService.secretaryDoc(idDoctor, idSecretary);
    }


}
