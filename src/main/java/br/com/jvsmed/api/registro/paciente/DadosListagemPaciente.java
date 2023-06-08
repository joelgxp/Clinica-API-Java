package br.com.jvsmed.api.registro.paciente;

import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ESolicitacao;

public record DadosListagemPaciente(
        Long id,
        String guia,
        String registro,
        String solicitacao,
        ECategoria categoria,
        String dataCadastro,
        String nome,
        String dataNascimento,
        String sexo,
        String cpf,
        String nomeMae,
        String nomePai,
        String telefone
) {
    public DadosListagemPaciente(PacienteEntity pacienteEntity) {
        this(pacienteEntity.getId(),
                pacienteEntity.getGuia(),
                pacienteEntity.getRegistro(),
                pacienteEntity.getSolicitacao(),
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
