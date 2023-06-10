package br.com.jvsmed.api.service;


import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.registro.paciente.DadosCadastroPaciente;
import br.com.jvsmed.api.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PacienteService {

    private PacienteRepository repository;

    @Autowired
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void criarPaciente(DadosCadastroPaciente dados) throws SQLException {
        PacienteEntity paciente = new PacienteEntity(dados);
        repository.save(paciente);
    }

    @Transactional
    public ResponseEntity<?> atualizarPaciente(PacienteEntity paciente) {
        if (paciente.getCpf() == null || paciente.getCpf().isEmpty()) {
//            throw new IllegalArgumentException("CPF não pode estar vazio");
            return ResponseEntity.badRequest().body("CPF não pode estar vazio!");
        }
        repository.save(paciente);
        return ResponseEntity.status(200).build();
    }

    @Transactional
    public ResponseEntity<?> excluirPaciente(Long id) {
//        PacienteEntity paciente = repository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + id));
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.badRequest().body("Paciente não encontrado!");
    }

    public Iterable<PacienteEntity> findAll() {
        return repository.findAll();
    }

    public ResponseEntity<PacienteEntity> findByCpf(String cpf) {
        return ResponseEntity.ok(repository.findByCpf(cpf));
    }

    public ResponseEntity<PacienteEntity> findByNome(String nome) {
        return ResponseEntity.ok(repository.findByNome(nome));
    }
}
