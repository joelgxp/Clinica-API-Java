package br.com.jvsmed.api.repositories;

import br.com.jvsmed.api.entities.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoEntity, Integer> {

}
