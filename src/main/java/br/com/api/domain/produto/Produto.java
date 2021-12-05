package br.com.api.domain.produto;

import br.com.api.domain.Situacao;
import br.com.api.domain.fornecedor.Fornecedor;

import java.time.LocalDate;

public class Produto {
    private Long codigo;
    private String descricao;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private Fornecedor fornecedor;
    private Situacao situacao;

    public Produto() {
    }

    public Produto(Long codigo, String descricao, LocalDate dataFabricacao, LocalDate dataValidade,
                   Fornecedor fornecedor, Situacao situacao) {
        if (!datasFabricacaoValidadeSaoValidas(dataFabricacao, dataValidade))
            throw new DatasInvalidas(this);

        this.codigo = codigo;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.fornecedor = fornecedor;
        this.situacao = situacao;
    }

    public void desativar() {
        situacao = Situacao.INATIVO;
    }

    private boolean datasFabricacaoValidadeSaoValidas(LocalDate dataFabricacao, LocalDate dataValidade) {
        return dataFabricacao.isBefore(dataValidade);
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Situacao getSituacao() {
        return situacao;
    }
}
