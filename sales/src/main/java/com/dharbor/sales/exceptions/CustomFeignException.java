package com.dharbor.sales.exceptions;

import lombok.Getter;

/**
 * Joel Guzman
 **/
@Getter
public class CustomFeignException extends RuntimeException {

    private final int status;

    public CustomFeignException(String message, int status) {
        super(message);
        this.status = status;
    }
}