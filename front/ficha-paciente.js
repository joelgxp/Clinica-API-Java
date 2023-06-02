const iacuidadeEsquerdo = document.querySelector("#acuidadeEsquerdo");
const iacuidadeDireito = document.querySelector("#acuidadeDireito");
const iacuidadeCorrecao = document.querySelector("#inputAcuidadeCorrecao");
const iinputDataVencimento = document.querySelector("#inputDataVencimento");
const btnSalvar = document.querySelector("#btnSalvar");


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
    console.log(id);
    //const valoresFormulario = capturarValoresFormulario()
    // console.log(valoresFormulario),
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
            exameValidade: iinputDataVencimento.value
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

  btnSalvar.addEventListener("click", function (event) {
    event.preventDefault();
    cadastraDadosExame();
  });

