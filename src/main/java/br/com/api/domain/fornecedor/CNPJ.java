package br.com.api.domain.fornecedor;

public class CNPJ {
    private final String valor;

    public CNPJ(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
