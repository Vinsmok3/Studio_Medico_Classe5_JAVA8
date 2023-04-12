package it.studiomedico.service;

import it.studiomedico.dto.DoctorDTO;
import it.studiomedico.entities.Doctor;
import it.studiomedico.entities.recordEnum.RecordStatusENUM;
import it.studiomedico.repositories.DoctorRepository;
import it.studiomedico.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

   @Autowired
    private DoctorRepository doctorRepository;
   @Autowired
   private SecretaryRepository secretaryRepository;

   public ResponseEntity<Doctor> createDoctor(Doctor doctor){
       doctor.setStatus(RecordStatusENUM.A);
       doctorRepository.save(doctor);
       return ResponseEntity.status(201).body(doctor);
   }

   public List<Doctor> getAllDoctors(){
       List<Doctor> alldocs = new ArrayList<>();
       alldocs.addAll(doctorRepository.findAll());
       return alldocs;
   }
    public ResponseEntity deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            Doctor doctor = doctorRepository.findById(id).get();
            doctor.setStatus(RecordStatusENUM.D);
            doctorRepository.saveAndFlush(doctor);
            return new ResponseEntity("succesfully deleted", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("no doctor with the id: " + id, HttpStatus.NOT_FOUND);
        }
    }
   public ResponseEntity<Optional<Doctor>> getDoctor(Long id){
       if (doctorRepository.existsById(id)) {
           Optional<Doctor> doctor = doctorRepository.findById(id);
           return ResponseEntity.ok().body(doctor);
       }
       return new ResponseEntity("no doctor exist with id " + id, HttpStatus.NOT_FOUND);
   }


   public ResponseEntity<Doctor> updateDoctor(Long id, DoctorDTO doctorDTO){
           Optional<Doctor> doctorUpdate = doctorRepository.findById(id);
           if (doctorUpdate.isPresent()) {
               Doctor doctor = doctorUpdate.get();

               doctor.setName(doctorDTO.getName());
               doctor.setSurname(doctorDTO.getSurname());
               doctor.setEmail(doctorDTO.getEmail());
               doctor.setWorkplace(doctorDTO.getWorkplace());
               doctor.setSpecialization(doctorDTO.getSpecialization());

               doctorRepository.saveAndFlush(doctor);
               return ResponseEntity.ok().body(doctor);
           } else {
               return ResponseEntity.notFound().build();
           }
       }
    public ResponseEntity deleteAllDoctor(){
        doctorRepository.findAll().forEach(doctor -> {
            doctor.setStatus(RecordStatusENUM.D);
            doctorRepository.saveAndFlush(doctor);
        });
        return new ResponseEntity(HttpStatus.NO_CONTENT);
   }

    public ResponseEntity<Doctor> secretaryDoc(Long idDoctor, Long idSecretary){
        if (secretaryRepository.existsById(idSecretary)) {
            Doctor doctor = doctorRepository.findById(idDoctor).get();
            doctor.setSecretary(secretaryRepository.findById(idSecretary).get());
            Doctor updateDoctor = doctorRepository.saveAndFlush(doctor);
            return ResponseEntity.ok(updateDoctor);
        }
        return new ResponseEntity("no doctor found with id " + idDoctor, HttpStatus.NOT_FOUND);
    }

    // Fare listaPazienti & listaPrenotazioni

}
