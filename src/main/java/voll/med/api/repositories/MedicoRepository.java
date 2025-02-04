package voll.med.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import voll.med.api.domain.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}