package com.dharbor.sales.services;

import com.dharbor.sales.clients.NotificationsFeignClient;
import com.dharbor.sales.exceptions.CustomFeignException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Joel Guzman
 **/
@Service
@RequiredArgsConstructor
public class NotificationFeignService {

    private final NotificationsFeignClient notificationsFeignClient;

    public String sendNotification(String userId) {
        try {
            return notificationsFeignClient.sendNotification(userId);
        } catch (FeignException e) {
            throw new CustomFeignException(e.getMessage(), e.status());
        }
    }
}
