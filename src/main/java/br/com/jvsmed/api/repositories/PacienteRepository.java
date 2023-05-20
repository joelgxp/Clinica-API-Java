package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findByCpf(String cpf);
}
