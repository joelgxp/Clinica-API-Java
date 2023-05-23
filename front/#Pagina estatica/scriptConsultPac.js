const btnEditar = document.querySelector("#btneditar");
const bntExcluir = document.querySelector("#btnexcluir");
const bntCadastrar = document.querySelector("#btncadastrar");
const bntConsultar = document.querySelector("#btnconsultar");
const btnLimpar = document.querySelector("#btnlimpar");

const formulario = document.querySelector("form");

const icpfconsulta = document.querySelector("#cpf");

const iguia = document.querySelector(".guia");
const iregistro = document.querySelector(".registro");
const icategoria = document.querySelector(".categoria");
const idataCadastro = document.querySelector(".dataCadastro");
const inome = document.querySelector(".nome");
const idataNascimento = document.querySelector(".dataNascimento");
const isexo = document.querySelector(".sexo");
const icpf = document.querySelector("#cpfpaciente");
const inomeMae = document.querySelector(".nomeMae");
const inomePai = document.querySelector(".nomePai");
const itelefone = document.querySelector(".telefone");

let pacienteResultado = null

function buscaPaciente() {
  fetch(`http://localhost:8080/pacientes/${icpfconsulta.value}`, {
    method: "GET",
  })
    .then(response => {
      return response.json();
    })
    .then(paciente => {
      window.alert("Busca efetuada!")
      pacienteResultado = paciente

      iguia.value = paciente.guia;
      iregistro.value = paciente.registro;
      icategoria.value = paciente.categoria;
      idataCadastro.value = paciente.dataCadastro;
      inome.value = paciente.nome;
      idataNascimento.value = paciente.dataNascimento;
      isexo.value = paciente.sexo;
      icpf.value = paciente.cpf;
      inomeMae.value = paciente.nomeMae;
      inomePai.value = paciente.nomePai;
      itelefone.value = paciente.telefone;
      iregistro.disabled = true;
      icpf.disabled = true;
    })
    .catch(function (error) {
      window.alert("Busca não encontrou CPF informado!")
      console.error("Ocorreu um erro:", error);
    });
}

function excluiPaciente() {
  fetch(`http://localhost:8080/pacientes/${pacienteResultado.id}`, {
    method: "DELETE",
  })
    .then(response => {
      console.log(response)
    })
    .catch(function (error) {
      console.error("Ocorreu um erro:", error);
    });
  limpaFormulario()
}

function editaPaciente() {
  console.log(pacienteResultado)
  const ide = pacienteResultado.id
  pacienteResultado = capturarValoresFormulario()
  console.log(pacienteResultado)
  pacienteResultado.id = ide
  console.log(pacienteResultado)

  fetch(`http://localhost:8080/pacientes`, {
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json",
    },
    method: "PUT",
    body: JSON.stringify(pacienteResultado),
  })
    .then(function (res) {
      if (res.ok) {
        limpaFormulario()
      }
    })
    .catch(function (res) {
      console.log(res);
    });
}

function cadastraPaciente() {
  const valoresFormulario = capturarValoresFormulario()

  fetch("http://localhost:8080/pacientes",
    {
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify(valoresFormulario),
    })
    .then(function (res) {
      console.log(res);
    })
    .catch(function (res) {
      console.log(res);
    });
  limpaFormulario()
}

function capturarValoresFormulario() {
  const inputs = formulario.elements;

  const valores = {};
  for (let i = 0; i < inputs.length; i++) {
    const input = inputs[i];
    if (input.name) {
      valores[input.name] = input.value;
    }
  }

  return valores;
}

function limpaFormulario() {
  var elementos = formulario.elements;
  iregistro.disabled = false
  icpf.disabled = false

  for (var i = 0; i < elementos.length; i++) {
    var elemento = elementos[i];

    if (elemento.type !== 'button') {
      elemento.value = '';
    }
  }
}

bntConsultar.addEventListener("click", function (event) {
  event.preventDefault();
  buscaPaciente();
});

bntCadastrar.addEventListener("click", function (event) {
  event.preventDefault();
  cadastraPaciente();
});

btnEditar.addEventListener("click", function (event) {
  event.preventDefault();
  editaPaciente();
});

bntExcluir.addEventListener("click", function (event) {
  event.preventDefault();
  excluiPaciente();
});

btnLimpar.addEventListener("click", function (event) {
  event.preventDefault();
  limpaFormulario();
});
