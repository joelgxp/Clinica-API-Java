package br.com.jvsmed.api.registro.medico;

import br.com.jvsmed.api.entities.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, String telefone) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone());
    }
}
