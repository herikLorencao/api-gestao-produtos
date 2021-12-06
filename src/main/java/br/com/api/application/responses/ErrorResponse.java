package br.com.api.application.responses;

public class ErrorResponse {
    private String erro;
    private String causa;

    public ErrorResponse() {
    }

    public ErrorResponse(String erro, String causa) {
        this.erro = erro;
        this.causa = causa;
    }

    public String getErro() {
        return erro;
    }

    public String getCausa() {
        return causa;
    }
}
