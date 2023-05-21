package br.com.jvsmed.api.entities;

import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.registro.paciente.DadosAtualizacaoPaciente;
import br.com.jvsmed.api.registro.paciente.DadosCadastroPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

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
    private ECategoria categoria;
    @Column(name = "data_cadastro")
    private String dataCadastro;
    private String nome;
    @Column(name = "data_nascimento")
    private String dataNascimento;
    private String sexo;
    private String cpf;
    @Column(name = "nome_mae")
    private String nomeMae;
    @Column(name = "nome_pai")
    private String nomePai;
    private String telefone;

    public Paciente(DadosCadastroPaciente dados) {
//        BeanUtils.copyProperties(dados, this);
        this.id = id;
        this.guia = dados.guia();
        this.registro = dados.registro();
        this.categoria = dados.categoria();
        this.dataCadastro = dados.data_cadastro();
        this.nome = dados.nome();
        this.dataNascimento = dados.data_nascimento();
        this.sexo = String.valueOf(dados.sexo());
        this.cpf = dados.cpf();
        this.nomeMae = dados.nome_mae();
        this.nomePai = dados.nome_pai();
        this.telefone = dados.telefone();
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.guia() != null) {
            this.guia = dados.guia();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
        if (dados.data_cadastro() != null) {
            this.dataCadastro = dados.data_cadastro();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.data_nascimento() != null) {
            this.dataNascimento = dados.data_nascimento();
        }
        if (dados.sexo() != null) {
            this.sexo = String.valueOf(dados.sexo());
        }
        if (dados.nome_mae() != null) {
            this.nomeMae = dados.nome_mae();
        }
        if (dados.nome_pai() != null) {
            this.nomePai = dados.nome_pai();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }
}
