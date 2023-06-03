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

        String campoVisualDireito,

        String campoVisualEsquerdo,
        @NotBlank
        String exameValidade,

        String conclusao,

        String complemento
) {

}
