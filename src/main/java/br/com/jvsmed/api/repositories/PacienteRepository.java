package br.com.jvsmed.api.repositories;

import br.com.jvsmed.api.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    PacienteEntity findByCpf(String cpf);

    List<PacienteEntity> findByNomeContaining(String nome);
}
