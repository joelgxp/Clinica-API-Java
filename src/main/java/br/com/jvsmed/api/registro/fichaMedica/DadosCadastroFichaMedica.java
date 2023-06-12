package br.com.jvsmed.api.registro.fichaMedica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFichaMedica(
        @NotNull
        Integer idPaciente,
        @NotBlank
        String ladoEsquerdo,
        @NotBlank
        String ladoDireito,
        @NotBlank
        String correcao,
        @NotBlank
        String campoVisualDireito,
        @NotBlank
        String campoVisualEsquerdo,
        @NotBlank
        String exameValidade,
        @NotBlank
        String conclusao,

        String complemento
) {

}
