package br.com.jvsmed.api.medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade, boolean ativo) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getAtivo());
    }
}
