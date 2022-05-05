package br.com.daniel.loteria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class Handler {


    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<StatusResponse> handleUsuarioNaoEncontrado(UsuarioNaoEncontradoException e) {

        String campo = "Parâmetro incorreto";
        String mensagem = e.getLocalizedMessage();
        StatusResponse statusResponse = new StatusResponse(campo, mensagem);


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(statusResponse);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StatusResponse> handleMethodArgument(MethodArgumentNotValidException e) {

        String campo = "Parâmetro incorreto";
        String mensagem = String.format("O campo '%s' deve ser preenchido corretamente", e.getFieldError().getField());

        StatusResponse statusResponse = new StatusResponse(campo, mensagem);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(statusResponse);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StatusResponse> handleTypeMismatch(MethodArgumentTypeMismatchException e){

        String campo = "Parâmetro incorreto";
        String mensagem = String.format("O campo '%s' deve ser preenchido corretamente",e.getName());

        StatusResponse statusResponse = new StatusResponse(campo,mensagem);


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(statusResponse);
    }


}
