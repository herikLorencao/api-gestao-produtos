package br.com.api.infra.database.factories;

import br.com.api.domain.Situacao;
import br.com.api.infra.database.orm.ProdutoData;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {
    private FornecedorDataFactory fornecedorDataFactory;

    public ProdutoDataFactory() {
        this.fornecedorDataFactory = new FornecedorDataFactory();
    }

    public ProdutoData geraValido() {
        var fornecedor = fornecedorDataFactory.geraValido();
        var dataFabricacao = LocalDate.now().minus(1L, ChronoUnit.DAYS);
        var dataValidade = LocalDate.now();
        return new ProdutoData(1L, "Vidro", dataFabricacao, dataValidade, Situacao.ATIVO, fornecedor);
    }

    public ProdutoData geraValido(Long id) {
        var fornecedor = fornecedorDataFactory.geraValido();
        var dataFabricacao = LocalDate.now().minus(1L, ChronoUnit.DAYS);
        var dataValidade = LocalDate.now();
        return new ProdutoData(id, "Produto " + id, dataFabricacao, dataValidade, Situacao.ATIVO, fornecedor);
    }

    public ProdutoData geraInativo() {
        var fornecedor = fornecedorDataFactory.geraValido();
        var dataFabricacao = LocalDate.now().minus(1L, ChronoUnit.DAYS);
        var dataValidade = LocalDate.now();
        return new ProdutoData(1L, "Vidro", dataFabricacao, dataValidade, Situacao.INATIVO, fornecedor);
    }

    public List<ProdutoData> geraLista() {
        var produtos = new ArrayList<ProdutoData>();

        for (int i = 0; i < 10; i++) {
            var codigo = i + 1;
            produtos.add(geraValido((long) codigo));
        }

        return produtos;
    }
}
