package com.dharbor.sales.services;

import com.dharbor.sales.clients.UsersFeignClient;
import com.dharbor.sales.exceptions.CustomFeignException;
import com.dharbor.sales.model.User;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Joel Guzman
 **/
@Service
@RequiredArgsConstructor
public class UserFeignService {

    private final UsersFeignClient usersFeignClient;

    public User findById(UUID userId) {
        try {
            return usersFeignClient.findById(userId);
        } catch (FeignException e) {
            throw new CustomFeignException(e.getMessage(), e.status());
        }
    }
}
