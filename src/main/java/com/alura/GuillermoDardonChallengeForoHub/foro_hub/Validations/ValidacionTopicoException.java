package com.alura.GuillermoDardonChallengeForoHub.foro_hub.Validations;

public class ValidacionTopicoException extends RuntimeException implements ValidationException {

    private final String message;

    public ValidacionTopicoException(String message) {
        this.message = message;
    }


    @Override
    public String getErrorMessage() {
        return message;
    }
}


