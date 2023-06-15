const btnEditar = document.querySelector("#btneditar");
const bntExcluir = document.querySelector("#btnexcluir");
const bntCadastrar = document.querySelector("#btncadastrar");
const bntConsultar = document.querySelector("#btnconsultar");
const btnLimpar = document.querySelector("#btnlimpar");
const btnficha = document.querySelector("#btnficha");
const btnEncaminhar = document.querySelector("#btnencaminhar");
const btnBuscarPorNome = document.getElementById('btnBuscarPorNome');

const formulario = document.querySelector("#formMedico");

const inputNomeCandidatoBusca = document.getElementById('inputNomeCandidatoBusca');
const icpfconsulta = document.querySelector("#inputCPFBusca");

const iguia = document.querySelector("#inputGuia");
const iregistro = document.querySelector("#inputRegistro");
const isolicitacao = document.querySelector("#inputSolicitacao");
const icategoria = document.querySelector("#inputCategoria");
const idataCadastro = document.querySelector("#inputDataCadastro");
const idataHabilitacao = document.querySelector("#inputDataHabilitacao");
const inome = document.querySelector("#inputNomeCandidato");
const idataNascimento = document.querySelector("#inputNascimento");
const isexo = document.querySelector("#inputSexo");
const iidentidade = document.querySelector("#inputRgIdentidade");
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

var dataHoraAtual = new Date();
var horaAtual = dataHoraAtual.toLocaleTimeString();

let pacienteResultado = null;
btnficha.disabled = true;
btnEncaminhar.disabled = true;
btnEditar.disabled = true;
bntExcluir.disabled = true;

