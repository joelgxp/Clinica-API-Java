package br.com.jvsmed.api.controller;

import br.com.jvsmed.api.entities.MunicipioEntity;
import br.com.jvsmed.api.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    @Autowired
    private MunicipioRepository municipioRepository;

    @GetMapping
    public List<MunicipioEntity> getAllMunicipios() {
        return municipioRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    public List<MunicipioEntity> getMunicipiosByUf(@PathVariable String estadoId) {
        return municipioRepository.findByEstadoId(estadoId);
    }
}
