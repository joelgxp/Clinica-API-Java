package br.com.jvsmed.api.service;

import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PacienteService {

    private PacienteRepository repository;

    @Autowired
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public PacienteEntity criarPaciente(PacienteEntity pacienteEntity) {
        return repository.save(pacienteEntity);
    }

    public PacienteEntity atualizarPaciente(PacienteEntity paciente) {

        return repository.save(paciente);
    }

    public void excluirPaciente(Long id) {
        PacienteEntity paciente = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + id));

        repository.delete(paciente);
    }

    public Iterable<PacienteEntity> findAll() {
        return repository.findAll();
    }

    public PacienteEntity findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
