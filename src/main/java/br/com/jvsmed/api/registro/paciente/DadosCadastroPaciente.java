package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ESexo;
import br.com.jvsmed.api.enums.ESolicitacao;

public record DadosCadastroPaciente(

        String guia,
        String registro,
        ECategoria categoria,
        ESolicitacao solicitacao,
        String dataCadastro,
        String nome,
        String dataNascimento,
        ESexo sexo,
        String cpf,
        String nomeMae,
        String nomePai,
        String telefone
) {
}