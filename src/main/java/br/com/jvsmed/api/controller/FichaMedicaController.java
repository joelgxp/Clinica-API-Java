package br.com.jvsmed.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/fichas-medica")
public class FichaMedicaController {
    @PostMapping("/{id_paciente}")
    public ResponseEntity<?> cadastrar(@PathVariable Long id_paciente) {
        return null;
    }
}
