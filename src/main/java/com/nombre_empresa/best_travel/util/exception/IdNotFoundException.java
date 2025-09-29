package com.nombre_empresa.best_travel.util.exception;

public class IdNotFoundException extends RuntimeException {
    private static String ERROR_MESSAGE = "Record no exist in %s";

    public IdNotFoundException(String tableName) {
        super(String.format(ERROR_MESSAGE, tableName));
    }
}
