package br.com.api.domain.factories;

import br.com.api.domain.Situacao;
import br.com.api.domain.fornecedor.Fornecedor;
import br.com.api.domain.produto.Produto;

import java.util.ArrayList;

public class FornecedorFactory {
    public Fornecedor geraValido() {
        var produtos = new ArrayList<Produto>();
        return new Fornecedor(1L, "Teste", "03.778.130/0001-48", produtos, Situacao.ATIVO);
    }
}
