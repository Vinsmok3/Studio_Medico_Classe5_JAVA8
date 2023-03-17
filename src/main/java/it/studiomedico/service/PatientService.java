package it.studiomedico.service;


import it.studiomedico.dto.PatientDTO;
import it.studiomedico.entities.Patient;
import it.studiomedico.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientDTO postPatient(PatientDTO request){
        return patientEntityToResponse (patientRepository.save(patientRequestToEntity(request));
    }

    public PatientDTO getPatient (Long id){
        Patient patient = patientRepository.findById(id).orElseThrow(RuntimeException::new);
        return patientEntityToResponse(patient);
    }

    public List<Patient> allPatients(){
        return patientRepository.findAll();
    }

    public PatientDTO putPatient(Long id,PatientDTO request){
        Patient patient = patientRepository.findById(id).orElseThrow(RuntimeException::new);
        patientRepository.delete(patient);
        return (PatientDTO) patientEntityToResponse(patientRepository.save(patientRequestToEntity(patient)));
    }

    public PatientDTO deletePatient (Long id){
        Patient patient = patientRepository.findById(id).orElseThrow(RuntimeException::new);
        patientRepository.delete(patient);
        return (PatientDTO) patientEntityToResponse(patient);
    }

    private List<PatientDTO> patientEntityToResponse(Patient patients){
        List<PatientDTO> response = new ArrayList<>();
        for (Patient patient : patients) {
            response.add((PatientDTO) patientEntityToResponse(patient));
        }
        return response;
    }

    private Patient patientRequestToEntity(Patient request){
        Patient patient = new Patient();
        patientRequestToEntity(request ,patient);
    }

    private Patient patientRequestToEntity(PatientDTO request,Patient patient){
        patient.setName(request.getName());
        patient.setSurname(request.getSurname());
        patient.setGender(request.getGender());
        patient.setFiscalCode(request.getFiscalCode());
        patient.setEmail(request.getEmail());
        patient.setPhoneNumber(request.getPhoneNumber());
        return patient;
    }

    private Patient patientEntityToResponse(PatientDTO patient){
        PatientDTO response = new PatientDTO();
        response.setIdPatient(patient.getIdPatient());
        response.setName(patient.getName());
        response.setSurname(patient.getSurname());
        response.setGender(patient.getGender());
        response.setFiscalCode(patient.getFiscalCode());
        response.setEmail(patient.getEmail());
        response.setPhoneNumber(patient.getPhoneNumber());
        return response;
    }

}