package br.com.jvsmed.api.dto;

import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ESolicitacao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
public class PacienteDto {

    private String guia;
    private String registro;
    private ECategoria categoria;
    private ESolicitacao solicitacao;
    private String data_cadastro;
    private String data_habilitacao;
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String identidade;
    private String orgao;
    private String ufIdentidade;
    private String naturalidade;
    private String ufNaturalidade;
    private String nacionalidade;
    private String nome_mae;
    private String nome_pai;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String ufCidade;
    private String cep;
    private String complemento;
    private String uf;
    private String cpf;
    private String telefone;
    private Integer status;

    public PacienteDto(PacienteEntity pacienteEntity) {
        BeanUtils.copyProperties(pacienteEntity, this);
    }

}
