package io.github.renato_mateus_almeida.dom_house_management.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.github.renato_mateus_almeida.dom_house_management.infra.dto.ExceptionMessageDTO;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    private ResponseEntity<ExceptionMessageDTO> handleApplicationException(ApplicationException ex) {
        return ResponseEntity.badRequest().body(new ExceptionMessageDTO(ex.getMethod(), ex.getMessage()));
    }
    
}

