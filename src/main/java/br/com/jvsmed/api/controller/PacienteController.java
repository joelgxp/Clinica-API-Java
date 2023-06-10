package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.exceptions.InvalidRequestException;
import br.com.jvsmed.api.registro.paciente.DadosCadastroPaciente;
import br.com.jvsmed.api.registro.paciente.DadosListagemPaciente;

import br.com.jvsmed.api.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<?> buscarPorCPF(@PathVariable String cpf) {
//        return new DadosListagemPaciente(service.findByCpf(cpf));

        return ResponseEntity.status(200).body(new DadosListagemPaciente(service.findByCpf(cpf).getBody()));
    }

    @GetMapping("/nome/{nome}")
    public List<PacienteEntity> buscarPorNome(@PathVariable String nome) {
         // Lógica para buscar nomes no banco de dados
        // e retornar os resultados em uma lista de objetos ResultadoBusca

        // Exemplo de implementação:
        List<PacienteEntity> resultados = new ArrayList<>();
        // Adicione resultados à lista
        // ...

        return resultados;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroPaciente paciente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Tratativa de erros de validação
            List<String> erros = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                erros.add(error.getField() + " -> " + error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body("Erros de validação: \n" + erros);
        }
        try {
            service.criarPaciente(paciente);
            return ResponseEntity.status(201).build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro na camada Service: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteEntity> atualizar(@PathVariable Long id, @RequestBody PacienteEntity paciente) {
        service.atualizarPaciente(paciente);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        try {
//            if (id == null) {
//                return ResponseEntity.badRequest().body("ID não fornecido na requisição DELETE.");
//            }
            return service.excluirPaciente(id);
        } catch (InvalidRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro na camada Service: " + e.getMessage());
        }
    }
}