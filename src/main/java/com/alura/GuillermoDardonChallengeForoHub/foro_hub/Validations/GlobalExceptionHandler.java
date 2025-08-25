package com.alura.GuillermoDardonChallengeForoHub.foro_hub.Validations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacionTopicoException.class)
    public ResponseEntity<String> handleValidacionTituloRepetido(ValidacionTopicoException e){

        return ResponseEntity.badRequest().body(e.getErrorMessage());
    }

}

