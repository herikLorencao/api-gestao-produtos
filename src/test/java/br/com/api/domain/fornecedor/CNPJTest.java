package br.com.api.domain.fornecedor;

import br.com.api.infra.validation.ValidadorCNPJStella;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CNPJTest {
    private ValidadorCNPJ validador;

    @BeforeEach
    public void setUp() {
        validador = new ValidadorCNPJStella();
    }

    @Test
    void deveriaCriarCNPJ() {
        assertAll(() -> new CNPJ(validador, "26.637.142/0001-58"));
    }

    @Test
    void deveriaLancarCNPJInvalido() {
        assertThrows(CNPJInvalido.class, () -> new CNPJ(validador, "03.778.13/0001-48"));
    }
}
