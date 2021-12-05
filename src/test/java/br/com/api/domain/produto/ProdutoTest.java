package br.com.api.domain.produto;

import br.com.api.domain.Situacao;
import br.com.api.domain.factories.FornecedorFactory;
import br.com.api.domain.factories.ProdutoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProdutoTest {
    private ProdutoFactory produtoFactory;
    private FornecedorFactory fornecedorFactory;

    @BeforeEach
    void setUp() {
        produtoFactory = new ProdutoFactory();
        fornecedorFactory = new FornecedorFactory();
    }

    @Test
    void deveriaRetornarDataInvalidaQuandoDataFabricacaoIgualDataValidade() {
        var fornecedor = fornecedorFactory.geraValido();
        var data = LocalDate.now();

        assertThrows(DatasInvalidas.class, () -> {
            new Produto(1L, "Vidro", data, data, fornecedor, Situacao.ATIVADO);
        });
    }

    @Test
    void deveriaRetornarDataInvalidaQuandoDataFabricacaoMenorDataValidade() {
        var fornecedor = fornecedorFactory.geraValido();
        var data = LocalDate.now();
        var diaAnterior = LocalDate.now().minus(1L, ChronoUnit.DAYS);

        assertThrows(DatasInvalidas.class, () -> {
            new Produto(1L, "Vidro", data, diaAnterior, fornecedor, Situacao.ATIVADO);
        });
    }

    @Test
    void deveriaDesabilitarProduto() {
        var produto = produtoFactory.geraValido();

        produto.desativar();

        assertEquals(Situacao.DESATIVADO, produto.getSituacao());
    }
}
