package br.com.api.application.requests;

public class FornecedorRequest {
    private String descricao;
    private String cnpj;

    public FornecedorRequest() {
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCnpj() {
        return cnpj;
    }
}
