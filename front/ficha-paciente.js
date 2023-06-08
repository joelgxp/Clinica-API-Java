const iacuidadeEsquerdo = document.querySelector("#acuidadeEsquerdo");
const iacuidadeDireito = document.querySelector("#acuidadeDireito");
const iacuidadeCorrecao = document.querySelector("#inputAcuidadeCorrecao");
const icampoVisualDireito = document.querySelector("#inputCampoVisualDireito");
const icampoVisualEsquerdo = document.querySelector("#inputCampoVisualEsquerdo");
const iinputComplemento = document.querySelector("#inputComplemento");
const iinputDataVencimento = document.querySelector("#inputDataVencimento");
const iinputConclusao = document.querySelector("#inputConclusao");
const iinputCPFBuscar = document.querySelector("#inputCPFBusca");

const btnSalvar = document.querySelector("#btnSalvar");
const bntConsultar = document.querySelector("#btnconsultar");


var urlParams = new URLSearchParams(window.location.search);
var encodedId = urlParams.get("id");
var encodedNome = urlParams.get("nome");
var encodedHora = urlParams.get("hora");
var encodedExame = urlParams.get("exame");

var idPaciente = decodeURIComponent(encodedId);
var nome = decodeURIComponent(encodedNome);
var hora = decodeURIComponent(encodedHora);
var exame = decodeURIComponent(encodedExame);

var inome = document.getElementById("nome");
inome.value = nome;

function cadastraDadosExame() {
    const id = idPaciente;
    console.log(formMedico),
    fetch("http://localhost:8080/ficha_medica",
      {
        headers: {
          "Accept": "application/json",
          "Content-Type": "application/json",
        },
        method: "POST",
        body: JSON.stringify({
            idPaciente: id,
            ladoEsquerdo: iacuidadeEsquerdo.value,
            ladoDireito: iacuidadeDireito.value,
            correcao: iacuidadeCorrecao.value,
            campoVisualEsquerdo: icampoVisualEsquerdo.value,
            campoVisualDireito: icampoVisualDireito.value,
            exameValidade: iinputDataVencimento.value,
            conclusao: iinputConclusao.value,
            complemento: iinputComplemento.value,
            status: "true"
        })
      })
      .then(function (response) {
        if (response.ok) {
          //limpaFormulario()
        } else {
          throw new Error("Erro ao cadastrar paciente")
        }
      })
      .catch(function (error) {
        alert("Ocorreu um erro ao cadastrar o paciente")
      });
  }

  function buscaDadosExame() {
    fetch(`http://localhost:8080/ficha_medica/${iinputCPFBuscar.value}`, {
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
        iorgaouf.value = paciente.rgOrgaoUF;
        inaturalidade.value = paciente.naturalidade;
        inaturalidadeuf.value = paciente.naturalidadeUF;
        inacionalidade.value = paciente.nacionalidade;
        inomeMae.value = paciente.nomeMae;
        inomePai.value = paciente.nomePai;
        ilogradouro.value = paciente.logradouro;
        inumero.value = paciente.numero;
        ibairro.value = paciente.bairro;
        icidade.value = paciente.cidade;
        ilogradourouf.value = paciente.logradouroUF;
        icep.value = paciente.cep;
        icomplemento.value = paciente.complemento;
        icpf.value = paciente.cpf;
        itelefone.value = paciente.telefone;
  
        // iregistro.disabled = true;
        // icpf.disabled = true;
        // btnficha.disabled = false;
        // btnEncaminhar.disabled = false;
        // bntCadastrar.disabled = true;
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
  }
  

  btnSalvar.addEventListener("click", function (event) {
    event.preventDefault();
    cadastraDadosExame();
  });

  bntConsultar.addEventListener("click", function (event) {
    event.preventDefault();
    buscaDadosExame();
  })

