package io.github.renato_mateus_almeida.dom_house_management.exception;

public class NotFoundException extends Exception {
    private final String method;

    public NotFoundException(String method, String message) {
        super(message);
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    
}
