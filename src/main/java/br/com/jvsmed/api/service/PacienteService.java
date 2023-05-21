package br.com.jvsmed.api.service;

import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository repository) {
        pacienteRepository = repository;
    }

    public PacienteEntity criarPaciente(PacienteEntity pacienteEntity) {
        return pacienteRepository.save(pacienteEntity);
    }

    public PacienteEntity buscarPaciente(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    public PacienteEntity editarPaciente(PacienteEntity pacienteEntity) {
        return pacienteRepository.save(pacienteEntity);
    }

    public PacienteEntity atualizarPaciente(PacienteEntity pacienteEntityAtualizado) {
        PacienteEntity pacienteEntityExistente = pacienteRepository.findById(pacienteEntityAtualizado.getId())
                .orElseThrow(() -> new NoSuchElementException("PacienteEntity não encontrado com o ID: "));

//        pacienteEntityExistente.setNome(pacienteEntityAtualizado.getNome()); // Atualize os campos desejados
        // Atualize outros campos conforme necessário

        return pacienteRepository.save(pacienteEntityExistente);
    }

    public void excluirPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Iterable<PacienteEntity> findAll() {
        return pacienteRepository.findAll();
    }

    public PacienteEntity buscarPorId(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    public PacienteEntity buscarPorCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }
}
