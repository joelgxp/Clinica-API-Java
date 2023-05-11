package br.com.jvsmed.api.paciente;

import br.com.jvsmed.api.cnh.Categoria;
import br.com.jvsmed.api.cnh.Solicitacao;
import br.com.jvsmed.api.endereco.DadosEndereco;
import br.com.jvsmed.api.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(
        @NotBlank
        String guia,
        @NotBlank
        String registro,
        @NotNull
        Solicitacao solicitacao,
        @NotNull
        Categoria categoria,
        @NotBlank
        String dataCadastro,
        @NotBlank
        String dataHabilitacao,
        @NotBlank
        String nome,
        @NotBlank
        String dataNascimento,
        @NotNull
        Sexo sexo,
        @NotBlank
        @Pattern(regexp = "\\d-{11}")
        String cpf,
        @NotBlank
        String nacionalidade,
        @NotBlank
        String uf,
        @NotBlank
        String nomeMae,
        String nomePai,
        @NotNull
        @Valid
        DadosEndereco endereco,
        @NotBlank
        String telefone

) {
}
