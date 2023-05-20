package br.com.jvsmed.api.medico;

public record DadosListagemMedico(Long id,
                                  String nome,
                                  String email,
                                  String crm,
                                  String telefone,
                                  Especialidade especialidade,
                                  boolean ativo) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                Especialidade.valueOf(String.valueOf(medico.getEspecialidade())),
                medico.getAtivo());
    }
}
