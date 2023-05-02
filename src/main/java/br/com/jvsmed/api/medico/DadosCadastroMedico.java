package br.com.jvsmed.api.medico;

import br.com.jvsmed.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {

}
