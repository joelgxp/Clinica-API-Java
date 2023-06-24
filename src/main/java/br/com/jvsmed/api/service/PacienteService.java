package br.com.jvsmed.api.service;


import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.exceptions.InvalidRequestException;
import br.com.jvsmed.api.registro.paciente.DadosAlteracaoAtendido;
import br.com.jvsmed.api.registro.paciente.DadosAtualizacaoPaciente;
import br.com.jvsmed.api.registro.paciente.DadosCadastroPaciente;
import br.com.jvsmed.api.registro.paciente.DadosListagemPacienteBuscaNome;
import br.com.jvsmed.api.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

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

//    public void atualizarPacientePorCpf(String cpf, DadosAtualizacaoPaciente dados) {
//        PacienteEntity pacienteExistente = repository.findByCpf(cpf);
//        if (pacienteExistente == null) {
//            throw new InvalidRequestException("Paciente não encontrado com o CPF fornecido: " + cpf);
//        }
//        pacienteExistente.atualizarInformacoes(dados);
//        repository.save(pacienteExistente);
//    }
//
//    public void atualizarAtendidoPorCpf(String cpf, DadosAlteracaoAtendido dados) {
//        PacienteEntity pacienteExistente = repository.findByCpf(cpf);
//        if (pacienteExistente == null) {
//            throw new InvalidRequestException("Paciente não encontrado com o CPF fornecido: " + cpf);
//        }
//        pacienteExistente.atualizarAtendido(dados);
//        repository.save(pacienteExistente);
//    }


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

    public ResponseEntity<List<DadosListagemPacienteBuscaNome>> buscarPorNome(String nome) {
        List<PacienteEntity> pacientes = repository.findByNomeContaining(nome);
        List<DadosListagemPacienteBuscaNome> dados = new ArrayList<>();
        for (PacienteEntity paciente : pacientes) {
            dados.add(new DadosListagemPacienteBuscaNome(paciente));
        }
        return ResponseEntity.ok(dados);
    }


}
