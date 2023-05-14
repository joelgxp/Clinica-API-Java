package br.com.jvsmed.api.medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, boolean ativo) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getAtivo());
    }
}