async function buscaPaciente() {
  await fetch(`http://localhost:8080/pacientes/${icpfconsulta.value}`, {
    method: "GET",
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error("Recurso não encontrado");
      }
    })
    .then(async (paciente) => {
      pacienteResultado = paciente

      // btnEditar.disabled = false
      // bntExcluir.disabled = false
      iorgaouf.value = paciente.ufIdentidade;
      inaturalidadeuf.value = paciente.ufNaturalidade;
      ilogradourouf.value = paciente.endereco.ufCidade;

      await filtrarMunicipios(ilogradourouf.options[ilogradourouf.selectedIndex].id, icidade);
      await filtrarMunicipios(inaturalidadeuf.options[inaturalidadeuf.selectedIndex].id, inaturalidade);

      for (var i = 0; i < icidade.options.length; i++) {
        if (icidade.options[i].value === paciente.endereco.cidade) {
            icidade.selectedIndex = i;
            break;
        }
      }

      for (var i = 0; i < inaturalidade.options.length; i++) {
        if (inaturalidade.options[i].value === paciente.naturalidade) {
          inaturalidade.selectedIndex = i;
            break;
        }
      }

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

      inacionalidade.value = paciente.nacionalidade;
      inomeMae.value = paciente.nomeMae;
      inomePai.value = paciente.nomePai;

      ilogradouro.value = paciente.endereco.logradouro;
      inumero.value = paciente.endereco.numero;
      ibairro.value = paciente.endereco.bairro;

      icep.value = paciente.endereco.cep;
      icomplemento.value = paciente.endereco.complemento;

      icpf.value = paciente.cpf;
      itelefone.value = paciente.telefone;

      iregistro.disabled = true;
      icpf.disabled = true;
      btnficha.disabled = false;
      btnEncaminhar.disabled = false;
      bntCadastrar.disabled = true;
      btnEditar.disabled = false;
      bntExcluir.disabled = false;
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

function buscarPacientesPorNome(nome) {
  fetch('http://localhost:8080/pacientes/nome/' + nome)
    .then(response => response.json())
    .then(data => {
      // Limpar a tabela
      document.getElementById('resultadoTbody').innerHTML = '';

      // Iterar sobre os resultados e adicionar linhas à tabela
      data.forEach(paciente => {
        var row = document.createElement('tr');

        var nomeCell = document.createElement('td');
        nomeCell.textContent = paciente.nome;
        row.appendChild(nomeCell);

        var idadeCell = document.createElement('td');
        idadeCell.textContent = paciente.cpf;
        row.appendChild(idadeCell);

        // Adicione outras células da tabela conforme necessário

        document.getElementById('resultadoTbody').appendChild(row);
      });
    })
    .catch(error => console.error(error));
}

function excluiPaciente() {
  fetch(`http://localhost:8080/pacientes/${pacienteResultado.id}`, {
    method: "DELETE",
  })
    .then((response) => {
      console.log(response);
    })
    .catch(function (error) {
      console.error("Ocorreu um erro:", error);
    });
  limpaFormulario();
}

function editaPaciente() {
  fetch(`http://localhost:8080/pacientes/${icpf.value}`, {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "PUT",
    body: JSON.stringify({
      guia: iguia.value,
      registro: iregistro.value,
      solicitacao: isolicitacao.value,
      categoria: icategoria.value,
      dataCadastro: idataCadastro.value,
      dataHabilitacao: idataHabilitacao.value,
      nome: inome.value,
      dataNascimento: idataNascimento.value,
      sexo: isexo.value,
      identidade: iidentidade.value,
      orgao: iorgao.value,
      ufIdentidade: iorgaouf.value,
      naturalidade: inaturalidade.value,
      ufNaturalidade: inaturalidadeuf.value,
      nacionalidade: inacionalidade.value,
      nomeMae: inomeMae.value,
      nomePai: inomePai.value,
      logradouro: ilogradouro.value,
      numero: inumero.value,
      bairro: ibairro.value,
      cidade: icidade.value,
      ufCidade: ilogradourouf.value,
      cep: icep.value,
      complemento: icomplemento.value,
      cpf: icpf.value,
      telefone: itelefone.value
  }),
  })
    .then(function (res) {
      if (res.ok) {
        alert("Paciente editado com sucesso!");
        limpaFormulario();
      }
    })
    .catch(function (res) {
      console.log(res);
    });
}

function cadastraPaciente() {
  fetch("http://localhost:8080/pacientes", {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify({
      guia: iguia.value,
      registro: iregistro.value,
      solicitacao: isolicitacao.value,
      categoria: icategoria.value,
      dataCadastro: idataCadastro.value,
      dataHabilitacao: idataHabilitacao.value,
      nome: inome.value,
      dataNascimento: idataNascimento.value,
      sexo: isexo.value,
      identidade: iidentidade.value,
      orgao: iorgao.value,
      ufIdentidade: iorgaouf.value,
      naturalidade: inaturalidade.value,
      ufNaturalidade: inaturalidadeuf.value,
      nacionalidade: inacionalidade.value,
      nomeMae: inomeMae.value,
      nomePai: inomePai.value,
      endereco: {
        logradouro: ilogradouro.value,
        numero: inumero.value,
        bairro: ibairro.value,
        cidade: icidade.value,
        ufCidade: ilogradourouf.value,
        cep: icep.value,
        complemento: icomplemento.value
      },
      cpf: icpf.value,
      telefone: itelefone.value,
    }),
  })
    .then(function (response) {
      if (response.ok) {
        alert("Paciente cadastrado com sucesso");
        bntCadastrar.disabled = true;
        btnficha.disabled = false;
        btnEncaminhar.disabled = false;
      } else {
        throw new Error("Erro ao cadastrar paciente");
      }
    })
    .catch(function (error) {
      console.log(error)
      alert("Ocorreu um erro ao cadastrar o paciente");
    });
}

function capturarValoresFormulario() {
  const inputs = formulario.elements;

  const valores = {};
  for (let i = 0; i < inputs.length; i++) {
    const input = inputs[i];
    if (input.id) {
      valores[input.id] = input.value;
    }
  }
  console.log(valores);
  return valores;
}

function limpaFormulario() {
  var elementos = formulario.elements;
  iregistro.disabled = false;
  icpf.disabled = false;
  bntCadastrar.disabled = false;
  btnEditar.disabled = true;
  bntExcluir.disabled = true;
  btnficha.disabled = true;
  btnEncaminhar.disabled = true;
  inaturalidade.innerHTML = "";
  icidade.innerHTML = "";
  for (var i = 0; i < elementos.length; i++) {
    var elemento = elementos[i];

    if (elemento.type !== "button") {
      elemento.value = "";
    }
  }
}

function capturaCPFencaminhaFichaImpressao() {
  var cpf = icpf.value;
  var url = "ficha-paciente-impressao.html";
  var encodedCPF = encodeURIComponent(cpf);
  window.location.href = url + "?cpf=" + encodedCPF;
}

function encaminhaPacienteExame() {
  fetch(`http://localhost:8080/pacientes/atendido/${icpf.value}`, {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "PUT",
    body: JSON.stringify({
      hora: horaAtual,
      atendido: "false"
    })
  })
  .then(function (res) {
    if (res.ok) {
      alert("Paciente encaminhado com sucesso");
      limpaFormulario();
      bntCadastrar.disabled = true;
      btnEncaminhar.disabled = true;
      btnLimpar.disabled = true;
    }
  })
  .catch(function (res) {
    console.log(res);
  });
}

inputNomeCandidatoBusca.addEventListener('input', () => {
  const nome = inputNomeCandidatoBusca.value;
  buscarPacientesPorNome(nome);
});


icpf.addEventListener('input', function () {
  let cpf = this.value.replace(/\D/g, '');
  cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
  this.value = cpf;
});

inputCPFBusca.addEventListener('input', function () {
  let cpf = this.value.replace(/\D/g, '');
  cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
  this.value = cpf;
});

itelefone.addEventListener('input', function () {
  let telefone = this.value.replace(/\D/g, '');
  telefone = telefone.replace(/(\d{2})(\d{5})(\d{4})/, '($1) $2-$3');
  this.value = telefone;
});

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

btnficha.addEventListener("click", function (event) {
  event.preventDefault();
  capturaCPFencaminhaFichaImpressao();
});

btnEncaminhar.addEventListener("click", function (event) {
  event.preventDefault();
  encaminhaPacienteExame();
})

//   const request = await fetch(
//     `http://localhost:8080/municipios/${selectedOptionId}`
//   );
//   const response = await request.json();

//   const options = document.createElement("optgroup");
//   options.setAttribute("label", "Cidades");

//   response.forEach((municipio) => {
//     const option = document.createElement("option");
//     option.textContent = municipio.nome;
//     options.appendChild(option);
//   });
//   inaturalidade.innerHTML = "";
//   inaturalidade.append(options);
// });

// ilogradourouf.addEventListener("change", async () => {
//   let selectedOption = ilogradourouf.options[ilogradourouf.selectedIndex];
//   let selectedOptionId = selectedOption.getAttribute("id");

//   const request = await fetch(
//     `http://localhost:8080/municipios/${selectedOptionId}`
//   );
//   const response = await request.json();

//   const options = document.createElement("optgroup");
//   options.setAttribute("label", "Cidades");

//   response.forEach((municipio) => {
//     const option = document.createElement("option");
//     option.textContent = municipio.nome;
//     options.appendChild(option);
//   });
//   icidade.innerHTML = "";
//   icidade.append(options);
// });

// ilogradourouf.addEventListener('change', () => filtrarMunicipios(ilogradourouf.options[ilogradourouf.selectedIndex].id, icidade));
// inaturalidadeuf.addEventListener('change', () => filtrarMunicipios(inaturalidadeuf.options[inaturalidadeuf.selectedIndex].id, inaturalidade));

async function filtrarMunicipios(estadoId, selectMunicipio) {

  if (estadoId && selectMunicipio) {
      const response = await fetch('http://localhost:8080/municipios/' + estadoId)
      const data = await response.json()

      selectMunicipio.innerHTML = ""; // Limpa as opções existentes

      data.forEach(municipio => {
          const optionElement = document.createElement('option');
          optionElement.value = municipio.nome;
          optionElement.textContent = municipio.nome;
          selectMunicipio.appendChild(optionElement);
      });
  }
}

async function buscaEstados() {
  try {
    const request = await fetch("http://localhost:8080/estados");
    const response = await request.json();

    const options = document.createElement("optgroup");
    options.setAttribute("label", "UFs");

    response.forEach((uf) => {
      const option = document.createElement("option");
      option.textContent = uf.sigla;
      option.id = uf.id;
      options.appendChild(option);
    });

    return options;
  } catch (error) {
    throw new Error("Erro ao buscar os estados");
  }
}

document.addEventListener("DOMContentLoaded", function () {
  fetch('http://localhost:8080/estados')
      .then(response => response.json())
      .then(data => {
          data.forEach(estado => {
              const optionElement1 = document.createElement('option');
              const optionElement2 = document.createElement('option');
              const optionElement3 = document.createElement('option');

              optionElement1.value = estado.sigla;
              optionElement1.id = estado.id
              optionElement1.textContent = estado.sigla;
              iorgaouf.appendChild(optionElement1);

              optionElement2.value = estado.sigla;
              optionElement2.id = estado.id
              optionElement2.textContent = estado.sigla;
              inaturalidadeuf.appendChild(optionElement2);

              optionElement3.value = estado.sigla;
              optionElement3.id = estado.id
              optionElement3.textContent = estado.sigla;
              ilogradourouf.appendChild(optionElement3);
          });

          ilogradourouf.addEventListener('change', () => filtrarMunicipios(ilogradourouf.options[ilogradourouf.selectedIndex].id, icidade));
          inaturalidadeuf.addEventListener('change', () => filtrarMunicipios(inaturalidadeuf.options[inaturalidadeuf.selectedIndex].id, inaturalidade));

      })
      .catch(error => {
          console.error('Ocorreu um erro ao buscar os estados:', error);
      });
});