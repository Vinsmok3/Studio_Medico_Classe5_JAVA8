package it.studiomedico.controllers;

import it.studiomedico.entities.Prenotation;
import it.studiomedico.entities.recordEnum.BookingENUM;
import it.studiomedico.repositories.PrenotationRepository;
import it.studiomedico.service.PrenotationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/Prenotation")
public class PrenotationController {

    @Autowired
    private PrenotationRepository prenotationRepository;
    private PrenotationService prenotationService;
    //Create
    @PostMapping("")
    public Prenotation create(@RequestBody Prenotation prenotation){
        return prenotationRepository.saveAndFlush(prenotation);
    }

    // Read All
    @GetMapping("")
    public List<Prenotation> getAllPrenotations(){
        return prenotationRepository.findAll();
    }


    // Read One
    @GetMapping("/{id}")
    public Prenotation getPrenotations(@PathVariable long id){
        return prenotationRepository.existsById(id)
                ? prenotationRepository.getById(id)
                : new Prenotation();
    }

    // UpdatePrenotationDate
    @PutMapping("/Date/{id}")
    public Prenotation updatePrenotationDate(@PathVariable long id, @RequestParam LocalDateTime date){
        Prenotation prenotation;
        if (prenotationRepository.existsById(id)){
            prenotation = prenotationRepository.getById(id);
            prenotation.setDate(date);
            prenotation = prenotationRepository.saveAndFlush(prenotation);
        }else{
            prenotation = new Prenotation();
        }
        return prenotation;
    }

    // UpdateStatus
    @PutMapping("/Status/{id}")
    public Prenotation updatePrenotationStatus(@PathVariable long id, @RequestParam BookingENUM status){
        Prenotation prenotation;
        if (prenotationRepository.existsById(id)){
            prenotation = prenotationRepository.getById(id);
            prenotation.setStatusBooking(status);
            prenotation = prenotationRepository.saveAndFlush(prenotation);
        }else{
            prenotation = new Prenotation();
        }
        return prenotation;
    }

    // Delete a specific Prenotation
    @DeleteMapping("/{id}")
    public void deleteSingle(@PathVariable long id, HttpServletResponse response){
        if (prenotationRepository.existsById(id))
            prenotationRepository.deleteById(id);
        else
            response.setStatus(409);
    }

    // Delete all
    @DeleteMapping("/logic")
    public void deleteAll(Long id){
        prenotationService.deleteById(id);
    }


}
