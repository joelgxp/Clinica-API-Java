package br.com.jvsmed.api.entities;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class FichaMedicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "id_paciente")
    private Long idPaciente;
    @NotBlank
    @Column(name = "lado_esquerdo")
    private String ladoEsquerdo;
    @NotBlank
    @Column(name = "lado_direito")
    private String ladoDireito;
    @NotBlank
    private String correcao;

    public FichaMedicaEntity(Long idPaciente, String ladoEsquerdo, String ladoDireito, String correcao) {
        this.idPaciente = idPaciente;
        this.ladoEsquerdo = ladoEsquerdo;
        this.ladoDireito = ladoDireito;
        this.correcao = correcao;
    }
}
