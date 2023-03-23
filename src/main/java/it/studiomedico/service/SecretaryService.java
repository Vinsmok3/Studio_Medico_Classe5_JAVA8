package it.studiomedico.service;

import it.studiomedico.dto.DoctorDTO;
import it.studiomedico.dto.SecretaryDTO;
import it.studiomedico.entities.Doctor;
import it.studiomedico.entities.Secretary;
import it.studiomedico.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecretaryService {

    @Autowired
    private SecretaryRepository secretaryRepository;

    public SecretaryDTO postSecretary;

    public SecretaryDTO postSecretary (SecretaryDTO request){
        return secretaryEntityToResponse (secretaryRepository.save(secretaryRequestToEntity(request)));
    }

    public SecretaryDTO getSecretary(Long id){
        Secretary secretary = secretaryRepository.findById(id).orElseThrow(RuntimeException::new);
        return secretaryEntityToResponse(secretary);
    }


    public List<Secretary> getAllSecretary(){
        return secretaryRepository.findAll();
    }

    public SecretaryDTO putSecretary(Long id, SecretaryDTO request){
        Secretary secretary = secretaryRepository.findById(id).orElseThrow(RuntimeException::new);
        secretaryRepository.delete(secretary);
        return secretaryEntityToResponse (secretaryRepository.save(secretary));
    }
    public SecretaryDTO deleteSecretary (Long id){
        Secretary secretary = secretaryRepository.findById(id).orElseThrow(RuntimeException::new);
        secretaryRepository.delete(secretary);
        return secretaryEntityToResponse(secretary);
    }

    public List<Secretary> deleteAllSecretary(){
        List<Secretary> secretariesList = new ArrayList<>();
        secretaryRepository.deleteAll();
        return secretariesList;
    }

    private List<SecretaryDTO> secretaryEntitiesToResponses(List<Secretary> secretaries){
        List<SecretaryDTO> response = new ArrayList<>();
        for (Secretary secretary : secretaries) {
            response.add( secretaryEntityToResponse(secretary));
        }
        return response;
    }

    private Secretary secretaryRequestToEntity(SecretaryDTO request){
        Secretary secretary = new Secretary();
        return secretaryRequestToEntity(request, secretary);
    }

    private Secretary secretaryRequestToEntity(SecretaryDTO request, Secretary secretary){
        secretary.setName(request.getName());
        secretary.setSurname(request.getSurname());
        secretary.setWorkplace(request.getWorkplace());
        secretary.setEmail(request.getEmail());
        secretary.setCreatedBy(request.getCreatedBy());
        secretary.setCreatedOn(request.getCreatedOn());
        secretary.setModifiedBy(request.getModifiedBy());
        secretary.setModifyOn(request.getModifyOn());
        return secretary;
    }

    private SecretaryDTO secretaryEntityToResponse(Secretary secretary){
        SecretaryDTO response = new SecretaryDTO();
        response.setIdSecretary(secretary.getIdSecretary());
        response.setName(secretary.getName());
        response.setSurname(secretary.getSurname());
        response.setWorkplace(secretary.getWorkplace());
        response.setEmail(secretary.getEmail());
        response.setCreatedBy(secretary.getCreatedBy());
        response.setCreatedOn(secretary.getCreatedOn());
        response.setModifiedBy(secretary.getModifiedBy());
        response.setModifyOn(secretary.getModifyOn());
        return response;
    }
}
