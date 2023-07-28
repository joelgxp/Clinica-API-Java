package br.com.jvsmed.api.registro.paciente;

import java.sql.Time;

public record DadosAlteracaoAtendido(
        Time hora,
        boolean atendido

) {

}