package br.com.api.domain.fornecedor;

public class FornecedorInativo extends RuntimeException {
    public FornecedorInativo(Long codigo) {
        super("O fornecedor com código: " + codigo + " não foi encontrado na base de dados");
    }
}
