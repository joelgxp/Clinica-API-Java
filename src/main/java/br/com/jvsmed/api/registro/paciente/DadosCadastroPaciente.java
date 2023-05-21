package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ESexo;

public record DadosCadastroPaciente(

        String guia,
        String registro,
        ECategoria categoria,
        String data_cadastro,
        String nome,
        String data_nascimento,
        ESexo sexo,
        String cpf,
        String nome_mae,
        String nome_pai,
        String telefone
) {
}
