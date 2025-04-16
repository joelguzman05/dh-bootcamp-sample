package com.dharbor.sales.config;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * Joel Guzman
 **/
public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        return defaultDecoder.decode(methodKey, response);
    }
}