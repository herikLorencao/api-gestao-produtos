package br.com.api.domain.factories;

import br.com.api.domain.Situacao;
import br.com.api.domain.produto.Produto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProdutoFactory {
    private FornecedorFactory fornecedorFactory = new FornecedorFactory();

    public Produto geraValido() {
        var fornecedor = fornecedorFactory.geraValido();
        var dataFabricacao = LocalDate.now().minus(1L, ChronoUnit.DAYS);
        var dataValidade = LocalDate.now();
        return new Produto(1L, "Vidro", dataFabricacao, dataValidade, fornecedor, Situacao.ATIVADO);
    }
}
