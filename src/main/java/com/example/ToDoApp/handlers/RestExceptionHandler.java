package com.example.ToDoApp.handlers;

import com.example.ToDoApp.exception.EntityNotFoundException;
import com.example.ToDoApp.exception.InvalidEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /* @ExceptionHandler(EntityNotFoundException.class)
     public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest) {
         logger.error(exception);
         final HttpStatus notFound = HttpStatus.NOT_FOUND;
         final ErrorDto errorDto = ErrorDto.builder()
                 .code(exception.getErrorCode())
                 .httpCode(notFound.value())
                 .message(exception.getMessage())
                 .build();

         return new ResponseEntity<>(errorDto, notFound);
     }

     @ExceptionHandler(InvalidEntityException.class)
     public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest) {
         logger.error(exception);
         final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
         final ErrorDto errorDto = ErrorDto.builder()
                 .code(exception.getErrorCode())
                 .httpCode(badRequest.value())
                 .message(exception.getMessage())
                 .errors(exception.getErrors())
                 .build();

         return new ResponseEntity<>(errorDto, badRequest);
     }
 */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest) {
        logger.error(exception);
        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(exception.getErrorCode());
        errorDto.setHttpCode(notFound.value());
        errorDto.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest) {
        logger.error(exception);
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(exception.getErrorCode());
        errorDto.setHttpCode(badRequest.value());
        errorDto.setMessage(exception.getMessage());
        errorDto.setErrors(exception.getErrors());

        return new ResponseEntity<>(errorDto, badRequest);
    }
}