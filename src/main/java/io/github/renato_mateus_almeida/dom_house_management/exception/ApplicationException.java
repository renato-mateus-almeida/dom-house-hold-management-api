package io.github.renato_mateus_almeida.dom_house_management.exception;

public class ApplicationException extends Exception {
    private final String method;

    public ApplicationException(String method, String message) {
        super(message);
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    
}
