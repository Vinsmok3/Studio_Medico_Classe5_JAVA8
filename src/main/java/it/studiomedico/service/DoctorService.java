package it.studiomedico.service;

import it.studiomedico.dto.DoctorDTO;
import it.studiomedico.entities.Doctor;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;
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
      return doctorEntityToResponse (doctorRepository.saveAndFlush(doctorRequestToEntity(request)));
   }

   public DoctorDTO getDoctor(Long id){
       Doctor doctor = doctorRepository.findById(id).orElseThrow(RuntimeException::new);
           return doctorEntityToResponse(doctor);
   }


    public List<DoctorDTO> getAllDoctor(){
       List<Doctor> alldocs = new ArrayList<>();
       alldocs.addAll(doctorRepository.findAll());
       return doctorEntitiesToResponses(alldocs);
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
       doctor.setName(request.getName());
       doctor.setSurname(request.getSurname());
       doctor.setEmail(request.getEmail());
       doctor.setCreatedBy(request.getCreatedBy());
       doctor.setCreatedOn(request.getCreatedOn());
       doctor.setModifiedBy(request.getModifiedBy());
       doctor.setModifyOn(request.getModifyOn());
       doctor.setStatus(request.getStatus());
       return doctor;
    }

    private DoctorDTO doctorEntityToResponse(Doctor doctor){
        DoctorDTO response = new DoctorDTO();
        response.setIdDoctor(doctor.getIdDoctor());
        response.setSpecialization( doctor.getSpecialization());
        response.setWorkplace(doctor.getWorkplace());
        response.setName( doctor.getName());
        response.setSurname(doctor.getSurname());
        response.setEmail( doctor.getEmail());
        response.setCreatedBy(doctor.getCreatedBy());
        response.setCreatedOn(doctor.getCreatedOn());
        response.setModifiedBy(doctor.getModifiedBy());
        response.setModifyOn(doctor.getModifyOn());
        response.setStatus(RecordStatusENUM.A);
        return response;
    }


}
