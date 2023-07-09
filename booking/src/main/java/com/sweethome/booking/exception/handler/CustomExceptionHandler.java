package com.sweethome.booking.exception.handler;

import com.sweethome.booking.exception.InvalidPaymentModeException;
import com.sweethome.booking.exception.InvalidResourceException;
import com.sweethome.booking.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity handleRecordNotFoundException(ResourceNotFoundException e, WebRequest req){

        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("message", e.getMessage());
        responseBody.put("statusCode", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity(responseBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPaymentModeException.class)
    public final  ResponseEntity handleInvalidPaymentModeException(InvalidPaymentModeException e, WebRequest req){

        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("message", e.getMessage());
        responseBody.put("statusCode", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity(responseBody, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidResourceException.class)
    public final ResponseEntity handleMethodArgumentNotValid(InvalidResourceException e, WebRequest request){

        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("message", e.getMessage());
        responseBody.put("statusCode", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity(responseBody, HttpStatus.BAD_REQUEST);
    }
}
