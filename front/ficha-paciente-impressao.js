const iguia = document.querySelector("#inputGuia");
const iregistro = document.querySelector("#inputRegistro");
const isolicitacao = document.querySelector("#inputSolicitacao");
const icategoria = document.querySelector("#inputCategoria");
const idataCadastro = document.querySelector("#inputDataCadastro");
const idataHabilitacao = document.querySelector("#inputDataHabilitacao");
const inome = document.querySelector("#inputNomeCandidato");
const idataNascimento = document.querySelector("#inputNascimento");
const isexo = document.querySelector("#inputSexo");
const iidentidade = document.querySelector("#inputIdentidade");
const iorgao = document.querySelector("#inputOrgao");
const iorgaouf = document.querySelector("#inputRgOrgaoUF");
const inaturalidade = document.querySelector("#inputNaturalidade");
const inaturalidadeuf = document.querySelector("#inputNaturalidadeUF");
const inacionalidade = document.querySelector("#inputNacionalidade");
const inomeMae = document.querySelector("#inputNomeMae");
const inomePai = document.querySelector("#inputNomePai");

const ilogradouro = document.querySelector("#inputLogradouro");
const inumero = document.querySelector("#inputNumero");
const ibairro = document.querySelector("#inputBairro");
const icidade = document.querySelector("#inputCidade");
const ilogradourouf = document.querySelector("#inputLogradouroUF");
const icep = document.querySelector("#inputCEP");
const icomplemento = document.querySelector("#inputComplemento");
const icpf = document.querySelector("#inputCPF");
const itelefone = document.querySelector("#inputTelefone");

const btnSalvar = document.querySelector("#btnSalvar");

var urlParams = new URLSearchParams(window.location.search);
var encodedCPF = urlParams.get("cpf");
var idCPF = decodeURIComponent(encodedCPF);
console.log(idCPF);

fetch(`http://localhost:8080/pacientes/${idCPF.value}`, {
  method: "GET",
})
  .then((response) => {
    if (response.ok) {
      return response.json();
    } else {
      throw new Error("Recurso não encontrado");
    }
  })
  .then((paciente) => {
    iguia.value = paciente.guia;
    iregistro.value = paciente.registro;
    isolicitacao.value = paciente.solicitacao;
    icategoria.value = paciente.categoria;
    idataCadastro.value = paciente.dataCadastro;
    idataHabilitacao.value = paciente.dataHabilitacao;
    inome.value = paciente.nome;
    idataNascimento.value = paciente.dataNascimento;
    isexo.value = paciente.sexo;
    iidentidade.value = paciente.identidade;
    iorgao.value = paciente.orgao;
    iorgaouf.value = paciente.ufIdentidade;
    inaturalidade.value = paciente.naturalidade;
    inaturalidadeuf.value = paciente.ufNaturalidade;
    inacionalidade.value = paciente.nacionalidade;
    inomeMae.value = paciente.nomeMae;
    inomePai.value = paciente.nomePai;
    ilogradouro.value = paciente.logradouro;
    inumero.value = paciente.numero;
    ibairro.value = paciente.bairro;
    icidade.value = paciente.cidade;
    ilogradourouf.value = paciente.ufCidade;
    icep.value = paciente.cep;
    icomplemento.value = paciente.complemento;
    icpf.value = paciente.cpf;
    itelefone.value = paciente.telefone;
  })
  .catch(function (error) {
    if (error.message === "Recurso não encontrado") {
      // Informe ao usuário que o recurso solicitado não foi encontrado
      alert("O paciente não foi encontrado");
    } else {
      // Tratamento genérico de erros
      alert("Ocorreu um erro ao obter os dados do paciente");
    }
  });

bntConsultar.addEventListener("click", function (event) {
  event.preventDefault();
  buscaPaciente();
});
