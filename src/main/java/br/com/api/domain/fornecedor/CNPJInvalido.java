package br.com.api.domain.fornecedor;

public class CNPJInvalido extends RuntimeException {
    public CNPJInvalido(String cnpj) {
        super("O CNPJ: " + cnpj + " não segue o formato XX.XXX.XXX/000X-XX");
    }
}
