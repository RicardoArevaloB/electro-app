package com.electroapp.electro_app.infraestructure.excepcioncontroller;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String message) {
        super(message);
    }

}
