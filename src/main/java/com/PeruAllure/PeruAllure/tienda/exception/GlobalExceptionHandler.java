package com.peruallure.peruallure.tienda.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejarExcepcionGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocurrió un error inesperado: " + ex.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> manejarExcepcionUsuarioNoEncontrado(UsernameNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: " + ex.getMessage());
    }
}
