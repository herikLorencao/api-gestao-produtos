package br.com.api.application.responses;

public class FornecedorResponse {
    private Long codigo;
    private String descricao;
    private String cnpj;

    public FornecedorResponse() {
    }

    public FornecedorResponse(Long codigo, String descricao, String cnpj) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.cnpj = cnpj;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCnpj() {
        return cnpj;
    }
}
