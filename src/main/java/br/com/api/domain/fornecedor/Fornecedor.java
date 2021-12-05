package br.com.api.domain.fornecedor;

import br.com.api.domain.Situacao;
import br.com.api.domain.produto.Produto;

import java.util.List;

public class Fornecedor {
    private Long codigo;
    private String descricao;
    private String cnpj;
    private List<Produto> produtos;
    private Situacao situacao;

    public Fornecedor() {
    }

    public Fornecedor(Long codigo, String descricao, String cnpj, List<Produto> produtos, Situacao situacao) {
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

    public String getCnpj() {
        return cnpj;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Situacao getSituacao() {
        return situacao;
    }
}
