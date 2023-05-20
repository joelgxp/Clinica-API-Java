package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.medico.DadosAtualizacaoMedico;
import br.com.jvsmed.api.paciente.*;
import br.com.jvsmed.api.service.PacienteService;
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
    private PacienteService service;

    @GetMapping
    public Iterable<Paciente> listar() {
        return service.findAll();
    }

    @GetMapping("/{cpf}")
    public DadosListagemPaciente buscarPorID(@PathVariable String cpf) {
//        return new DadosListagemPaciente(repository.getReferenceById(id));
        return new DadosListagemPaciente(service.buscarPorId(cpf));
    }

//    @GetMapping("/cpf/{cpf}")
//    public DadosListagemPaciente buscarPorCPF(@PathVariable String cpf) {
//        return new DadosListagemPaciente(repository.findByCpf(cpf));
//    }
//
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
        service.criarPaciente(new Paciente(dados));
    }
//
//    @Transactional
//    @PutMapping("/{id}")
//    public void atualizar(@PathVariable Long id, @RequestBody DadosAtualizacaoPaciente dados) {
//        var paciente = repository.getReferenceById(dados.id());
//        paciente.atualizarInformacoes(dados);
//    }
//    @Transactional
//    @DeleteMapping("/{id}")
//    public void remover(@PathVariable Long id) {
//        var paciente = repository.getReferenceById(id);
//        paciente.inativar();
//    }
}
