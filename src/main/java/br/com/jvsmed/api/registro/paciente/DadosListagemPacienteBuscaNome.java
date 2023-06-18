package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.entities.PacienteEntity;

public record DadosListagemPacienteBuscaNome(
        Long id,
        String nome,
        String cpf
) {
    public DadosListagemPacienteBuscaNome(PacienteEntity pacienteEntity) {
        this(pacienteEntity.getId(),
                pacienteEntity.getNome(),
                pacienteEntity.getCpf()
        );
    }

}
