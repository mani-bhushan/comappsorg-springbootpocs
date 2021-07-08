package com.apps.org.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apps.org.handler.CustomExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);
    
    @ExceptionHandler(value = { CustomExceptionHandler.class })
    public ResponseEntity<?> handleException(CustomExceptionHandler ex) {
    	logger.error("Exception: ", ex.getMessage());
        return new ResponseEntity<>(ex, ex.getHttpStatus());
    }
   
}