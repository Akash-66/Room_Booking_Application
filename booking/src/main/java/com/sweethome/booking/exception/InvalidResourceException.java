package com.sweethome.booking.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;

public class InvalidResourceException extends RuntimeException{
    private static final long serialVersionUID = 3L;

    public InvalidResourceException(String message) {
        super(message);
    }
}
