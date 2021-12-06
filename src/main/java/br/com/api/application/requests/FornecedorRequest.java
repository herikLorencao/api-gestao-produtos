package br.com.api.application.requests;

import br.com.api.domain.Situacao;
import br.com.caelum.stella.bean.validation.CNPJ;

public class FornecedorRequest {
    private Long codigo;
    private String descricao;
    @CNPJ(formatted = true, message = "CNPJ inválido")
    private String cnpj;
    private final Situacao situacao = Situacao.ATIVO;

    public FornecedorRequest() {
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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
