package com.dharbor.sales.clients;

import com.dharbor.sales.config.FeignClientConfig;
import com.dharbor.sales.model.rest.ProductReservationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-service", configuration = FeignClientConfig.class)
public interface StockFeignClient {

    @PostMapping("/products/reserve")
    String reserve(@RequestBody ProductReservationRequest request);
}
