package br.com.jvsmed.api.registro.paciente;


import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ENacionalidade;
import br.com.jvsmed.api.enums.ESexo;
import br.com.jvsmed.api.enums.ESolicitacao;

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
