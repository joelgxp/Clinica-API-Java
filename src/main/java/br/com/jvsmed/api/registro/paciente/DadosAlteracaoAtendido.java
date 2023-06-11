package br.com.jvsmed.api.registro.paciente;

import jakarta.validation.constraints.Size;

public record DadosAlteracaoAtendido(


        String cpf,
        boolean atendido

) {

}