package it.studiomedico.repositories;

import it.studiomedico.entities.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretaryRepository extends JpaRepository<Secretary,Long> {
}
