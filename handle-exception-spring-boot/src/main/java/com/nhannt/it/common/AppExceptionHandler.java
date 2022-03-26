package com.nhannt.it.common;

import com.nhannt.it.exception.CustomException;
import com.nhannt.it.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String errorMessageDes = ex.getLocalizedMessage();
        //if the message that is parameter of Exception null
        if (errorMessageDes == null)
            errorMessageDes = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDes);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { NullPointerException.class })
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        String errorMessageDes = ex.getLocalizedMessage();
        if (errorMessageDes == null)
            errorMessageDes = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDes);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { CustomException.class })
    public ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest request) {
        String errorMessageDes = ex.getLocalizedMessage();
        if (errorMessageDes == null)
            errorMessageDes = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDes);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
