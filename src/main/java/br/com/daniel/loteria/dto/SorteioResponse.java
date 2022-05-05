package br.com.daniel.loteria.dto;

import br.com.daniel.loteria.model.Sorteio;

public class SorteioResponse {

    private Long id;

    private String nome;

    private String numero;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public SorteioResponse(Sorteio sorteio) {
        this.id = sorteio.getId();
        this.nome = sorteio.getUsuario().getNome();
        this.numero = sorteio.getNumeroSorteado();
    }
}
