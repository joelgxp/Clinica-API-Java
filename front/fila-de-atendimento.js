document.addEventListener("DOMContentLoaded", function () {
  // Obtém a referência para a tabela de espera
  var tabelaEspera = document.querySelector("#tabela-espera tbody");

  // Faz uma solicitação ao backend para obter os dados da tabela
  // Você precisará substituir a URL pelo endpoint correto do seu backend
  fetch(`http://localhost:8080/pacientes`)
    .then(function (response) {
      return response.json(); // Supõe-se que o backend retorna os dados em formato JSON
    })
    .then(function (data) {
      // Limpa o conteúdo atual da tabela de espera
      tabelaEspera.innerHTML = "";

      // Preenche a tabela com os novos dados obtidos do backend
      data.forEach(function (item) {
        var row = document.createElement("tr");
        row.setAttribute("data-id", item.id);

        // Cria as células e preenche com os dados correspondentes
        var nomeCell = document.createElement("td");
        nomeCell.textContent = item.nome;
        row.appendChild(nomeCell);

        var horaCell = document.createElement("td");
        horaCell.textContent = item.dataCadastro;
        row.appendChild(horaCell);

        var exameCell = document.createElement("td");
        exameCell.textContent = item.solitacao;
        row.appendChild(exameCell);

        var buttonCell = document.createElement("td");
        var button = document.createElement("button");
        button.textContent = "Chamar"; // Texto do botão
        button.setAttribute("class", "btn btn-primary"); // Adicione classes CSS ao botão, se necessário
        buttonCell.appendChild(button);
        row.appendChild(buttonCell);
        button.addEventListener("click", function (event) {
          event.preventDefault();
          capturarLinha();
        });

        // Adiciona a nova linha à tabela de espera
        tabelaEspera.appendChild(row);
      });
    })
    .catch(function (error) {
      console.log("Erro ao obter os dados da tabela:", error);
    });

  function capturarLinha() {
    var rows = document.querySelectorAll("#tabela-espera tbody tr");

    for (var i = 0; i < rows.length; i++) {
      rows[i].addEventListener("click", function () {
        var rowId = this.getAttribute("data-id");
        var nome = this.cells[0].innerText;
        var hora = this.cells[1].innerText;
        var exame = this.cells[2].innerText;

        // Faça o que desejar com os dados capturados
        console.log("ID da linha:", rowId);
        console.log("Nome:", nome);
        console.log("Hora:", hora);
        console.log("Exame:", exame);
        
        var url = "ficha-paciente.html";
        var encodedId = encodeURIComponent(rowId);
        var encodedNome = encodeURIComponent(nome);
        var encodedHora = encodeURIComponent(hora);
        var encodedExame = encodeURIComponent(exame);
        //window.location.href = url + "?id=" + rowId + "&nome=" + nome + "&hora=" + hora + "&exame=" + exame;
        window.location.href = url + "?id=" + encodedId + "&nome=" + encodedNome + "&hora=" + encodedHora + "&exame=" + encodedExame;
        
      });
    }
  }
});
