package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.entities.Paciente;
import br.com.jvsmed.api.enums.ECategoria;

public record DadosListagemPaciente(
        Long id,
        String guia,
        String registro,
        ECategoria categoria,
        String data_cadastro,
        String nome,
        String data_nascimento,
        String sexo,
        String cpf,
        String nome_mae,
        String nome_pai,
        String telefone
) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(),
                paciente.getGuia(),
                paciente.getRegistro(),
                paciente.getCategoria(),
                paciente.getDataCadastro(),
                paciente.getNome(),
                paciente.getDataNascimento(),
                paciente.getSexo(),
                paciente.getCpf(),
                paciente.getNomeMae(),
                paciente.getNomePai(),
                paciente.getTelefone()
        );
    }
}
