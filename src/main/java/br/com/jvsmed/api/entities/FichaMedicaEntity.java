package br.com.jvsmed.api.entities;

import br.com.jvsmed.api.registro.fichaMedica.DadosCadastroFichaMedica;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ficha_medica")
@Entity(name = "FichaMedicaEntity")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class FichaMedicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_paciente")
    private Long idPaciente;

    @Column(name = "ladoesquerdo")
    private String ladoEsquerdo;

    @Column(name = "ladodireito")
    private String ladoDireito;

    private String correcao;

    @Column(name = "examevalidade")
    private String exameValidade;


    public FichaMedicaEntity(DadosCadastroFichaMedica dados) {
        this.idPaciente = dados.idPaciente();
        this.ladoEsquerdo = dados.ladoEsquerdo();
        this.ladoDireito = dados.ladoDireito();
        this.correcao = dados.correcao();
        this.exameValidade = dados.exameValidade();
    }

    public void setIdPaciente(Long id) {
    }
}
