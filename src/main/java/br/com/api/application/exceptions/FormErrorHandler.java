package br.com.api.application.exceptions;

import br.com.api.application.responses.FormErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FormErrorHandler {
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FormErrorResponse> handle(MethodArgumentNotValidException exception) {
        var dtos = new ArrayList<FormErrorResponse>();

        var fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            FormErrorResponse formError = null;

            if (messageSource != null) {
                var message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
                formError = new FormErrorResponse(e.getField(), message);
            } else {
                formError = new FormErrorResponse(e.getField(), "Valor inválido");
            }

            dtos.add(formError);
        });

        return dtos;
    }
}
