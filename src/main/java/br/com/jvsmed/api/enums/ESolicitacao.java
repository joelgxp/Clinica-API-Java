package br.com.jvsmed.api.enums;

public enum ESolicitacao {
    CADASTRO_CNH("Primeira habilitação"),
    RENOVACAO_CNH("Renovação de exame"),
    ADICAO_CATEGORIA("Adição de categoria"),
    MUDANCA_CATEGORIA("Mudança de categoria");

    private final String descricao;

    ESolicitacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ESolicitacao getByDescricao(String descricao) {
        for (ESolicitacao solicitacao : ESolicitacao.values()) {
            if (solicitacao.getDescricao().equals(descricao)) {
                return solicitacao;
            }
        }
        throw new IllegalArgumentException("Descrição de Solicitacao inválida: " + descricao);
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}