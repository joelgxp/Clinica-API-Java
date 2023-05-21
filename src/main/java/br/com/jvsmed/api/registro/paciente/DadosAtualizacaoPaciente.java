package br.com.jvsmed.api.registro.paciente;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String guia,
        String categoria,
        String data_cadastro,
        String nome,
        String data_nascimento,
        String sexo,
        String nome_mae,
        String nome_pai,
        String telefone
) {

}
