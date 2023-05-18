package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.medico.DadosAtualizacaoMedico;
import br.com.jvsmed.api.paciente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @GetMapping
    public Iterable<Paciente> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public DadosListagemPaciente buscarPorID(@PathVariable Long id) {
        return new DadosListagemPaciente(repository.getReferenceById(id));
    }

    @GetMapping("/cpf/{cpf}")
    public DadosListagemPaciente buscarPorCPF(@PathVariable String cpf) {
        return new DadosListagemPaciente(repository.findByCpf(cpf));
    }

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @Transactional
    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }
    @Transactional
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
    }
}
