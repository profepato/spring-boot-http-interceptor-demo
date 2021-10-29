package com.example.demo.config;

import com.example.demo.model.exceptions.NotAllowedHttpMethodException;
import com.example.demo.model.NotAllowedHttpMethodResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(NotAllowedHttpMethodException.class)
    public ResponseEntity<Object> handler(NotAllowedHttpMethodException notAllowedHttpMethodException){
        NotAllowedHttpMethodResponse notAllowedHttpMethodResponse = new NotAllowedHttpMethodResponse();
        String message = notAllowedHttpMethodException.getMessage();
        notAllowedHttpMethodResponse.setError(message);
        return ResponseEntity.badRequest().body(notAllowedHttpMethodResponse);
    }
}
