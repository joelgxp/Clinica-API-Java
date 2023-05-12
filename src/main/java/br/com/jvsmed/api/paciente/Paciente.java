package br.com.jvsmed.api.paciente;

import br.com.jvsmed.api.endereco.Endereco;
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
    private String solicitacao;
    private String categoria;
    private String dataCadastro;
    private String dataHabilitacao;
    private String nome;
    private String dataNascimento;
    private String sexo;
    private String cpf;
    private String nacionalidade;
    private String nomeMae;
    private String nomePai;
    private String telefone;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.guia = dados.guia();
        this.registro = dados.registro();
        this.solicitacao = String.valueOf(dados.solicitacao());
        this.categoria = String.valueOf(dados.categoria());
        this.dataCadastro = dados.dataCadastro();
        this.dataHabilitacao = dados.dataHabilitacao();
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.sexo = String.valueOf(dados.sexo());
        this.cpf = dados.cpf();
        this.nacionalidade = dados.nacionalidade();
        this.nomeMae = dados.nomeMae();
        this.nomePai = dados.nomePai();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.guia() != null) {
            this.guia = dados.guia();
        }
        if (dados.solitacao() != null) {
            this.solicitacao = String.valueOf(dados.solitacao());
        }


        if (dados.categoria() != null) {
            this.categoria = String.valueOf(dados.categoria());
        }
        if (dados.dataCadastro() != null) {
            this.dataCadastro = dados.dataCadastro();
        }
        if (dados.nomeMae() != null) {
            this.nomeMae = dados.nomeMae();
        }
        if (dados.nomePai() != null) {
            this.nomePai = dados.nomePai();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
