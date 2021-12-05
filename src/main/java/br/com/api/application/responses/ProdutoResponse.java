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

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Long getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(Long codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
