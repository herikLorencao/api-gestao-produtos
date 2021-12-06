package br.com.api.domain.fornecedor;

public class FornecedorInativo extends RuntimeException {
    public FornecedorInativo(Long codigo) {
        super("O fornecedor com id: " + codigo + " não foi encontrado na base de dados");
    }
}
