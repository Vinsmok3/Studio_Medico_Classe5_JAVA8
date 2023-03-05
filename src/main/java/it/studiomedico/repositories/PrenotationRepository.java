package it.studiomedico.repositories;

import it.studiomedico.entities.Prenotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotationRepository extends JpaRepository <Prenotation, Long> {
}
