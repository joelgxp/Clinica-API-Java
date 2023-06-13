document.addEventListener("DOMContentLoaded", function () {
  // Obtém a referência para a tabela de espera
  var tabelaEspera = document.querySelector("#tabela-espera tbody");
  var tabelaAtendidos = document.querySelector("#tabela-atendidos tbody");

  // Faz uma solicitação ao backend para obter os dados da tabela
  // Você precisará substituir a URL pelo endpoint correto do seu backend
  fetch(`http://localhost:8080/pacientes`)
    .then(function (response) {
      return response.json();
    })
    .then(function (data) {
      tabelaEspera.innerHTML = "";
      data.forEach(function (item) {
        console.log(item);
        if (item.atendido == false) {
          var row = document.createElement("tr");
          row.setAttribute("data-id", item.id);

          var nomeCell = document.createElement("td");
          nomeCell.textContent = item.nome;
          row.appendChild(nomeCell);

          var cpfCell = document.createElement("td");
          cpfCell.textContent = item.cpf;
          row.appendChild(cpfCell);

          var horaCell = document.createElement("td");
          horaCell.textContent = item.hora;
          row.appendChild(horaCell);

          var exameCell = document.createElement("td");
          exameCell.textContent = item.solicitacao;
          row.appendChild(exameCell);

          var buttonCell = document.createElement("td");
          var button = document.createElement("button");
          button.textContent = "Chamar";
          button.setAttribute("class", "btn btn-primary");
          buttonCell.appendChild(button);
          row.appendChild(buttonCell);
          button.addEventListener("click", function (event) {
            event.preventDefault();
            capturarLinha();
          });

          tabelaEspera.appendChild(row);
        } else 
        if (item.atendido == true) {
          var row = document.createElement("tr");
          row.setAttribute("data-id", item.id);

          var nomeCell = document.createElement("td");
          nomeCell.textContent = item.nome;
          row.appendChild(nomeCell);

          var horaCell = document.createElement("td");
          horaCell.textContent = item.hora;
          row.appendChild(horaCell);

          var exameCell = document.createElement("td");
          exameCell.textContent = item.conclusao;
          row.appendChild(exameCell);

          tabelaAtendidos.appendChild(row);
        }
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
        var cpf = this.cells[1].innerText;
        var hora = this.cells[2].innerText;
        var exame = this.cells[3].innerText;

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
        var encodedCPF = encodeURIComponent(cpf);
        //window.location.href = url + "?id=" + rowId + "&nome=" + nome + "&hora=" + hora + "&exame=" + exame;
        window.location.href = url + "?id=" + encodedId + "&nome=" + encodedNome + "&hora=" + encodedHora + "&exame=" + encodedExame + "&cpf=" + encodedCPF;

      });
    }
  }
});
