package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.paciente.DadosCadastroPaciente;
import br.com.jvsmed.api.paciente.Paciente;
import br.com.jvsmed.api.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @GetMapping
    public Iterable<Paciente> listar() {
        return repository.findAll();
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {

        repository.save(new Paciente(dados));
    }
}
