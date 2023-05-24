package br.com.jvsmed.api.entities;

import br.com.jvsmed.api.enums.ECategoria;
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

    @NotBlank
    private String guia;

    private String registro;

    private ECategoria categoria;

    @Column(name = "data_cadastro")
    @NotBlank
    private String dataCadastro;

    @NotBlank
    private String nome;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    private String sexo;

    @NotBlank
    @Size(min = 11, max = 11, message = "CPF deve ter exatamente 11 dígitos")
    private String cpf;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Column(name = "nome_pai")
    private String nomePai;

    private String telefone;

    public PacienteEntity(DadosCadastroPaciente dados) {
//        BeanUtils.copyProperties(dados, this);
        this.guia = dados.guia();
        this.registro = dados.registro();
        this.categoria = dados.categoria();
        this.dataCadastro = dados.dataCadastro();
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.sexo = String.valueOf(dados.sexo());
        this.cpf = dados.cpf();
        this.nomeMae = dados.nomeMae();
        this.nomePai = dados.nomePai();
        this.telefone = dados.telefone();
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
