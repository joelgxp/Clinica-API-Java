package br.com.jvsmed.api.paciente;

import br.com.jvsmed.api.cnh.Categoria;

public record DadosListagemPaciente(
        Long id,
        String guia,
        String registro,
        Categoria categoria,
        String data_cadastro,
        String data_habilitacao,
        String nome,
        String data_nascimento,
        String sexo,
        String cpf,
        String nacionalidade,
        String nome_mae,
        String nome_pai,
        String telefone,
        String logradouro,
        String bairro,
        String cep,
        String numero,
        String complemento,
        String cidade,
        String uf
) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(),
            paciente.getGuia(),
            paciente.getRegistro(),
            paciente.getCategoria(),
            paciente.getData_cadastro(),
            paciente.getData_habilitacao(),
            paciente.getNome(),
            paciente.getData_nascimento(),
            paciente.getSexo(),
            paciente.getCpf(),
            paciente.getNacionalidade(),
            paciente.getNome_mae(),
            paciente.getNome_pai(),
            paciente.getTelefone(),
            paciente.getLogradouro(),
            paciente.getBairro(),
            paciente.getCep(),
            paciente.getNumero(),
            paciente.getComplemento(),
            paciente.getCidade(),
            paciente.getUf()
        );
    }
}
