package br.com.jvsmed.api.entities;

import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ENacionalidade;
import br.com.jvsmed.api.enums.ESexo;
import br.com.jvsmed.api.enums.ESolicitacao;
import br.com.jvsmed.api.registro.paciente.DadosAlteracaoAtendido;
import br.com.jvsmed.api.registro.paciente.DadosAtualizacaoPaciente;
import br.com.jvsmed.api.registro.paciente.DadosCadastroPaciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Table(name = "pacientes")
@Entity(name = "PacienteEntity")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guia;

    private String registro;

    @Enumerated(EnumType.STRING)
    private ECategoria categoria;

    @Enumerated(EnumType.STRING)
    private ESolicitacao solicitacao;

    @Column(name = "data_cadastro")
    private String dataCadastro;

    @Column(name = "data_habilitacao")
    private String dataHabilitacao;

    private String nome;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Enumerated(EnumType.STRING)
    private ESexo sexo;

    private String identidade;

    private String orgao;

    @Column(name = "uf_identidade")
    private String ufIdentidade;

    private String naturalidade;

    @Column(name = "uf_naturalidade")
    private String ufNaturalidade;

    @Enumerated(EnumType.STRING)
    private ENacionalidade nacionalidade;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Column(name = "nome_pai")
    private String nomePai;

    private String logradouro;

    private String numero;

    private String bairro;

    private String cidade;

    @Column(name = "uf_cidade")
    private String ufCidade;

    private String cep;

    private String complemento;

    private String telefone;

    private String cpf;

    private Integer status;

    @Embedded
    private Endereco endereco;

    private Boolean atendido;

    private Time hora;
    public PacienteEntity(DadosCadastroPaciente dados) {
//        BeanUtils.copyProperties(dados, this);
        this.guia = dados.guia();
        this.registro = dados.registro();
        this.categoria = dados.categoria();
        this.solicitacao = dados.solicitacao();
        this.dataCadastro = dados.dataCadastro();
        this.dataHabilitacao = dados.dataHabilitacao();
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.sexo = dados.sexo();
        this.identidade = dados.identidade();
        this.orgao = dados.orgao();
        this.ufIdentidade = dados.ufIdentidade();
        this.naturalidade = dados.naturalidade();
        this.ufNaturalidade = dados.ufNaturalidade();
        this.nacionalidade = dados.nacionalidade();
        this.nomeMae = dados.nomeMae();
        this.nomePai = dados.nomePai();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.status = 0;
        this.endereco = new Endereco(dados.endereco());
        this.atendido = null;
    }


    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.guia() != null) {
            this.guia = dados.guia();
        }
        if (dados.registro() != null) {
            this.registro = dados.registro();
        }
        if (dados.solicitacao() != null) {
            this.solicitacao = dados.solicitacao();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
        if (dados.dataCadastro() != null) {
            this.dataCadastro = dados.dataCadastro();
        }
        if (dados.dataHabilitacao() != null) {
            this.dataHabilitacao = dados.dataHabilitacao();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.dataNascimento() != null) {
            this.dataNascimento = dados.dataNascimento();
        }
        if (dados.sexo() != null) {
            this.sexo = dados.sexo();
        }
        if (dados.identidade() != null) {
            this.identidade = dados.identidade();
        }
        if (dados.orgao() != null) {
            this.orgao = dados.orgao();
        }
        if (dados.ufIdentidade() != null) {
            this.ufIdentidade = dados.ufIdentidade();
        }
        if (dados.naturalidade() != null) {
            this.naturalidade = dados.naturalidade();
        }
        if (dados.ufNaturalidade() != null) {
            this.ufNaturalidade = dados.ufNaturalidade();
        }
        if (dados.nacionalidade() != null) {
            this.nacionalidade = dados.nacionalidade();
        }
        if (dados.nomeMae() != null) {
            this.nomeMae = dados.nomeMae();
        }
        if (dados.nomePai() != null) {
            this.nomePai = dados.nomePai();
        }
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.ufCidade() != null) {
            this.ufCidade = dados.ufCidade();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }

    public void atualizarAtendido(DadosAlteracaoAtendido dados) {
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.hora() != null) {
            this.hora = (Time) dados.hora();
        }
        this.atendido = dados.atendido();
    }
}
