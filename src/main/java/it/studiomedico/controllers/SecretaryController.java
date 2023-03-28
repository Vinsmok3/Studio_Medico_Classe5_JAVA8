package it.studiomedico.controllers;

import it.studiomedico.dto.SecretaryDTO;
import it.studiomedico.entities.Secretary;
import it.studiomedico.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secretary")

public class SecretaryController {

    @Autowired
    private SecretaryService secretaryService;

    //Create
    @PostMapping("/creation")
    public ResponseEntity<Secretary> create (@RequestBody Secretary secretary){
        return secretaryService.createSecretary(secretary);
    }

    // View all
    @GetMapping("/viewAll")
    public List<Secretary> getAllSecretaries(){
        return secretaryService.getAllSecretary();
    }

    // View on by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Secretary>> getSecretary(@PathVariable Long id){
        return secretaryService.getSecretary(id);
    }

    //Update one by id
    @PatchMapping("/update/{id}")
    public ResponseEntity<Secretary> updateSecretary(@PathVariable long id, @RequestBody SecretaryDTO secretaryDTO){
       return secretaryService.updateSecretary(id,secretaryDTO);
    }

    // Delete All
    @PatchMapping("/deleteAll")
    public void deleteAllSecretaries(){
        secretaryService.deleteAllSecretary();
    }

    //Delete a Secretary by id
    @PatchMapping("/delete/{id}")
    public ResponseEntity deleteOneSecretary(@PathVariable Long id){
        return secretaryService.deleteSecretary(id);
    }

}
