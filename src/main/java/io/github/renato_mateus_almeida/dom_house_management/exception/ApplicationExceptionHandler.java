package io.github.renato_mateus_almeida.dom_house_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.github.renato_mateus_almeida.dom_house_management.infra.dto.ExceptionMessageDTO;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionMessageDTO> notFoundExceptionHandler(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionMessageDTO(ex.getMethod(), ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<ExceptionMessageDTO> IllegalArgumentExceptionHandler(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionMessageDTO("[POST|PUT]", ex.getMessage()));
    }
    
}

