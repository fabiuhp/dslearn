package com.devsuperior.dslearnbds.resources.exceptions;

import com.devsuperior.dslearnbds.services.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest httpServletRequest) {
        StandardError error = new StandardError();
        error.setTimeStamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Recurso não encontrado");
        error.setMessage(e.getMessage());
        error.setPath(httpServletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> integrityViolation(DatabaseException e, HttpServletRequest httpServletRequest) {
        StandardError error = new StandardError();
        error.setTimeStamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Ocorreu uma violação de integridade do banco");
        error.setMessage(e.getMessage());
        error.setPath(httpServletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> invalidArgument(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {
        ValidationError error = new ValidationError();
        error.setTimeStamp(Instant.now());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setError("Ocorreu um problema com a validação dos campos");
        error.setMessage(e.getMessage());
        error.setPath(httpServletRequest.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            error.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<OAuthCustomError> forbidden(ForbiddenException e, HttpServletRequest httpServletRequest) {
        OAuthCustomError error = new OAuthCustomError("Forbidden", e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<OAuthCustomError> unauthorized(UnauthorizedException e, HttpServletRequest httpServletRequest) {
        OAuthCustomError error = new OAuthCustomError("Unauthorized", e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
