package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.enums.ECategoria;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String guia,
        ECategoria categoria,
        String dataCadastro,
        String nome,
        String dataNascimento,
        String sexo,
        String nomeMae,
        String nomePai,
        String telefone
) {

}
