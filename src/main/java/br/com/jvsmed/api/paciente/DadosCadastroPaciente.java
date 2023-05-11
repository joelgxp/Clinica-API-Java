package br.com.jvsmed.api.paciente;

import br.com.jvsmed.api.cnh.Categoria;
import br.com.jvsmed.api.cnh.Solicitacao;
import br.com.jvsmed.api.endereco.Endereco;

public record DadosCadastroPaciente(
        String guia,
        String registro,
        Solicitacao solicitacao,
        Categoria categoria,
        String dataCadastro,
        String dataHabilitacao,
        String nome,
        String dataNascimento,
        String sexo,
        String cpf,
        String nacionalidade,
        String uf,
        String nomeMae,
        String nomePai,
        Endereco endereco


        ) {
}
