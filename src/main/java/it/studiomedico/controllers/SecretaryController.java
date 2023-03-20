package it.studiomedico.controllers;

import it.studiomedico.dto.SecretaryDTO;
import it.studiomedico.entities.Secretary;
import it.studiomedico.service.SecretaryService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretary")

public class SecretaryController {

    @Autowired
    private SecretaryService secretaryService;

    //Create
    @PostMapping("/creation")
    public SecretaryDTO create (@RequestBody SecretaryDTO secretary){
        return secretaryService.postSecretary(secretary);
    }

    // View all
    @GetMapping("/viewAll")
    public List<Secretary> getAllSecretary(){
        return secretaryService.getAllSecretary();
    }

    // View on by ID
    @PutMapping("/{id}")
    public SecretaryDTO getSecretary(@PathVariable ("id") long id){
       return secretaryService.getSecretary(id);
    }

    // Update Workplace
    @PutMapping("/{id}")
   /* public Secretary updateSecretaryWorkplace(@PathVariable long id, @RequestParam String Workplace){
        Secretary secretary = null;
        if (secretaryRepository.existsById(id)){
            secretary = secretaryRepository.getById(id);
            secretary.setWorkplace(Workplace);
            secretary= secretaryRepository.saveAndFlush(secretary);
        }

        return secretary;
    }
*/
    //Delete one secretary by ID
    @DeleteMapping("/{id}")
    public SecretaryDTO deleteOneSecretaryById(@PathVariable long id, HttpServletResponse response){
       return secretaryService.deleteSecretary(id);
    }

    // Delete All
    @DeleteMapping("/deleteAll")
    public void deleteAllSecretary(){
        secretaryService.deleteAllSecretary();
    }
}
