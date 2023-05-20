const btnEditar = document.querySelector("#btneditar");
const bntExcluir = document.querySelector("#btnexcluir");
const btnCadastrar = document.querySelector("#btncadastrar");
const formulario = document.querySelector("form");
const iid = document.querySelector(".id");
const icpfconsulta = document.querySelector("#cpf");
const iguia = document.querySelector(".guia");
const iregistro = document.querySelector(".registro");
const icategoria = document.querySelector(".categoria");
const idataCadastro = document.querySelector(".dataCadastro");
const idataHabilitacao = document.querySelector(".dataHabilitacao");
const inome = document.querySelector(".nome");
const idataNascimento = document.querySelector(".dataNascimento");
const isexo = document.querySelector(".sexo");
const icpf = document.querySelector("#cpfpaciente");
const inacionalidade = document.querySelector(".nacionalidade");
const inomeMae = document.querySelector(".nomeMae");
const inomePai = document.querySelector(".nomePai");
const itelefone = document.querySelector(".telefone");
const ilogradouro = document.querySelector(".logradouro");
const ibairro = document.querySelector(".bairro");
const icep = document.querySelector(".cep");
const inumero = document.querySelector(".numero");
const icomplemento = document.querySelector(".complemento");
const icidade = document.querySelector(".cidade");
const iuf = document.querySelector(".uf");

function listarPorId() {
  fetch(`http://localhost:8080/pacientes/cpf/${icpfconsulta.value}`, {
    method: "GET",
  })
    .then((resposta) => {
      return resposta.json();
    })
    .then((data) => {
      iid.value = data.id;
      iguia.value = data.guia;
      iregistro.value = data.registro;
      icategoria.value = data.categoria;
      idataCadastro.value = data.data_cadastro;
      idataHabilitacao.value = data.data_habilitacao;
      inome.value = data.nome;
      idataNascimento.value = data.data_nascimento;
      isexo.value = data.sexo;
      icpf.value = data.cpf;
      inacionalidade.value = data.nacionalidade;
      inomeMae.value = data.nome_mae;
      inomePai.value = data.nome_pai;
      itelefone.value = data.telefone;
      ilogradouro.value = data.logradouro;
      ibairro.value = data.bairro;
      icep.value = data.cep;
      inumero.value = data.numero;
      icomplemento.value = data.complemento;
      icidade.value = data.cidade;
      iuf.value = data.uf;
    })
    .catch(function (error) {
      console.error("Ocorreu um erro:", error);
    });
}

function excluir() {
  fetch(`http://localhost:8080/pacientes/${iid.value}`, {
    method: "DELETE",
  })
    .then((resposta) => {
      //return resposta.json();
      //console.log(resposta);
    })
    .catch(function (error) {
      console.error("Ocorreu um erro:", error);
    });
}

function editar() {
  fetch(`http://localhost:8080/pacientes/${iid.value}`, 
  {
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json",
    },
    method: "PUT",
    body: JSON.stringify({
      id: iid.value,
      guia: iguia.value,
      registro: iregistro.value,
      categoria: icategoria.value,
      data_cadastro: idataCadastro.value,
      data_habilitacao: idataHabilitacao.value,
      nome: inome.value,
      data_nascimento: idataNascimento.value,
      sexo: isexo.value,
      cpf: icpf.value,
      nacionalidade: inacionalidade.value,
      nome_mae: inomeMae.value,
      nome_pai: inomePai.value,
      telefone: itelefone.value,
      logradouro: ilogradouro.value,
      bairro: ibairro.value,
      cep: icep.value,
      numero: inumero.value,
      complemento: icomplemento.value,
      cidade: icidade.value,
      uf: iuf.value,      
    }),
  })    
  .then(function (res) {
    console.log(res);
  })
  .catch(function (res) {
    console.log(res);
  });
}
  

btnCadastrar.addEventListener("click", function (event) {
  const icpfconsulta = document.querySelector("#cpf");
  event.preventDefault();
  listarPorId();
});

btnEditar.addEventListener("click", function (event) {
  //const icpfconsulta = document.querySelector("#cpf");
  event.preventDefault();
 editar();
});

bntExcluir.addEventListener("click", function (event) {
  event.preventDefault();
  excluir();
});
