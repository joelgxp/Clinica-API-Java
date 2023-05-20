package br.com.jvsmed.api.service;

import br.com.jvsmed.api.paciente.Paciente;
import br.com.jvsmed.api.paciente.PacienteRepository;
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

    public Paciente criarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPaciente(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    public Paciente editarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizarPaciente(Paciente pacienteAtualizado) {
        Paciente pacienteExistente = pacienteRepository.findById(pacienteAtualizado.getId())
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: "));

        pacienteExistente.setNome(pacienteAtualizado.getNome()); // Atualize os campos desejados
        // Atualize outros campos conforme necessário

        return pacienteRepository.save(pacienteExistente);
    }

    public void excluirPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Iterable<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorId(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    public Paciente buscarPorCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }
}
