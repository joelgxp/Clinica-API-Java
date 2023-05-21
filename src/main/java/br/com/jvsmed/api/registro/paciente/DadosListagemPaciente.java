package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.entities.PacienteEntity;
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
    public DadosListagemPaciente(PacienteEntity pacienteEntity) {
        this(pacienteEntity.getId(),
                pacienteEntity.getGuia(),
                pacienteEntity.getRegistro(),
                pacienteEntity.getCategoria(),
                pacienteEntity.getDataCadastro(),
                pacienteEntity.getNome(),
                pacienteEntity.getDataNascimento(),
                pacienteEntity.getSexo(),
                pacienteEntity.getCpf(),
                pacienteEntity.getNomeMae(),
                pacienteEntity.getNomePai(),
                pacienteEntity.getTelefone()
        );
    }
}
