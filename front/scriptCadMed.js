const formulario = document.querySelector("form");
const inome = document.querySelector(".nome");
const iemail = document.querySelector(".email");
const icrm = document.querySelector(".crm");
const itelefone = document.querySelector(".telefone");
const iespecialidade = document.querySelector(".especialidade");

function cadastrar() {
  fetch("http://localhost:8080/medicos", 
  {
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify({
      nome: inome.value,
      email: iemail.value,
      crm: icrm.value,
      telefone: itelefone.value,
      especialidade: iespecialidade.value
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
  inome.value = "";
  iemail.value = "";
  icrm.value = "";
  itelefone.value = "";
  iespecialidade.value = "";
}

formulario.addEventListener("submit", function (event) {
  event.preventDefault();
  cadastrar();
  limpar();
});

