package br.com.api.application.exceptions;

import br.com.api.application.responses.ErrorResponse;
import br.com.api.domain.produto.DatasInvalidas;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DatasInvalidasHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DatasInvalidas.class)
    public ErrorResponse handle(Exception exception) {
        return new ErrorResponse("O intervalo de datas informado é inválido", exception.getMessage());
    }
}
