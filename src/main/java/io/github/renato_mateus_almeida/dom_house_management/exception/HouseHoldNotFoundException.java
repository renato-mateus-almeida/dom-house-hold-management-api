package io.github.renato_mateus_almeida.dom_house_management.exception;

public class HouseHoldNotFoundException extends ApplicationException {

    public HouseHoldNotFoundException(String method, Long id) {
        super(method, "HouseHold not found: " + id);
    }
    
}
