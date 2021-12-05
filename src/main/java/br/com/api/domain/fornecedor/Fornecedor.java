package br.com.api.domain.fornecedor;

import br.com.api.domain.Situacao;
import br.com.api.domain.produto.Produto;

import java.util.List;

public class Fornecedor {
    private final Long codigo;
    private final String descricao;
    private final CNPJ cnpj;
    private final List<Produto> produtos;
    private Situacao situacao;

    public Fornecedor(Long codigo, String descricao, CNPJ cnpj, List<Produto> produtos, Situacao situacao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.produtos = produtos;
        this.situacao = situacao;
    }

    public void desabilitar() {
        situacao = Situacao.INATIVO;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public CNPJ getCnpj() {
        return cnpj;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Situacao getSituacao() {
        return situacao;
    }
}
