package br.com.nobre.minibank_api.commons.exception;

public class NotFoundException extends Exception {

    private String message;

    public NotFoundException(String message) {
        super(message);
    }

}
