package br.com.jvsmed.api.repositories;

import br.com.jvsmed.api.entities.FichaMedicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FichaMedicaRepository extends JpaRepository<FichaMedicaEntity, Integer> {
    List<FichaMedicaEntity> findByIdPaciente(FichaMedicaEntity idPaciente);
}
