package it.studiomedico.controllers;

import it.studiomedico.entities.Secretary;
import it.studiomedico.repositories.SecretaryRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretary")

public class SecretaryController {

    @Autowired
    private SecretaryRepository secretaryRepository;

    //Create
    @PostMapping("/creation")
    public Secretary create (@RequestBody Secretary secretary){
        return secretaryRepository.saveAndFlush(secretary);
    }

    // View all
    @GetMapping("/viewAll")
    public List<Secretary> getAllSecretary(){
        return secretaryRepository.findAll();
    }

    // View on by ID
    @PutMapping("/{id}")
    public Secretary getSecretary(@PathVariable long id){
        return secretaryRepository.existsById(id)
                ?secretaryRepository.getById(id)
                : new Secretary();
    }

    // Update Workplace
    @PutMapping("/{id}")
    public Secretary updateSecretaryWorkplace(@PathVariable long id, @RequestParam String Workplace){
        Secretary secretary = null;
        if (secretaryRepository.existsById(id)){
            secretary = secretaryRepository.getById(id);
            secretary.setWorkplace(Workplace);
            secretary= secretaryRepository.saveAndFlush(secretary);
        }

        return secretary;
    }

    //Delete one secretary by ID
    @DeleteMapping("/{id}")
    public void deleteOneSecretaryById(@PathVariable long id, HttpServletResponse response){
        if (secretaryRepository.existsById(id))
            secretaryRepository.deleteById(id);
        else
            response.setStatus(409);
    }

    // Delete All
    @DeleteMapping("/deleteAll")
    public void deleteAllSecretary(){
        secretaryRepository.deleteAll();
    }
}
