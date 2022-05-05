package br.com.daniel.loteria.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
@Table(name = "sorteios")
public class Sorteio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 4)
    private String numeroSorteado;

    @NotNull
    @PastOrPresent
    @Column(updatable = false, nullable = false)
    private LocalDateTime registradoEm = LocalDateTime.now();

    @NotNull
    @ManyToOne
    private Usuario usuario;

    public Sorteio() {
    }

    public Sorteio(String numeroSorteado, Usuario usuario) {
        this.numeroSorteado = numeroSorteado;
        this.usuario = usuario;
    }

    public String getNumeroSorteado() {
        return numeroSorteado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getRegistradoEm() {
        return registradoEm;
    }
}
