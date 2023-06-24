package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.registro.paciente.DadosAtualizacaoPaciente;
import br.com.jvsmed.api.registro.paciente.DadosCadastroPaciente;
import br.com.jvsmed.api.registro.paciente.DadosListagemPaciente;
import br.com.jvsmed.api.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @GetMapping
    public ResponseEntity<List<PacienteEntity>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> buscarPorCPF(@PathVariable String cpf) {
        Optional<PacienteEntity> paciente = repository.findByCpf(cpf);
        if (paciente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new DadosListagemPaciente(paciente.get()));
    }

//    @GetMapping("/nome/{nome}")
//    public ResponseEntity<?> buscarPorNome(@PathVariable String nome) {
//        return repository.buscarPorNome(nome);
//    }

    @PostMapping
    @Transactional
    public ResponseEntity<PacienteEntity> cadastrar(@RequestBody @Valid DadosCadastroPaciente pacienteDto) {
        PacienteEntity paciente = new PacienteEntity(pacienteDto);
//        BeanUtils.copyProperties(pacienteDto, paciente, "atendido", "hora");
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(paciente));
    }

    @Transactional
    @PutMapping("/{cpf}")
    public ResponseEntity<Object> atualizar(@PathVariable String cpf, @RequestBody @Valid DadosAtualizacaoPaciente pacienteDto) {
        Optional<PacienteEntity> pacienteOptional = repository.findByCpf(cpf);
        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }
        PacienteEntity paciente = pacienteOptional.get();
        paciente.atualizarInformacoes(pacienteDto);
//        BeanUtils.copyProperties(pacienteDto, paciente);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(paciente));
    }

//    @Transactional
//    @PutMapping("/atendido/{cpf}")
//    public ResponseEntity<?> atualizar(@PathVariable String cpf, @RequestBody @Valid DadosAlteracaoAtendido paciente, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            // Tratativa de erros de validação
//            List<String> erros = new ArrayList<>();
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                erros.add(error.getField() + " -> " + error.getDefaultMessage());
//            }
//            return ResponseEntity.badRequest().body("Erros de validação: \n" + erros);
//        }
//        try {
//            service.atualizarAtendidoPorCpf(cpf, paciente);
//            return ResponseEntity.status(200).build();
//        } catch (InvalidRequestException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        Optional<PacienteEntity> paciente = repository.findById(id);
        if (paciente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso!");
    }
}