package br.com.jvsmed.api.repositories;

import br.com.jvsmed.api.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    PacienteEntity findByCpf(String cpf);
}
