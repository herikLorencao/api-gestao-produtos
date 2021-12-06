package br.com.api.application.responses;

import java.time.LocalDate;

public class ProdutoResponse {
    private Long codigo;
    private String descricao;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private Long codigoFornecedor;

    public ProdutoResponse() {
    }

    public ProdutoResponse(Long codigo, String descricao, LocalDate dataFabricacao, LocalDate dataValidade, Long codigoFornecedor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.codigoFornecedor = codigoFornecedor;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public Long getCodigoFornecedor() {
        return codigoFornecedor;
    }
}
