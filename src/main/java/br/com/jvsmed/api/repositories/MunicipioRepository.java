package br.com.jvsmed.api.repositories;

import br.com.jvsmed.api.entities.EstadoEntity;
import br.com.jvsmed.api.entities.MunicipioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepository extends JpaRepository<MunicipioEntity, Integer> {

    List<MunicipioEntity> findByEstadoId(EstadoEntity estadoId);
}
