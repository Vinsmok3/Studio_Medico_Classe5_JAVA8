package it.studiomedico.utilities;

import it.pasqualecavallo.studentsmaterial.authorization_framework.dao.UserDao;
import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserDetails;
import it.studiomedico.entities.Doctor;
import it.studiomedico.entities.Patient;
import it.studiomedico.entities.Secretary;
import it.studiomedico.repositories.DoctorRepository;
import it.studiomedico.repositories.PatientRepository;
import it.studiomedico.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class UserDAO implements UserDao {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SecretaryRepository secretaryRepository;


    @Override
    public UserDetails getUserByUsername(String email) {
        Optional<Patient> oPatient;
        Optional<Doctor> oDoctor;
        Optional<Secretary> oSecretary;
        UserDetails userDetails = new UserDetails();
        if ((oPatient = patientRepository.findByEmail(email)).isPresent()) {
            Patient patient = oPatient.get();
            userDetails.setUsername(patient.getEmail());
            userDetails.setPassword(patient.getPassword());
            userDetails.setRoles(Arrays.asList("ROLE_USER"));
            userDetails.setUserId(Long.valueOf(patient.getIdPatient()));
            return userDetails;
        } else if((oDoctor = doctorRepository.findByEmail(email)).isPresent()){
            Doctor doctor = oDoctor.get();
            userDetails.setUsername(doctor.getEmail());
            userDetails.setPassword(doctor.getPassword());
            userDetails.setRoles(Arrays.asList("ROLE_DOCTOR"));
            userDetails.setUserId(Long.valueOf(doctor.getIdDoctor()));
            return userDetails;
        } else if((oSecretary = secretaryRepository.findByEmail(email)).isPresent()) {
            Secretary secretary = oSecretary.get();
            userDetails.setUsername(secretary.getEmail());
            userDetails.setPassword(secretary.getPassword());
            userDetails.setRoles(Arrays.asList("ROLE_SECRETARY"));
            userDetails.setUserId(Long.valueOf(secretary.getIdSecretary()));
            return userDetails;
        } else{
            return null;
        }

    }
}