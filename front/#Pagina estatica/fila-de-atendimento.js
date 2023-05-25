document.addEventListener("DOMContentLoaded", function() {
    // Obtém a referência para a tabela de espera
    var tabelaEspera = document.querySelector("#tabela-espera tbody");
  
    // Faz uma solicitação ao backend para obter os dados da tabela
    // Você precisará substituir a URL pelo endpoint correto do seu backend
    fetch(`http://localhost:8080/pacientes`)
      .then(function(response) {
        return response.json(); // Supõe-se que o backend retorna os dados em formato JSON
      })
      .then(function(data) {
        // Limpa o conteúdo atual da tabela de espera
        tabelaEspera.innerHTML = "";
  
        // Preenche a tabela com os novos dados obtidos do backend
        data.forEach(function(item) {
          var row = document.createElement("tr");
          
          // Cria as células e preenche com os dados correspondentes
          var nomeCell = document.createElement("td");
          nomeCell.textContent = item.nome;
          row.appendChild(nomeCell);
  
          var horaCell = document.createElement("td");
          horaCell.textContent = item.dataCadastro;
          row.appendChild(horaCell);
  
          var exameCell = document.createElement("td");
          exameCell.textContent = item.registro;
          row.appendChild(exameCell);
  
          // Adiciona a nova linha à tabela de espera
          tabelaEspera.appendChild(row);
        });
      })
      .catch(function(error) {
        console.log("Erro ao obter os dados da tabela:", error);
      });
  });
  