package br.com.api.infra.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorCNPJStellaTest {
    private final static String CNPJ_VALIDO = "26.637.142/0001-58";
    private final static String CNPJ_INVALIDO = "261.637.142/0001-58";

    @Test
    void deveriaRetornarCNPJValido() {
        var validador = new ValidadorCNPJStella();
        assertTrue(validador.cnpjValido(CNPJ_VALIDO));
    }

    @Test
    void deveriaRetornarCNPJInvalido() {
        var validador = new ValidadorCNPJStella();
        assertFalse(validador.cnpjValido(CNPJ_INVALIDO));
    }
}
