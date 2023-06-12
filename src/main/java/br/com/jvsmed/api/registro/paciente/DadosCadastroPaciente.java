package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ENacionalidade;
import br.com.jvsmed.api.enums.ESexo;
import br.com.jvsmed.api.enums.ESolicitacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;



public record DadosCadastroPaciente(

        @NotBlank
        String guia,
        @NotBlank
        String registro,
        @NotNull
        ECategoria categoria,
        @NotNull
        ESolicitacao solicitacao,
        @NotBlank
        String dataCadastro,
        @NotBlank
        String dataHabilitacao,
        @NotBlank
        String nome,
        @NotBlank
        String dataNascimento,
        ESexo sexo,
        @NotBlank
        String identidade,
        @NotBlank
        String orgao,
        String ufIdentidade,
        String naturalidade,
        String ufNaturalidade,
        ENacionalidade nacionalidade,
        @NotBlank
        String nomeMae,
        @NotBlank
        String nomePai,
        @NotBlank
        String logradouro,
        @NotBlank
        String numero,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String ufCidade,
        @NotBlank
        @Size(min = 8, max = 8, message = "CEP deve ter exatamente 8 dígitos")
        String cep,
        String complemento,
        @Size(min = 11, max = 14, message = "CPF deve ter exatamente 11 dígitos")
        String cpf,
        String telefone,
        Boolean atendido
) {

}