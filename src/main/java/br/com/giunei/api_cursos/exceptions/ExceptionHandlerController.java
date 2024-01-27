package br.com.giunei.api_cursos.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ErrorMessageDto>> handleMethodArgumentNotValidException(ConstraintViolationException e) {
        List<ErrorMessageDto> dto = new ArrayList<>();

        e.getConstraintViolations().forEach(err -> {
            ErrorMessageDto error = new ErrorMessageDto(err.getMessage(), err.getPropertyPath().toString());
            dto.add(error);
        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
