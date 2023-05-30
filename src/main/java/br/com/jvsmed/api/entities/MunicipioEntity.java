package br.com.jvsmed.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "municipios")
public class MunicipioEntity {

    @Id
    private Integer id;
    private String nome;
    @Column(name = "estado_id")
    private Integer estadoId;

}
