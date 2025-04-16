package com.dharbor.sales.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Joel Guzman
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SaleNotCompletedException.class)
    public ResponseEntity<String> handleSaleNotCompletedException(SaleNotCompletedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(CustomFeignException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomFeignException(CustomFeignException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(ex.getStatus(), ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(errorResponse);
    }
}
