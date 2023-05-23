package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ESexo;

public record DadosCadastroPaciente(

        String guia,
        String registro,
        ECategoria categoria,
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