package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.registro.paciente.DadosCadastroPaciente;
import br.com.jvsmed.api.registro.paciente.DadosListagemPaciente;
import br.com.jvsmed.api.service.PacienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public Iterable<PacienteEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<DadosListagemPaciente> buscarPorCPF(@PathVariable String cpf) {
//        return new DadosListagemPaciente(service.findByCpf(cpf));
        return ResponseEntity.status(200).body(new DadosListagemPaciente(service.findByCpf(cpf)));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody PacienteEntity paciente) {
        service.criarPaciente(paciente);
        return ResponseEntity.status(201).build();
//        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<PacienteEntity> atualizar(@RequestBody PacienteEntity paciente) {
        service.atualizarPaciente(paciente);
        return ResponseEntity.status(200).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        service.excluirPaciente(id);
        return ResponseEntity.status(204).build();
    }
}