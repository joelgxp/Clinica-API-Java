package br.com.jvsmed.api.repositories;

import br.com.jvsmed.api.entities.EstadoEntity;
import br.com.jvsmed.api.entities.MunicipioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<MunicipioEntity, Integer> {
    List<MunicipioEntity> findByEstadoId(String estadoId);

    List<MunicipioEntity> findByEstadoId(EstadoEntity estadoId);
}
