package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.entities.Paciente;

public record DadosListagemPaciente(
        Long id,
        String guia,
        String registro,
        String categoria,
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
                paciente.getData_cadastro(),
                paciente.getNome(),
                paciente.getData_nascimento(),
                paciente.getSexo(),
                paciente.getCpf(),
                paciente.getNome_mae(),
                paciente.getNome_pai(),
                paciente.getTelefone()
        );
    }
}
