package com.lapin.shopper.configuration;

import com.lapin.shopper.dto.ErrorResponse;
import com.lapin.shopper.exceptions.Code400Exception;
import com.lapin.shopper.exceptions.Code403Exception;
import com.lapin.shopper.exceptions.Code404Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (Code400Exception.class.isAssignableFrom(exception.getClass())){
            status = HttpStatus.BAD_REQUEST;
        }

        if (Code403Exception.class.isAssignableFrom(exception.getClass())){
            status = HttpStatus.FORBIDDEN;
        }

        if (Code404Exception.class.isAssignableFrom(exception.getClass())){
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(new ErrorResponse(status.name() , exception.getMessage()), status);
    }
}