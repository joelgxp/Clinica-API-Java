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

const tabelaResultados = document.getElementById('tabelaResultados');
const tbody = tabelaResultados.querySelector('tbody');


var dataHoraAtual = new Date();
dataHoraAtual.setTime;



let pacienteResultado = null;
btnficha.disabled = true;
btnEncaminhar.disabled = true;

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
  const identificador = pacienteResultado.id;
  const dadosAtualizados = capturarValoresFormulario();
  dadosAtualizados.id = identificador;

  fetch(`http://localhost:8080/pacientes/${identificador}`, {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "PUT",
    body: JSON.stringify(dadosAtualizados),
  })
    .then(function (res) {
      if (res.ok) {
        limpaFormulario();
      }
    })
    .catch(function (res) {
      console.log(res);
    });
}

function cadastraPaciente() {
  //const valoresFormulario = capturarValoresFormulario()
  // console.log(valoresFormulario),
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
        //limpaFormulario()
        console.log("Response OK")
      } else {
        throw new Error("Erro ao cadastrar paciente");
      }
    })
    .catch(function (error) {
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
  btnEditar.disabled = true;
  bntExcluir.disabled = true;
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

  //window.location.href = url + "?id=" + rowId + "&nome=" + nome + "&hora=" + hora + "&exame=" + exame;
  window.location.href = url + "?cpf=" + encodedCPF;
}

inputNomeCandidatoBusca.addEventListener('input', () => {
  const nome = inputNomeCandidatoBusca.value;
  buscarNomeNoBancoDeDados(nome);
});

function buscarNomeNoBancoDeDados(nome) {
  // Limpar a tabela
  tbody.innerHTML = '';

  // Fazer a busca no banco de dados usando fetch
  //fetch(`http://localhost:8080/api/busca-nomes?nome=${nome}`)
  fetch(`http://localhost:8080/nome/${nome}`)
    
    .then(response => response.json())
    .then(resultados => {
      
      // Adicionar os resultados à tabela
      resultados.forEach(resultado => {
        const tr = document.createElement('tr');
        const tdNome = document.createElement('td');
        const tdIdade = document.createElement('td');
        const tdEmail = document.createElement('td');

        tdNome.textContent = resultado.nome;
        tdIdade.textContent = resultado.idade;
        tdEmail.textContent = resultado.email;

        tr.appendChild(tdNome);
        tr.appendChild(tdIdade);
        tr.appendChild(tdEmail);

        tbody.appendChild(tr);
      });
    })
    .catch(error => {
      console.error('Ocorreu um erro na busca:', error);
    });
}


icpf.addEventListener('input', function() {
  let cpf = this.value.replace(/\D/g, '');
  cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
  this.value = cpf;  
});

icpfconsulta.addEventListener('input', function() {
  let cpf = this.value.replace(/\D/g, '');
  cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
  this.value = cpf;  
});

itelefone.addEventListener('input', function() {
  let telefone = this.value.replace(/\D/g, '');
  telefone = telefone.replace(/(\d{2})(\d{5})(\d{4})/, '($1) $2-$3');
  this.value = telefone;
});

btnBuscarPorNome.addEventListener('click', () => {
  const nome = inputNomeCandidatoBusca.value;
  buscarNomeNoBancoDeDados(nome);
});

bntConsultar.addEventListener("click", function (event) {
  event.preventDefault();
  buscaPaciente();
});

bntCadastrar.addEventListener("click", function (event) {
  event.preventDefault();
  cadastraPaciente();
});

btnficha.addEventListener("click", function (event) {
  event.preventDefault();
  capturaCPFencaminhaFichaImpressao();
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

// iorgaouf.addEventListener("focus", () => {
//   buscaEstados()
//     .then((options) => {
//       iorgaouf.append(options);
//     })
//     .catch((error) => {
//       console.error("Erro ao buscar os estados:", error);
//     });
// });

// inaturalidadeuf.addEventListener("focus", () => {
//   buscaEstados()
//     .then((options) => {
//       inaturalidadeuf.append(options);
//     })
//     .catch((error) => {
//       console.error("Erro ao buscar os estados:", error);
//     });
// });

// ilogradourouf.addEventListener("focus", () => {
//   buscaEstados()
//     .then((options) => {
//       ilogradourouf.append(options);
//     })
//     .catch((error) => {
//       console.error("Erro ao buscar os estados:", error);
//     });
// });

// inaturalidadeuf.addEventListener("change", async () => {
//   let selectedOption = inaturalidadeuf.options[inaturalidadeuf.selectedIndex];
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