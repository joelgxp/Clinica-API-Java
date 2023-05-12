package br.com.jvsmed.api.paciente;

import br.com.jvsmed.api.cnh.Solicitacao;
import br.com.jvsmed.api.endereco.DadosAtualizacaoEndereco;
import br.com.jvsmed.api.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String guia,
        Solicitacao solitacao,
        String categoria,
        String dataCadastro,
        String nomeMae,
        String nomePai,
        String telefone,
        @Valid DadosAtualizacaoEndereco endereco
) {
}
