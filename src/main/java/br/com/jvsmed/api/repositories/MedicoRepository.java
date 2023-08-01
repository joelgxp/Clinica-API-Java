package br.com.jvsmed.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {

//    Page<MedicoEntity> findAllByAtivoTrue(Pageable paginacao);
}
