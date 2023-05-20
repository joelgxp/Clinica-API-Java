package br.com.jvsmed.api.dto;

import br.com.jvsmed.api.paciente.Paciente;

public class PacienteDto {

    private String nome;

    public PacienteDto(Paciente paciente) {
        this.nome = paciente.getNome();
    }

    public String getNome() {
        return this.nome;
    }
}
