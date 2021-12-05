package br.com.api.domain.fornecedor;

import br.com.api.infra.validation.ValidadorCNPJStella;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CNPJTest {
    private final static String CNPJ_VALIDO = "26.637.142/0001-58";
    private final static String CNPJ_INVALIDO = "261.637.142/0001-58";
    private ValidadorCNPJ validador;

    @BeforeEach
    public void setUp() {
        validador = new ValidadorCNPJStella();
    }

    @Test
    void deveriaCriarCNPJ() {
        assertAll(() -> new CNPJ(validador, CNPJ_VALIDO));
    }

    @Test
    void deveriaLancarCNPJInvalido() {
        assertThrows(CNPJInvalido.class, () -> new CNPJ(validador, CNPJ_INVALIDO));
    }
}
