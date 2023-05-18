package br.com.jvsmed.api.paciente;

import br.com.jvsmed.api.cnh.Categoria;
import br.com.jvsmed.api.cnh.Solicitacao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(

        String guia,
        String registro,
//        @NotNull
//        Solicitacao solicitacao,
        Categoria categoria,
        String data_cadastro,
        String data_habilitacao,
        String nome,
        String data_nascimento,
        Sexo sexo,
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
