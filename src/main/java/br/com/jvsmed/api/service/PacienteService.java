package br.com.jvsmed.api.service;

import br.com.jvsmed.api.paciente.Paciente;
import br.com.jvsmed.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente criarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPaciente(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    public Paciente editarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
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
}
