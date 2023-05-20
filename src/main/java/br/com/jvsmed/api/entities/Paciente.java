package br.com.jvsmed.api.entities;

import br.com.jvsmed.api.registro.paciente.DadosAtualizacaoPaciente;
import br.com.jvsmed.api.registro.paciente.DadosCadastroPaciente;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guia;
    private String registro;
    private String categoria;
    private String data_cadastro;
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String cpf;
    private String nome_mae;
    private String nome_pai;
    private String telefone;

    public Paciente(DadosCadastroPaciente dados) {
        this.id = id;
        this.guia = dados.guia();
        this.registro = dados.registro();
        this.categoria = String.valueOf(dados.categoria());
        this.data_cadastro = dados.data_cadastro();
        this.nome = dados.nome();
        this.data_nascimento = dados.data_nascimento();
        this.sexo = String.valueOf(dados.sexo());
        this.cpf = dados.cpf();
        this.nome_mae = dados.nome_mae();
        this.nome_pai = dados.nome_pai();
        this.telefone = dados.telefone();
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
        if (dados.nome_mae() != null) {
            this.nome_mae = dados.nome_mae();
        }
        if (dados.nome_pai() != null) {
            this.nome_pai = dados.nome_pai();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }
}
