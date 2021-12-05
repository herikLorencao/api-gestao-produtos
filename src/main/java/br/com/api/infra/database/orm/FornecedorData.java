package br.com.api.infra.database.orm;

import br.com.api.domain.Situacao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "fornecedores")
public class FornecedorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "cnpj")
    private String cnpj;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private Situacao situacao;

    @OneToMany(mappedBy = "fornecedor", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProdutoData> produtos = new ArrayList<>();

    public FornecedorData() {
    }

    public FornecedorData(Long codigo, String descricao, String cpnj, Situacao situacao, List<ProdutoData> produtos) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.cnpj = cpnj;
        this.situacao = situacao;
        this.produtos = produtos;
    }

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cpnj) {
        this.cnpj = cpnj;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public List<ProdutoData> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoData> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FornecedorData that = (FornecedorData) o;
        return Objects.equals(codigo, that.codigo)
                && Objects.equals(descricao, that.descricao)
                && Objects.equals(cnpj, that.cnpj)
                && situacao == that.situacao
                && Objects.equals(produtos, that.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricao, cnpj, situacao, produtos);
    }
}
