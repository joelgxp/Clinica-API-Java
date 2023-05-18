const formulario = document.querySelector("form");
const iguia = document.querySelector(".guia");
const iregistro = document.querySelector(".registro");
const icategoria = document.querySelector(".categoria");
const idataCadastro = document.querySelector(".dataCadastro");
const idataHabilitacao = document.querySelector(".dataHabilitacao");
const inome = document.querySelector(".nome");
const idataNascimento = document.querySelector(".dataNascimento");
const isexo = document.querySelector(".sexo");
const icpf = document.querySelector(".cpf");
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

function cadastrar() {
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

function limpar() {
  iguia.value = "",
  iregistro.value = "",
  icategoria.value = "",
  idataCadastro.value = "",
  idataHabilitacao.value = "",
  inome.value = "",
  idataNascimento.value = "",
  isexo.value = "",
  icpf.value = "",
  inacionalidade.value = "",
  inomeMae.value = "",
  inomePai.value = "",
  itelefone.value = "",
  ilogradouro.value = "",
  ibairro.value = "",
  icep.value = "",
  inumero.value = "",
  icomplemento.value = "",
  icidade.value = "",
  iuf.value = "";  
};

formulario.addEventListener("submit", function (event) {
  event.preventDefault();
  cadastrar();
  //limpar();
});