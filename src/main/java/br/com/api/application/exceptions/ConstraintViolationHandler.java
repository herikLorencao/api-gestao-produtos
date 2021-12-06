package br.com.api.application.exceptions;

import br.com.api.application.responses.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ConstraintViolationHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorResponse handle(Exception exception) {
        return new ErrorResponse("Não foi possível inserir o registro em nossa base de dados",
                "Verifique a integridade dos dados");
    }
}
