package br.com.api.infra.database.orm;

import br.com.api.domain.Situacao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "produtos")
public class ProdutoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_fabricacao")
    private LocalDate dataFabricacao;

    @Column(name = "data_validade")
    private LocalDate dataValidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private Situacao situacao;

    @ManyToOne
    private FornecedorData fornecedor;

    public ProdutoData() {
    }

    public ProdutoData(Long codigo, String descricao, LocalDate dataFabricacao, LocalDate dataValidade, Situacao situacao, FornecedorData fornecedor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.situacao = situacao;
        this.fornecedor = fornecedor;
    }

    public FornecedorData getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorData fornecedorData) {
        this.fornecedor = fornecedorData;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProdutoData that = (ProdutoData) o;
        return Objects.equals(codigo, that.codigo)
                && Objects.equals(descricao, that.descricao)
                && Objects.equals(dataFabricacao, that.dataFabricacao)
                && Objects.equals(dataValidade, that.dataValidade)
                && situacao == that.situacao
                && Objects.equals(fornecedor, that.fornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricao, dataFabricacao, dataValidade, situacao, fornecedor);
    }
}
