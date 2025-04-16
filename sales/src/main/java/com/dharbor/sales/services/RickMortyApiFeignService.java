package com.dharbor.sales.services;

import com.dharbor.sales.clients.RickMortyApiFeignClient;
import com.dharbor.sales.exceptions.CustomFeignException;
import com.dharbor.sales.model.rest.Character;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Joel Guzman
 **/
@Service
@RequiredArgsConstructor
public class RickMortyApiFeignService {

    private final RickMortyApiFeignClient rickMortyApiFeignClient;

    public Character findById(Integer id) {
        try {
            return rickMortyApiFeignClient.findById(id);
        } catch (FeignException e) {
            throw new CustomFeignException(e.getMessage(), e.status());
        }
    }
}
