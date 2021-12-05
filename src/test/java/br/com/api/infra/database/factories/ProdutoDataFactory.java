package br.com.api.infra.database.factories;

import br.com.api.domain.Situacao;
import br.com.api.infra.database.orm.ProdutoData;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProdutoDataFactory {
    private FornecedorDataFactory fornecedorDataFactory;

    public ProdutoDataFactory() {
        this.fornecedorDataFactory = new FornecedorDataFactory();
    }

    public ProdutoData geraValido() {
        var fornecedor = fornecedorDataFactory.geraValido();
        var dataFabricacao = LocalDate.now().minus(1L, ChronoUnit.DAYS);
        var dataValidade = LocalDate.now();
        return new ProdutoData(1L, "Vidro", dataFabricacao, dataValidade, Situacao.ATIVADO, fornecedor);
    }
}
