package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.registro.paciente.DadosAtualizacaoPaciente;
import br.com.jvsmed.api.registro.paciente.DadosCadastroPaciente;
import br.com.jvsmed.api.registro.paciente.DadosListagemPaciente;
import br.com.jvsmed.api.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @GetMapping
    public Iterable<PacienteEntity> listar() {
        return repository.findAll();
    }

//    @GetMapping("/{id}")
//    public DadosListagemPaciente buscarPorID(@PathVariable Long id) {
//        return new DadosListagemPaciente(repository.getReferenceById(id));
//    }

    @GetMapping("/{cpf}")
    public DadosListagemPaciente buscarPorCPF(@PathVariable String cpf) {
        return new DadosListagemPaciente(repository.findByCpf(cpf));
    }

    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
        repository.save(new PacienteEntity(dados));
    }

    @Transactional
    @PutMapping("/{atualizar}")
    public void atualizar(@PathVariable String atualizar, @RequestBody DadosAtualizacaoPaciente dados) {
        var paciente = repository.findByCpf(atualizar);
        paciente.atualizarInformacoes(dados);
    }
    @Transactional
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        repository.deleteById(id);
    }
}