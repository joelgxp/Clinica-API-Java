package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.entities.MedicoEntity;
import br.com.jvsmed.api.registro.medico.DadosAtualizacaoMedico;
import br.com.jvsmed.api.registro.medico.DadosCadastroMedico;
import br.com.jvsmed.api.registro.medico.DadosListagemMedico;
import br.com.jvsmed.api.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }

    @GetMapping("/{id}")
    public DadosListagemMedico listarPorId(@PathVariable Long id) {
        return new DadosListagemMedico(repository.getReferenceById(id));
    }
    @GetMapping("/paginacao")
    public Page<DadosListagemMedico> listarPaginacao(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new MedicoEntity(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void inativar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
    }
}
