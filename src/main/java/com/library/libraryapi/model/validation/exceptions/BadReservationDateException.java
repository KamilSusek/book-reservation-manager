package com.library.libraryapi.model.validation.exceptions;

public class BadReservationDateException extends Exception {
    private final String message;
    private final int statusCode;

    public BadReservationDateException(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
