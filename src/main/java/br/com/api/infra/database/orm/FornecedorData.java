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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "cpnj")
    private String cpnj;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private Situacao situacao;

    @OneToMany(mappedBy = "fornecedor", orphanRemoval = true)
    private List<ProdutoData> produtos = new ArrayList<>();

    public FornecedorData() {
    }

    public FornecedorData(Long id, String descricao, String cpnj, Situacao situacao, List<ProdutoData> produtos) {
        this.id = id;
        this.descricao = descricao;
        this.cpnj = cpnj;
        this.situacao = situacao;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
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
        return Objects.equals(id, that.id)
                && Objects.equals(descricao, that.descricao)
                && Objects.equals(cpnj, that.cpnj)
                && situacao == that.situacao
                && Objects.equals(produtos, that.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, cpnj, situacao, produtos);
    }
}