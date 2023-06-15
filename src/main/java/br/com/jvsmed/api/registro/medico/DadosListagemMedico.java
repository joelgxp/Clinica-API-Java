package br.com.jvsmed.api.registro.medico;

import br.com.jvsmed.api.entities.MedicoEntity;

public record DadosListagemMedico(Long id, String nome, String email, String crm, String telefone) {

    public DadosListagemMedico(MedicoEntity medicoEntity) {
        this(medicoEntity.getId(), medicoEntity.getNome(), medicoEntity.getEmail(), medicoEntity.getCrm(), medicoEntity.getTelefone());
    }
}
