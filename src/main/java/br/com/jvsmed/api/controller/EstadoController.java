package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.entities.EstadoEntity;
import br.com.jvsmed.api.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<EstadoEntity> getAllEstados() {
        return estadoRepository.findAll(Sort.by("nome"));
    }

}
