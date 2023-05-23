const btnEditar = document.querySelector("#btneditar");
const bntExcluir = document.querySelector("#btnexcluir");
const bntCadastrar = document.querySelector("#btncadastrar");
const bntConsultar = document.querySelector("#btnconsultar");
const btnLimpar = document.querySelector("#btnlimpar");
const formulario = document.querySelector("form");

const iid = document.querySelector(".id");

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

let pacienteID = null

function buscaPaciente() {
  fetch(`http://localhost:8080/pacientes/${icpfconsulta.value}`, {
    method: "GET",
  })
    .then(response => {
      return response.json();
    })
    .then(paciente => {
      pacienteID = paciente.id

      iguia.value = paciente.guia;
      iregistro.value = paciente.registro;
      icategoria.value = paciente.categoria;
      idataCadastro.value = paciente.data_cadastro;
      inome.value = paciente.nome;
      idataNascimento.value = paciente.data_nascimento;
      isexo.value = paciente.sexo;
      icpf.value = paciente.cpf;
      inomeMae.value = paciente.nome_mae;
      inomePai.value = paciente.nome_pai;
      itelefone.value = paciente.telefone;
      iregistro.disabled = true;
      icpf.disabled = true;
    })
    .catch(function (error) {
      console.error("Ocorreu um erro:", error);
    });
}

function excluiPaciente() {
  fetch(`http://localhost:8080/pacientes/${pacienteID}`, {
    method: "DELETE",
  })
    .then(response => {

      limpaFormulario()
    })
    .catch(function (error) {
      console.error("Ocorreu um erro:", error);
    });
}

function editaPaciente() {
  fetch(`http://localhost:8080/pacientes/${icpf.value}`,
    {
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json",
      },
      method: "PUT",
      body: JSON.stringify({
        guia: iguia.value,
        categoria: icategoria.value,
        data_cadastro: idataCadastro.value,
        nome: inome.value,
        data_nascimento: idataNascimento.value,
        sexo: isexo.value,
        nome_mae: inomeMae.value,
        nome_pai: inomePai.value,
        telefone: itelefone.value,
      }),
    })
    .then(function (res) {
      console.log(res);
    })
    .catch(function (res) {
      console.log(res);
    });
  limpaFormulario()
}

function cadastraPaciente() {
  fetch("http://localhost:8080/pacientes",
    {
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify({
        guia: iguia.value,
        registro: iregistro.value,
        categoria: icategoria.value,
        data_cadastro: idataCadastro.value,
        nome: inome.value,
        data_nascimento: idataNascimento.value,
        sexo: isexo.value,
        cpf: icpf.value,
        nome_mae: inomeMae.value,
        nome_pai: inomePai.value,
        telefone: itelefone.value
      }),
    })
    .then(function (res) {
      console.log(res);
    })
    .catch(function (res) {
      console.log(res);
    });
  limpaFormulario()
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
  const icpfconsulta = document.querySelector("#cpf");
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