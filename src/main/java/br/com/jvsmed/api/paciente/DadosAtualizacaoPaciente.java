package br.com.jvsmed.api.paciente;

import br.com.jvsmed.api.cnh.Categoria;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String guia,
        String registro,
        Categoria categoria,
        String data_cadastro,
        String data_habilitacao,
        String nome,
        String data_nascimento,
        String sexo,
        String cpf,
        String nacionalidade,
        String nome_mae,
        String nome_pai,
        String telefone,
        String logradouro,
        String bairro,
        String cep,
        String numero,
        String complemento,
        String cidade,
        String uf
) {

}
