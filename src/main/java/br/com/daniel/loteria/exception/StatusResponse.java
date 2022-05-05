package br.com.daniel.loteria.exception;

public class StatusResponse {

    private String campo;
    private String mensagem;


    public StatusResponse(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }


    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
