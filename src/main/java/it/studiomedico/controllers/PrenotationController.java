package it.studiomedico.controllers;

import it.studiomedico.dto.PrenotationDTO;
import it.studiomedico.entities.Doctor;
import it.studiomedico.entities.Prenotation;
import it.studiomedico.entities.recordEnum.BookingENUM;
import it.studiomedico.repositories.PrenotationRepository;
import it.studiomedico.service.PrenotationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/prenotation")
public class PrenotationController {

    @Autowired
    private PrenotationService prenotationService;
    //Create
    @PostMapping("/create")
    public ResponseEntity<Prenotation> create(@RequestBody Prenotation prenotation, @RequestParam Long idDoctor, @RequestParam Long idPatient){
        return prenotationService.createPrenotation(prenotation, idDoctor, idPatient);
    }

    // Read All
    @GetMapping("/allprenotations")
    public List<Prenotation> getAllPrenotations(){
        return prenotationService.getAllPrenotations();
    }

    // Update
    @PutMapping("/Status/{id}")
    public ResponseEntity<Prenotation> updatePrenotation(@PathVariable Long id, @RequestBody PrenotationDTO prenotationDto) {
        return prenotationService.updatePrenotation(id, prenotationDto);
    }

    // Delete all
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        prenotationService.deleteAllPrenotations();
    }

    // Delete a specific Prenotation WIP
    /*
    @DeleteMapping("/{id}")
    public void deleteSingle(@PathVariable long id, HttpServletResponse response){
        if (prenotationRepository.existsById(id))
            prenotationRepository.deleteById(id);
        else
            response.setStatus(409);
    }

     */

    // Read One WIP
    /*
    @GetMapping("/{id}")
    public Prenotation getPrenotations(@PathVariable long id){
        return prenotationRepository.existsById(id)
                ? prenotationRepository.getById(id)
                : new Prenotation();
    }

     */


}
