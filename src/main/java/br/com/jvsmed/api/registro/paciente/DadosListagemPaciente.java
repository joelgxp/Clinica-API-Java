package br.com.jvsmed.api.registro.paciente;


import br.com.jvsmed.api.entities.PacienteEntity;
import br.com.jvsmed.api.enums.ECategoria;
import br.com.jvsmed.api.enums.ENacionalidade;
import br.com.jvsmed.api.enums.ESexo;
import br.com.jvsmed.api.enums.ESolicitacao;

public record DadosListagemPaciente(
        Long id,
        String guia,
        String registro,
        ECategoria categoria,
        ESolicitacao solicitacao,
        String dataCadastro,
        String dataHabilitacao,
        String nome,
        String dataNascimento,
        ESexo sexo,
        String identidade,
        String orgao,
        String ufIdentidade,
        String naturalidade,
        String ufNaturalidade,
        ENacionalidade nacionalidade,
        String nomeMae,
        String nomePai,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String ufCidade,
        String cep,
        String complemento,
        String cpf,
        String telefone,
        Integer status
) {
    public DadosListagemPaciente(PacienteEntity pacienteEntity) {
        this(pacienteEntity.getId(),
                pacienteEntity.getGuia(),
                pacienteEntity.getRegistro(),
                pacienteEntity.getCategoria(),
                pacienteEntity.getSolicitacao(),
                pacienteEntity.getDataCadastro(),
                pacienteEntity.getDataHabilitacao(),
                pacienteEntity.getNome(),
                pacienteEntity.getDataNascimento(),
                pacienteEntity.getSexo(),
                pacienteEntity.getIdentidade(),
                pacienteEntity.getOrgao(),
                pacienteEntity.getUfIdentidade(),
                pacienteEntity.getNaturalidade(),
                pacienteEntity.getUfNaturalidade(),
                pacienteEntity.getNacionalidade(),
                pacienteEntity.getNomeMae(),
                pacienteEntity.getNomePai(),
                pacienteEntity.getLogradouro(),
                pacienteEntity.getNumero(),
                pacienteEntity.getBairro(),
                pacienteEntity.getCidade(),
                pacienteEntity.getUfCidade(),
                pacienteEntity.getCep(),
                pacienteEntity.getComplemento(),
                pacienteEntity.getCpf(),
                pacienteEntity.getTelefone(),
                pacienteEntity.getStatus()
        );
    }

}
