package br.com.api.application.exceptions;

import br.com.api.application.responses.ErrorResponse;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ObjectNotFoundHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ErrorResponse handle(ObjectNotFoundException exception) {
        return new ErrorResponse("O recurso não foi encontrado", exception.getEntityName() + " | ID: "
                + exception.getIdentifier());
    }
}
