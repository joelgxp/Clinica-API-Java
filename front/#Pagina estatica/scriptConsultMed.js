const formulario = document.querySelector("form");
const iid = document.querySelector(".id");
const inome = document.querySelector(".nome");
const iemail = document.querySelector(".email");
const icrm = document.querySelector(".crm");
const itelefone = document.querySelector(".telefone");


function listarPorId() {
  fetch(`http://localhost:8080/medicos/${iid.value}`, {    
    method: "GET",
  })
  
  .then(resposta => {
    return resposta.json()
    
  })
   .then ((data) => {
          inome.value = data.nome;
          iemail.value = data.email;
          icrm.value = data.crm;
          itelefone.value = data.telefone;

    })
    .catch(function (error) {
      console.error('Ocorreu um erro:', error);
    });
}

formulario.addEventListener("submit", function (event) {
  const iid = document.querySelector(".id");
  event.preventDefault();
  listarPorId();
});

