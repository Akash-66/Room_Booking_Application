package com.sweethome.booking.exception;

public class InvalidPaymentModeException extends RuntimeException{

    private static final long serialVersionUID = 2L;

    public InvalidPaymentModeException(String message) {
        super(message);
    }
}
