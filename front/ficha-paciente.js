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
const formulario = document.querySelector("#formMedico");

var urlParams = new URLSearchParams(window.location.search);
var encodedId = urlParams.get("id");
var encodedNome = urlParams.get("nome");
var encodedHora = urlParams.get("hora");
var encodedExame = urlParams.get("exame");
var encodedCPF = urlParams.get("cpf");

var idPaciente = decodeURIComponent(encodedId);
var nome = decodeURIComponent(encodedNome);
var hora = decodeURIComponent(encodedHora);
var exame = decodeURIComponent(encodedExame);
var cpf = decodeURIComponent(encodedCPF);

var inome = document.getElementById("nome");
inome.value = nome;

function cadastraDadosExame() {
    const id = idPaciente;
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
            complemento: iinputComplemento.value
        })
      })
      .then(function (response) {
        if (response.ok) {
          alteraStatusPacienteExame(cpf);
        } else {
          throw new Error("Erro ao cadastrar paciente")
        }
      })
      .catch(function (error) {
        alert("Ocorreu um erro ao cadastrar o paciente")
      });
  }

  function alteraStatusPacienteExame(cpf) {   
    fetch(`http://localhost:8080/pacientes/atendido/` + cpf, {    
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      method: "PUT",
      body: JSON.stringify({
        atendido: "true",
      })
    })
    .then(function (res) {
      if (res.ok) {
        alert("Ficha atualizada com sucesso");
        limpaFormulario();
      }
    })
    .catch(function (res) {
      console.log(res);
    });
  }

  function buscaDadosExame() {
    fetch(`http://localhost:8080/ficha_medica/${cpf.value}`, {
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
        iacuidadeEsquerdo.value = paciente.ladoEsquerdo,
        iacuidadeDireito.value = paciente.ladoDireito,
        iacuidadeCorrecao.value = paciente.correcao,
        icampoVisualEsquerdo.value = paciente.campoVisualEsquerdo,
        icampoVisualDireito.value = paciente.campoVisualDireito,
        iinputDataVencimento.value = paciente.exameValidade,
        iinputConclusao.value = paciente.conclusao,
        iinputComplemento.value = paciente.complemento
  
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

  function limpaFormulario() {
    btnSalvar.disabled = true;
    var elementos = formulario.elements;  
    for (var i = 0; i < elementos.length; i++) {
      var elemento = elementos[i];
  
      if (elemento.type !== "button") {
        elemento.value = "";
      }
    }
  }

  inputCPFBusca.addEventListener('input', function () {
    let cpf = this.value.replace(/\D/g, '');
    cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
    this.value = cpf;
  });
  

  btnSalvar.addEventListener("click", function (event) {
    event.preventDefault();
    cadastraDadosExame();
  });

  bntConsultar.addEventListener("click", function (event) {
    event.preventDefault();
    buscaDadosExame();
  })

