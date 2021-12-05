package br.com.api.infra.validation;

import br.com.api.domain.fornecedor.ValidadorCNPJ;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidadorCNPJStella implements ValidadorCNPJ {
    @Override
    public boolean cnpjValido(String cnpj) {
        var validador = new CNPJValidator(true);

        try {
            validador.assertValid(cnpj);
        } catch (InvalidStateException e) {
            return false;
        }

        return true;
    }
}
