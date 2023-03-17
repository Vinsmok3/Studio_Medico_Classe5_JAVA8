package it.studiomedico.service;

import it.studiomedico.repositories.PatientRepository;
import it.studiomedico.repositories.PrenotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotationService {
    @Autowired
    PrenotationRepository prenotationRepository;

}
