package br.com.jvsmed.api.enums;

public enum ESolicitacao {
    CADASTRO_CNH("Habilitação"),
    RENOVACAO_CNH("Renovação"),
    ADICAO_CATEGORIA("Adição"),
    MUDANCA_CATEGORIA("Mudança");

    private String solicitacao;

    ESolicitacao(String solicitacao) {
        this.solicitacao = solicitacao;
    }

    public String getSolicitacao() {
        return solicitacao;
    }

}
