package com.electroapp.electro_app.infraestructure.excepcioncontroller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.electroapp.electro_app.infraestructure.models.exception.ErrorCustom;


@RestControllerAdvice
public class HandlerExceptionController {

     @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<ErrorCustom> divisionByZero(Exception ex) {

        ErrorCustom error = new ErrorCustom();
        error.setDate(new java.sql.Date(new Date().getTime()));
        error.setError("Error division por cero!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorCustom> notFoundEx(NoResourceFoundException e) { 
        ErrorCustom error = new ErrorCustom();
        error.setDate(new java.sql.Date(new Date().getTime()));
        error.setError("Api rest no encontrado");
        error.setMessage(e.getMessage());

        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "numero invalido o incorrecto, no tiene formato de digito!");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class,CountryNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception ex){

        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "el usuario o role no existe!");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }
}
