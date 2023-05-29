var urlParams = new URLSearchParams(window.location.search);
var encodedId = urlParams.get("id");
var encodedNome = urlParams.get("nome");
var encodedHora = urlParams.get("hora");
var encodedExame = urlParams.get("exame");

var id = decodeURIComponent(encodedId);
var nome = decodeURIComponent(encodedNome);
var hora = decodeURIComponent(encodedHora);
var exame = decodeURIComponent(encodedExame);

// Faça o que desejar com os dados decodificados
console.log("ID da linha:", id);
console.log("Nome:", nome);
console.log("Hora:", hora);
console.log("Exame:", exame);

var inome = document.getElementById("nome");
inome.value = nome;
var idata = document.getElementById("data");
idata.value = hora;

