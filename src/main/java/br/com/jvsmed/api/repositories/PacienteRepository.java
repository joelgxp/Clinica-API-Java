package br.com.jvsmed.api.repositories;

import br.com.jvsmed.api.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    Optional<PacienteEntity> findByCpf(String cpf);

    List<PacienteEntity> findByNomeContaining(String nome);

    Optional<PacienteEntity> findById(Long id);
}
