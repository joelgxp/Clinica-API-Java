package br.com.jvsmed.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "estados")
public class EstadoEntity {

    @Id
    private Integer id;
    private String nome;
    private String sigla;
}
