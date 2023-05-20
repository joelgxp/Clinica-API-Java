package br.com.jvsmed.api.paciente;

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
