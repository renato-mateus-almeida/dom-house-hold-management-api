package io.github.renato_mateus_almeida.dom_house_management.exception;

public class RoomNotFoundException extends NotFoundException {

    public RoomNotFoundException(String method, Long id) {
        super(method,"Room not found: " + id);
    }
    
}
