package br.com.api.domain.fornecedor;

import br.com.api.domain.Situacao;
import br.com.api.domain.factories.FornecedorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FornecedorTest {
    private FornecedorFactory fornecedorFactory;

    @BeforeEach
    public void setUp() {
        fornecedorFactory = new FornecedorFactory();
    }

    @Test
    void deveriaDesabilitarFornecedor() {
        var fornecedor = fornecedorFactory.geraValido();

        fornecedor.desabilitar();

        assertEquals(Situacao.DESATIVADO, fornecedor.getSituacao());
    }
}
