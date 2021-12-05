package br.com.api.domain.fornecedor;

public class CNPJ {
    private final String valor;

    public CNPJ(ValidadorCNPJ validador, String valor) {
        if (!validador.cnpjValido(valor))
            throw new CNPJInvalido(valor);

        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
