package br.com.jvsmed.api.dto;

public record DadosEnderecoDTO(

        String logradouro,

        String numero,

        String bairro,

        String cidade,

        String ufCidade,

        String cep,

        String complemento
) {

}
