package br.com.jvsmed.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

@Entity
    @Table(name = "medico")
public class MedicoModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Size(min = 3, message = "Deve ter no minimo 3 caracteres")
        @NotBlank(message = "Campo nome obrigatorio")
        @Column(name = "nome", length = 200, nullable = false)
        private String nome;

        @Email(message = "Email invalido")
        @NotBlank(message = "Campo email obrigatorio")
        @Column(name = "email", length = 50, nullable = false)
        private String email;

        @NotBlank(message = "Campo senha obrigatorio")
        @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
        private String senha;

        @NotBlank(message = "Campo tefone obrigatorio")
        @Column(name = "telefone", length = 15, nullable = false)
        private String telefone;

}
