package br.com.jvsmed.api.registro.paciente;

import java.sql.Time;

public record DadosAlteracaoAtendido(
        String cpf,
        Time hora,
        boolean atendido

) {

}