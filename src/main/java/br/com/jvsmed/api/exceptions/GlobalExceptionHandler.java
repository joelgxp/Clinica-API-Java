package br.com.jvsmed.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ConnectException.class)
    public ResponseEntity<String> handleCommunicationsException(ConnectException ex) {
        // Log do erro
        ex.printStackTrace();

        // Retorna uma resposta de erro com a mensagem personalizada
        String mensagemErro = "O sistema está temporariamente indisponível. Tente novamente mais tarde.";
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(mensagemErro);
    }
}
