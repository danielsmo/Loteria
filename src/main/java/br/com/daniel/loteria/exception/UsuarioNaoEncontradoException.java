package br.com.daniel.loteria.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(Long id) {
        super(String.format("O usuário com id %d não foi localizado", id));
    }
}
