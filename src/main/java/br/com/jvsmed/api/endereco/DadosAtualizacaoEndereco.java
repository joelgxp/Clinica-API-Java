package br.com.jvsmed.api.endereco;

public record DadosAtualizacaoEndereco(
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    String cidade,
    String uf,
    String cep
    ) {
}
