package br.com.api.application.responses;

public class FormErrorResponse {
    private String error;
    private String campo;

    public FormErrorResponse() {
    }

    public FormErrorResponse(String error, String field) {
        this.error = error;
        this.campo = field;
    }

    public String getError() {
        return error;
    }

    public String getCampo() {
        return campo;
    }
}
