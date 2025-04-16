package com.dharbor.sales.services;

import com.dharbor.sales.clients.StockFeignClient;
import com.dharbor.sales.exceptions.CustomFeignException;
import com.dharbor.sales.model.rest.ProductReservationRequest;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Joel Guzman
 **/
@Service
@RequiredArgsConstructor
public class StockFeignService {

    private final StockFeignClient stockFeignClient;

    public String reserve(ProductReservationRequest request) {
        try {
            return stockFeignClient.reserve(request);
        } catch (FeignException e) {
            throw new CustomFeignException(e.getMessage(), e.status());
        }
    }
}
