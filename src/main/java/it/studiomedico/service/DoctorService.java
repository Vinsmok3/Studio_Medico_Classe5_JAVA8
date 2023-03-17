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
       return doctorEntitiesToResponses(doctor);
   }


    public List<DoctorDTO> getAllDoctor(){
        return doctorRepository.findAll();
   }

   public DoctorDTO putDoctorWorkPlace(Long id, DoctorDTO request){
       Doctor doctor = doctorRepository.findById(id).orElseThrow(RuntimeException::new);
       doctorRepository.delete(doctor);
       return (DoctorDTO) doctorEntitiesToResponses (doctorRepository.save(doctorRequestToEntity(doctor)));
   }
   public DoctorDTO deleteDoctor (Long id){
       Doctor doctor = doctorRepository.findById(id).orElseThrow(RuntimeException::new);
       doctorRepository.delete(doctor);
       return doctorEntitiesToResponses(doctor);
   }

    public List<DoctorDTO> deleteAllDoctor(){
        return doctorRepository.deleteAll();
    }

    private List<DoctorDTO> doctorEntitiesToResponses(List<Doctor> doctors) {
        List<DoctorDTO> response = new ArrayList<>();
        for(Doctor doctor : doctors) {
            response.add(doctorEntitiesToResponses(doctor));
        }
        return response;
    }

    private Doctor doctorRequestToEntity(DoctorDTO request){
       Doctor doctor = new Doctor();
       doctorRequestToEntity(request,doctor);
    }

    private Doctor doctorRequestToEntity (DoctorDTO request, Doctor doctor){
       doctor.setSpecialization(request.getSpecialization());
       doctor.setWorkplace(request.getWorkplace());
       doctor.setWorkingdays(request.getWorkingdays());
       doctor.setName(request.getName());
       doctor.getSurname();
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
        response.getSurname();
        response.setEmail( doctor.getEmail());
        return response;
    }


}
