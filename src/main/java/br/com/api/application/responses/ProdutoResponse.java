package br.com.api.application.responses;

import br.com.api.domain.Situacao;

import java.time.LocalDate;

public class ProdutoResponse {
    private Long codigo;
    private String descricao;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private Long codigoFornecedor;
    private Situacao situacao;

    public ProdutoResponse() {
    }

    public ProdutoResponse(Long codigo, String descricao, LocalDate dataFabricacao, LocalDate dataValidade, Long codigoFornecedor, Situacao situacao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.codigoFornecedor = codigoFornecedor;
        this.situacao = situacao;
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

    public Situacao getSituacao() {
        return situacao;
    }
}
