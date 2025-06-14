package br.com.nobre.minibank_api.commons.exception;

import br.com.nobre.minibank_api.commons.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> notFoundException(NotFoundException notFoundException) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(notFoundException.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

}
