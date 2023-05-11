package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.medico.DadosCadastroMedico;
import br.com.jvsmed.api.medico.Medico;
import br.com.jvsmed.api.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public Iterable<Medico> listar() {
        return repository.findAll();
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualiza(@PathVariable Long id, @RequestBody DadosCadastroMedico dados) {
        repository.save(new Medico(id, dados));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
