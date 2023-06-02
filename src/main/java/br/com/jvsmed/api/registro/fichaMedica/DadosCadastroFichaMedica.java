package br.com.jvsmed.api.registro.fichaMedica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFichaMedica(
        @NotNull
        Long idPaciente,
        @NotBlank
        String ladoEsquerdo,
        @NotBlank
        String ladoDireito,
        @NotBlank
        String correcao,
        @NotBlank
        String exameValidade
) {

}