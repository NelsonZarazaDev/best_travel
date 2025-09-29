package com.nombre_empresa.best_travel.api.controllers.error_handler;

import com.nombre_empresa.best_travel.api.models.responses.BaseErrorResponse;
import com.nombre_empresa.best_travel.api.models.responses.ErrorResponse;
import com.nombre_empresa.best_travel.util.exception.ForBiddenCustomerException;
import com.nombre_empresa.best_travel.util.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForddibenCustomerHandler {

    @ExceptionHandler(ForBiddenCustomerException.class)
    public BaseErrorResponse handleIdNotFound(ForBiddenCustomerException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.FORBIDDEN.name())
                .code(HttpStatus.FORBIDDEN.value())
                .build();
    }
}
