package br.com.api.domain.factories;

import br.com.api.domain.Situacao;
import br.com.api.domain.fornecedor.CNPJ;
import br.com.api.domain.fornecedor.Fornecedor;
import br.com.api.domain.produto.Produto;
import br.com.api.infra.validation.ValidadorCNPJStella;

import java.util.ArrayList;

public class FornecedorFactory {
    public Fornecedor geraValido() {
        var validador = new ValidadorCNPJStella();
        var cnpj = new CNPJ(validador, "03.778.130/0001-48");
        var produtos = new ArrayList<Produto>();
        return new Fornecedor(1L, "Teste", cnpj, produtos, Situacao.ATIVO);
    }
}
