package it.studiomedico.service;

import it.studiomedico.dto.SecretaryDTO;
import it.studiomedico.entities.Secretary;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import it.studiomedico.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SecretaryService {
    @Autowired
    private SecretaryRepository secretaryRepository;

    public ResponseEntity <Secretary> createSecretary(Secretary secretary){
        secretary.setStatus(RecordStatusENUM.A);
        secretaryRepository.save(secretary);
        return ResponseEntity.status(201).body(secretary);
    }

    public List<Secretary> getAllSecretary(){
        List<Secretary> allSecretaries = new ArrayList<>();
        allSecretaries.addAll(secretaryRepository.findAll());
        return allSecretaries;
    }

    public ResponseEntity deleteSecretary (Long id){
        if (secretaryRepository.existsById(id)) {
            Secretary secretary = secretaryRepository.findById(id).get();
            secretary.setStatus(RecordStatusENUM.D);
            secretaryRepository.saveAndFlush(secretary);
            return new ResponseEntity<>("Succesfully deleted", HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>("no doctor with the id: "+id,HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Optional<Secretary>> getSecretary (Long id){
        if (secretaryRepository.existsById(id)){
            Optional<Secretary> secretary = secretaryRepository.findById(id);
            return ResponseEntity.ok().body(secretary);
        }
        return new ResponseEntity("no secretary exiat with id "+id, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Secretary> updateSecretary(Long id,SecretaryDTO secretaryDTO){
        Optional<Secretary> secretaryUpdate = secretaryRepository.findById(id);
        if (secretaryUpdate.isPresent()){
            Secretary secretary = secretaryUpdate.get();
            secretary.setName(secretaryDTO.getName());
            secretary.setSurname(secretaryDTO.getSurname());
            secretary.setEmail(secretaryDTO.getEmail());
            secretary.setWorkplace(secretaryDTO.getWorkplace());

            secretaryRepository.saveAndFlush(secretary);
            return ResponseEntity.ok().body(secretary);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity deleteAllSecretary(){
        secretaryRepository.findAll().forEach(secretary ->{
            secretary.setStatus(RecordStatusENUM.D);
            secretaryRepository.saveAndFlush(secretary);
        });
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
