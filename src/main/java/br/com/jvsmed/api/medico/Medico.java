package br.com.jvsmed.api.medico;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import br.com.jvsmed.api.medico.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@Table(name = "medicos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, message = "Deve ter no minimo 3 caracteres")
    @NotBlank(message = "Campo nome obrigatorio")
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Email(message = "Email invalido")
    @NotBlank(message = "Campo email obrigatorio")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "Campo tefone obrigatorio")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @NotBlank(message = "Campo CRM obrigatorio")
    @Column(name = "crm", length = 6, nullable = false)
    private String crm;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        //this.especialidade = dados.especialidade();
        //this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

    }

    public void inativar() {
        this.ativo = false;
    }
}
