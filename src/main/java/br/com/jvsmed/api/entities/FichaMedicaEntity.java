package br.com.jvsmed.api.entities;

import br.com.jvsmed.api.registro.fichaMedica.DadosCadastroFichaMedica;
import jakarta.persistence.*;
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
    private Integer idPaciente;

    @Column(name = "data_exame")
    private String dataExame;

    @Column(name = "ladoesquerdo")
    private String ladoEsquerdo;

    @Column(name = "ladodireito")
    private String ladoDireito;

    private String correcao;

    @Column(name = "campo_visual_direito")
    private String campoVisualDireito;

    @Column(name = "campo_visual_esquerdo")
    private String campoVisualEsquerdo;

    @Column(name = "examevalidade")
    private String exameValidade;

    private String conclusao;

    private String complemento;


    public FichaMedicaEntity(DadosCadastroFichaMedica dados) {
        this.idPaciente = dados.idPaciente();
        this.dataExame = dados.dataExame();
        this.ladoEsquerdo = dados.ladoEsquerdo();
        this.ladoDireito = dados.ladoDireito();
        this.correcao = dados.correcao();
        this.campoVisualDireito = dados.campoVisualDireito();
        this.campoVisualEsquerdo = dados.campoVisualEsquerdo();
        this.exameValidade = dados.exameValidade();
        this.conclusao = dados.conclusao();
        this.complemento = dados.complemento();
    }

    public void setIdPaciente(Integer idPaciente) {
    }
}
