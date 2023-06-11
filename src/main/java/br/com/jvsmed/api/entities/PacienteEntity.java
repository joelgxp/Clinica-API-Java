package br.com.jvsmed.api.entities;

import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ENacionalidade;
import br.com.jvsmed.api.enums.ESexo;
import br.com.jvsmed.api.enums.ESolicitacao;
import br.com.jvsmed.api.registro.paciente.DadosCadastroPaciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private String telefone;

    private String cpf;

    private Integer status;

    @Embedded
    private Endereco endereco;

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
    }

//    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
//        if (dados.guia() != null) {
//            this.guia = dados.guia();
//        }
//        if (dados.categoria() != null) {
//            this.categoria = dados.categoria();
//        }
//        if (dados.dataCadastro() != null) {
//            this.dataCadastro = dados.dataCadastro();
//        }
//        if (dados.nome() != null) {
//            this.nome = dados.nome();
//        }
//        if (dados.dataNascimento() != null) {
//            this.dataNascimento = dados.dataNascimento();
//        }
//        if (dados.sexo() != null) {
//            this.sexo = String.valueOf(dados.sexo());
//        }
//        if (dados.nomeMae() != null) {
//            this.nomeMae = dados.nomeMae();
//        }
//        if (dados.nomePai() != null) {
//            this.nomePai = dados.nomePai();
//        }
//        if (dados.telefone() != null) {
//            this.telefone = dados.telefone();
//        }
//    }
}
