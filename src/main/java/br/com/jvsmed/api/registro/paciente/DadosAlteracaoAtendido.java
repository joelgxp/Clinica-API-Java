package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ENacionalidade;
import br.com.jvsmed.api.enums.ESexo;
import br.com.jvsmed.api.enums.ESolicitacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;


public record DadosAlteracaoAtendido(

        @Size(min = 11, max = 14, message = "CPF deve ter exatamente 11 dígitos")
        String cpf,
        boolean atendido

) {

}