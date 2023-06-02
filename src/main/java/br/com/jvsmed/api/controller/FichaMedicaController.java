package br.com.jvsmed.api.controller;


import br.com.jvsmed.api.entities.FichaMedicaEntity;
import br.com.jvsmed.api.registro.fichaMedica.DadosCadastroFichaMedica;
import br.com.jvsmed.api.repositories.FichaMedicaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("ficha_medica")
public class FichaMedicaController {

    @Autowired
    private FichaMedicaRepository repository;

    @GetMapping
    public Iterable<FichaMedicaEntity> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{idPaciente}")
    public List<FichaMedicaEntity> findByIdPaciente(@PathVariable Long id) {
        FichaMedicaEntity fichaMedicaEntity = new FichaMedicaEntity();
        fichaMedicaEntity.setIdPaciente(id);

        return repository.findByIdPaciente(fichaMedicaEntity);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroFichaMedica dados) {
        repository.save(new FichaMedicaEntity(dados));
    }
}