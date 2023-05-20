package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.dto.PacienteDto;
import br.com.jvsmed.api.paciente.DadosAtualizacaoPaciente;
import br.com.jvsmed.api.paciente.DadosCadastroPaciente;
import br.com.jvsmed.api.paciente.Paciente;
import br.com.jvsmed.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService service) {
        pacienteService = service;
    }

    @GetMapping
    public Iterable<Paciente> listar() {
        return pacienteService.findAll();
    }

//    @GetMapping("/{cpf}")
//    public DadosListagemPaciente buscarPorID(@PathVariable String cpf) {
//        return new DadosListagemPaciente(pacienteService.buscarPorId(cpf));
//    }

    @GetMapping("/{cpf}")
    public PacienteDto buscarPorCPF(@PathVariable String cpf) {
        return new PacienteDto(pacienteService.buscarPorCpf(cpf));
    }

    @PostMapping
    public void cadastrar(@RequestBody Paciente paciente) {
        pacienteService.criarPaciente(paciente);
    }

    @PutMapping
    public void atualizar(@RequestBody Paciente paciente) {
        pacienteService.atualizarPaciente(paciente);
//        var paciente = repository.getReferenceById(dados.id());
//        paciente.atualizarInformacoes(dados);
    }

//    @Transactional
//    @DeleteMapping("/{id}")
//    public void remover(@PathVariable Long id) {
//        var paciente = repository.getReferenceById(id);
//        paciente.inativar();
//    }
}
