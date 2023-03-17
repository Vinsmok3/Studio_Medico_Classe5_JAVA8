package it.studiomedico.service;

import it.studiomedico.dto.DoctorDTO;
import it.studiomedico.entities.Doctor;
import it.studiomedico.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

   @Autowired
    private DoctorRepository doctorRepository;

   public DoctorDTO postDoctor (DoctorDTO request){
      return doctorEntityToResponse (doctorRepository.save(doctorRequestToEntity(request)));
   }

   public DoctorDTO getDoctor(Long id){
       Doctor doctor = doctorRepository.findById(id).orElseThrow(RuntimeException::new);
           return doctorEntityToResponse(doctor);
   }


    public List<Doctor> getAllDoctor(){
        List<Doctor> doctorsList = new ArrayList<>();
        doctorRepository.findAll();
        return doctorsList;
   }

   public DoctorDTO putDoctor(Long id, DoctorDTO request){
       Doctor doctor = doctorRepository.findById(id).orElseThrow(RuntimeException::new);
       doctorRequestToEntity(request, doctor);
       return doctorEntityToResponse (doctorRepository.save(doctor));
   }

   public DoctorDTO deleteDoctor (Long id){
       Doctor doctor = doctorRepository.findById(id).orElseThrow(RuntimeException::new);
       doctorRepository.delete(doctor);
       return doctorEntityToResponse(doctor);
   }

    public List<Doctor> deleteAllDoctor(){
        List<Doctor> doctorsList = new ArrayList<>();
        doctorRepository.deleteAll();
        return doctorsList;
    }

    private List<DoctorDTO> doctorEntitiesToResponses(List<Doctor> doctors) {
        List<DoctorDTO> response = new ArrayList<>();
        for(Doctor doctor : doctors) {
            response.add(doctorEntityToResponse(doctor));
        }
        return response;
    }

    private Doctor doctorRequestToEntity(DoctorDTO request){
       Doctor doctor = new Doctor();
       return doctorRequestToEntity(request,doctor);
    }

    private Doctor doctorRequestToEntity (DoctorDTO request, Doctor doctor){
       doctor.setSpecialization(request.getSpecialization());
       doctor.setWorkplace(request.getWorkplace());
       doctor.setWorkingdays(request.getWorkingdays());
       doctor.setName(request.getName());
       doctor.setSurname(request.getSurname());
       doctor.setEmail(request.getEmail());
       return doctor;
    }

    private DoctorDTO doctorEntityToResponse(Doctor doctor){
        DoctorDTO response = new DoctorDTO();
        response.setIdDoctor(doctor.getIdDoctor());
        response.setSpecialization( doctor.getSpecialization());
        response.setWorkplace(doctor.getWorkplace());
        response.setWorkingdays( doctor.getWorkingdays());
        response.setName( doctor.getName());
        response.setSurname(doctor.getSurname());
        response.setEmail( doctor.getEmail());
        return response;
    }


}