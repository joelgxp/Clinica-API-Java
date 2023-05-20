package br.com.jvsmed.api.dto;

import br.com.jvsmed.api.cnh.Categoria;
import br.com.jvsmed.api.paciente.Paciente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
public class PacienteDto {

    private String guia;
    private String registro;
    private String nome;
    private String data_cadastro;
    private String data_habilitacao;
    private String data_nascimento;
    private String sexo;
    private String cpf;
    private String nacionalidade;
    private String nome_mae;
    private String nome_pai;
    private String telefone;
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private Categoria categoria;

    public PacienteDto(Paciente paciente) {
        BeanUtils.copyProperties(paciente, this);
    }

}
