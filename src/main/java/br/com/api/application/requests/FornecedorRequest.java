package br.com.api.application.requests;

import br.com.api.domain.Situacao;

public class FornecedorRequest {
    private Long id;
    private String descricao;
    private String cnpj;
    private final Situacao situacao = Situacao.ATIVO;

    public FornecedorRequest() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCnpj() {
        return cnpj;
    }
}
