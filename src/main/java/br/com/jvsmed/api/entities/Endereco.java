package br.com.jvsmed.api.entities;

import br.com.jvsmed.api.dto.DadosEnderecoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;

    private String numero;

    private String bairro;

    private String cidade;

    private String cep;

    private String complemento;

    @Column(name = "uf_cidade")
    private String ufCidade;

    public Endereco(DadosEnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.cep = endereco.cep();
        this.complemento = endereco.complemento();
        this.ufCidade = endereco.ufCidade();
    }
}
