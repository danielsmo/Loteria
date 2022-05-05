package br.com.daniel.loteria.model;

import br.com.daniel.loteria.dto.UsuarioRequest;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;

    @NotNull
    @PastOrPresent
    @Column(updatable = false, nullable = false)
    private LocalDateTime registradoEm = LocalDateTime.now();

    public Usuario() {
    }

    public Usuario(UsuarioRequest request) {
        this.nome = request.getNome();
        this.cpf = request.getCpf();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDateTime getRegistradoEm() {
        return registradoEm;
    }
}
