package br.com.daniel.loteria.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

public class UsuarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
