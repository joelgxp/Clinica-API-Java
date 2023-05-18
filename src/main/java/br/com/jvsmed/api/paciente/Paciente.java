package br.com.jvsmed.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")


public class Paciente {
    private Boolean ativo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guia;
    private String registro;
    //private String solicitacao;
    private String categoria;
    private String data_cadastro;
    private String data_habilitacao;
    private String nome;
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

    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.id = id;
        this.guia = dados.guia();
        this.registro = dados.registro();
        this.categoria = String.valueOf(dados.categoria());
        this.data_cadastro = dados.data_cadastro();
        this.data_habilitacao = dados.data_habilitacao();
        this.nome = dados.nome();
        this.data_nascimento = dados.data_nascimento();
        this.sexo = String.valueOf(dados.sexo());
        this.cpf = dados.cpf();
        this.nacionalidade = dados.nacionalidade();
        this.nome_mae = dados.nome_mae();
        this.nome_pai = dados.nome_pai();
        this.telefone = dados.telefone();
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.guia() != null) {
            this.guia = dados.guia();
        }
        if (dados.registro() != null) {
            this.registro = dados.registro();
        }
        if (dados.categoria() != null) {
            this.categoria = String.valueOf(dados.categoria());
        }
        if (dados.data_cadastro() != null) {
            this.data_cadastro = dados.data_cadastro();
        }
        if (dados.data_habilitacao() != null) {
            this.data_habilitacao = dados.data_habilitacao();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.data_nascimento() != null) {
            this.data_nascimento = dados.data_nascimento();
        }
        if (dados.sexo() != null) {
            this.sexo = String.valueOf(dados.sexo());
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.nacionalidade() != null) {
            this.nacionalidade = dados.nacionalidade();
        }
        if (dados.nome_mae() != null) {
            this.nome_mae = dados.nome_mae();
        }
        if (dados.nome_pai() != null) {
            this.nome_pai = dados.nome_pai();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
